package tilegame.states;

import java.awt.Graphics;

import tilegame.Game;
import tilegame.entities.creatures.Player;
import tilegame.worlds.World;

public class GameState extends State{

	private Player player;
	private World world;
	
	public GameState(Game game) {
		super(game);
		player = new Player(game,200,200);
		world = new World("");
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
