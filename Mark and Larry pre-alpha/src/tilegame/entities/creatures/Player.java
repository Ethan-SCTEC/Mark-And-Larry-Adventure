package tilegame.entities.creatures;

import tilegame.Game;
import tilegame.gfx.Assets;

import java.awt.Graphics;

public class Player extends Creature{

	private Game game;
	public Player(Game game, float x, float y) {
		super(x, y, Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
		this.game = game;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		getInput();
		move();
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		int directionMoving = 0;
		
		
		if(game.getKeyManager().up) {
			directionMoving = 1;
		}
		if(game.getKeyManager().down) {
			directionMoving = 2;
		}
		if(game.getKeyManager().left) {
			directionMoving = 3;
		}
		if(game.getKeyManager().right) {
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
		g.drawImage(Assets.bob,(int)x,(int)y,width,height,null);
	}

}
