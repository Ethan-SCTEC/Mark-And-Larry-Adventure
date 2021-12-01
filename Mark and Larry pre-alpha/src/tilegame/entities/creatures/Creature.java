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
		
		if(xMove>0) {
			
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			if(!collisionWithTile(tx,(int) (y+bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx,(int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove;
			}else{
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 0.01f;
			}
	
			
		}else if(xMove <0) {
			
			int tx = (int) Math.floor((x + xMove + bounds.x) / Tile.TILEWIDTH);
			
			if(!collisionWithTile(tx,(int) Math.floor((y+bounds.y) / Tile.TILEHEIGHT)) &&
					!collisionWithTile(tx,(int) Math.floor((y + bounds.y + bounds.height) / Tile.TILEHEIGHT))) {
				x += xMove;
			}else{
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
			
			
		}
		
	}
	
	public void moveY() {
		
		if(yMove <0) {
			int ty = (int)Math.floor((y+yMove + bounds.y) / Tile.TILEHEIGHT);
			
			if(!collisionWithTile((int) Math.floor((x + bounds.x) / Tile.TILEWIDTH), ty) && 
					!collisionWithTile((int)Math.floor((x + bounds.x + bounds.width) / Tile.TILEWIDTH), ty)){
				y+= yMove;
			}else {
				y = ty*Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
			
			
			
		}else if(yMove>0) {
			int ty = (int) Math.floor((y+yMove+ bounds.y + bounds.height)/ Tile.TILEHEIGHT);
			
			if(!collisionWithTile((int) Math.floor((x + bounds.x) / Tile.TILEWIDTH), ty) && 
					!collisionWithTile((int) Math.floor((x + bounds.x + bounds.width) / Tile.TILEWIDTH), ty)){
				y+= yMove;
			}else {
				y = ty*Tile.TILEHEIGHT - bounds.y-bounds.height - 0.01f;
				
			}
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
