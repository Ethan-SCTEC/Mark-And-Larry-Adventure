package tilegame.entities.creatures;

import tilegame.Game;
import tilegame.Handler;
import tilegame.gfx.Assets;

import java.awt.Graphics;

public class Player extends Creature{

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
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
		
		int directionMoving = 0;
		
		
		if(handler.getKeyManager().up) {
			directionMoving = 1;
		}
		if(handler.getKeyManager().down) {
			directionMoving = 2;
		}
		if(handler.getKeyManager().left) {
			directionMoving = 3;
		}
		if(handler.getKeyManager().right) {
			directionMoving = 4;
		}
		
		switch(directionMoving) {
		case 1:
			yMove = -speed;
			break;
		case 2:
			yMove = speed;
			break;
		case 3:
			xMove = -speed;
			break;
		case 4:
			xMove = speed;
			break;
		default:
			xMove = 0;
			yMove = 0;
		}
		
	}
	
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.bob,(int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()),width,height,null);
	}

}
