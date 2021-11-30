package tilegame.entities.creatures;

import tilegame.Handler;
import tilegame.entities.Entity;
import tilegame.tiles.Tile;

public abstract class Creature extends Entity {

	protected int health;
	
	//these are fun, I explain hem in player
	protected float speed;
	protected float xMove, yMove;
	
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 4.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64,
							DEFAULT_CREATURE_HEIGHT = 64;
	
	
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0; 
		yMove = 0;
	}

	public void move() {
		moveX();
		moveY();
	}
	
	public void moveX() {
		
		int tx = 0;
		if(xMove>0) {
			
			tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			
		}else if(xMove <0) {
			
			tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
			
		}
		
		if(!collisionWithTile(tx,(int) (y+bounds.y) / Tile.TILEHEIGHT) &&
				!collisionWithTile(tx,(int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
			x+= xMove;
		}
	}
	
	public void moveY() {
		
		int ty= 0;
		if(yMove <0) {
			ty = (int) (y+yMove + bounds.y) / Tile.TILEHEIGHT;
		}else if(yMove>0) {
			ty = (int) (y+yMove+ bounds.y + bounds.height)/ Tile.TILEHEIGHT;
		}
		
		if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) && !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
			y+= yMove;
		}
	}
	
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	
	//Getters Setters
	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	
	
}
