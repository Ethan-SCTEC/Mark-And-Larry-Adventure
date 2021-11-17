package tilegame.entities;

import java.awt.Graphics;

import tilegame.Handler;

//our entity framework! abstract classes are essentially frameworks for subclasses.
//all creatures, and by extension, players will use this framework
public abstract class Entity {
	
	protected Handler handler;
	protected float x, y;
	protected int width, height;
	
	//creates an entity at position x,y, with the width of width and height of height
	public Entity(Handler handler,float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	//getters and setters
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
