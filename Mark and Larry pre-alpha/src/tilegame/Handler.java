package tilegame;

import tilegame.gfx.GameCamera;
import tilegame.input.KeyManager;
import tilegame.worlds.World;

public class Handler {
	
	//the handler class will stop our code from being similar to source spaghetti
	//trust me, it will be useful
	
	
	private Game game;
	private World world;
	
	public Handler(Game game) {
		this.game = game;
	}

	
	
	//strange getters
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	//getters setters for this class
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
}
