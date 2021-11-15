

package tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import tilegame.states.*;
import tilegame.display.Display;
import tilegame.gfx.*;
import tilegame.input.KeyManager;

//implements runnable means creating threads
public class Game implements Runnable{
	
	//creating a Display, the window
	private Display display;
	public int width, height;
	public String title;
	
	//creating a thread
	private Thread thread;
	private boolean running = false;
	
	//buffered strategy and a graphics object
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	private State gameState;
	//private State menuState;
	
	//input
	private KeyManager keyManager;
	
	/**
	*Initializes the game class. The game will be used for the general window.
	*
	*@param title a String that will be used as the name for the window
	*@param width an int that will determine how many pixels the window is across
	*@param height an int that will determine the height, in pixels, of the window.
	*/
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	/**
	 * Creates the display and initializes the Assets class.
	 * Also, sets the state to gameState, this is temporary, and will, in the future, set the state to menuSate,
	 * This method takes in no parameters, and returns nothing.
	 * 
	 */
	private void init() {
		display = new Display(title,width,height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameState = new GameState(this);
		//menuState = new MenuState(this);
		State.setState(gameState);
		
	}
	
	/*
	 * This is our update function for the game class.
	 * this essentially, at this point, updates the input and the state.
	 */
	private void tick() {
		
		keyManager.tick();
		
		if(State.getState() != null) {
			State.getState().tick();
		}
	}
	
	//this render method is going to, every frame, draw an image to the bufferedStrategy
	//it will show, then get rid of the frame.
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		//clear screen
		g.clearRect(0, 0, width, height);
		//Draw Here
		
		if(State.getState() != null) {
			State.getState().render(g);
		}
		
		//End drawing
		bs.show();
		g.dispose();
	}
	
	public void run() {
		
		init();
		
		
		
		//amount of times to call tick and render every seconds
		int fps = 60;
		//maximum amount of time in nanoseconds that we have to execute tick and render to acheive fps
		double timePerTick = 1000000000 / fps;
		//amount of time we had until we call tick and render again
		double delta = 0;
		//current time of computer
		long now;
		//last time that the block of code below ran
		long lastTime = System.nanoTime();
		long timer = 0;
		//int ticks = 0;
		
		while(running) {
			
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			//checks to see if time to render
			if(delta >= 1) {
				tick();
				render();
				//ticks++;
				delta--;
			}
			
			//tells us the amount of tick in one second
			if(timer>= 1000000000){
				//System.out.println("Ticks and Frames: " + ticks);
				//ticks =0;
				timer = 0;
			}
			
		
			
		}
		stop();
	}
	
	//geter for the key manager
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	//starts
	public synchronized void start() {
		if(running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	//stops
	public synchronized void stop() {
		if(!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
