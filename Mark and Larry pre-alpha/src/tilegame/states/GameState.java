package tilegame.states;

import java.awt.Graphics;

import tilegame.Handler;
import tilegame.entities.creatures.Player;
import tilegame.tiles.Tile;
import tilegame.worlds.World;

public class GameState extends State{

	private Player player;
	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/DebugWorld.txt");
		handler.setWorld(world);
		player = new Player(handler,world.getSpawnX() * Tile.TILEWIDTH,world.getSpawnY() * Tile.TILEHEIGHT);
		
		
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		world.tick();
		player.tick();
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		world.render(g);
		player.render(g);
	}
	
}
