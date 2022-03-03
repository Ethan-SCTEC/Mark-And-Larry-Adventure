package tilegame.gfx;

import tilegame.Game;
import tilegame.entities.Entity;

public class GameCamera {
	
	//the offsets are going to change where the tiles are drawn.
	//essentially how much you add or subtract from he original position
	private float xOffset, yOffset;
	
	private Game game;

	public GameCamera(Game game,float xOffset, float yOffset) {
		this.game = game;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - game.getWidth() / 2 + e.getWidth()/2;
		yOffset = e.getY() - game.getHeight() / 2 + e.getHeight()/2;
	}
	
	//takes in the x and y amount and adds them to the offset
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
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
