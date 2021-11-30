package tilegame.entities.creatures;

import tilegame.Handler;
import tilegame.gfx.Assets;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player extends Creature{

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 20;
		bounds.y = 24;
		bounds.width = 24;
		bounds.height = 32;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;
		int keyDown = handler.getKeyManager().getLastKeyHeld();
		

		switch(keyDown) {
		case KeyEvent.VK_UP:
			yMove -= speed;
			break;
		case KeyEvent.VK_DOWN:
			yMove += speed;
			break;
		case KeyEvent.VK_LEFT:
			xMove -= speed;
			break;
		case KeyEvent.VK_RIGHT:
			xMove += speed;
			break;
		case KeyEvent.VK_W:
			yMove -= speed;
			break;
		case KeyEvent.VK_S:
			yMove += speed;
			break;
		case KeyEvent.VK_A:
			xMove -= speed;
			break;
		case KeyEvent.VK_D:
			xMove += speed;
			break;
		default:
			xMove = 0;
			yMove = 0;
			break;
		
		}
		
		
	}
	
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.bob,(int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()),width,height,null);
		
		//draw player collision box
		//g.setColor(Color.red);
		//g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),(int) (y + bounds.y - handler.getGameCamera().getyOffset()),bounds.width,bounds.height);
	}

}
