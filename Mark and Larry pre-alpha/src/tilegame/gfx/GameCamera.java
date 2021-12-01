package tilegame.gfx;

import tilegame.Handler;
import tilegame.entities.Entity;
import tilegame.tiles.Tile;

public class GameCamera {
	
	//the offsets are going to change where the tiles are drawn.
	//essentially how much you add or subtract from he original position
	private float xOffset, yOffset;
	
	private Handler handler;

	public GameCamera(Handler handler,float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void checkBlankSpace() {
		if(xOffset < 0 ) {
			xOffset = 0;
		}else if(xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()) {
			xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
		}
		
		if(yOffset < 0) {
			yOffset = 0;
		}else if(yOffset > handler.getWorld().getHeight() * Tile.TILEWIDTH - handler.getHeight()) {
			yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
		}
		
		
	}
	
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth()/2;
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight()/2;
		checkBlankSpace();
	}
	
	//takes in the x and y amount and adds them to the offset
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}
	
	//getters and setters
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
}
