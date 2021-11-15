package tilegame;
public class Launcher {

	public static void main(String[] args) {
		//creates the game window and launches game
		Game game = new Game("Whatever the game is called",1024,768);
		game.start();
	}

}
