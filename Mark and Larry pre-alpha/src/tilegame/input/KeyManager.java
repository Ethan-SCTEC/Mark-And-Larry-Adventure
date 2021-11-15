package tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	private boolean[] keys;
	public boolean up, down, left, right, w, a, s, d;
	
	public KeyManager() {
		keys = new boolean[256];
	}

	public void tick() {
		up = keys[KeyEvent.VK_UP];
		w = keys[KeyEvent.VK_W];
		
		down = keys[KeyEvent.VK_DOWN];
		s = keys[KeyEvent.VK_S];
		
		left = keys[KeyEvent.VK_LEFT];
		a = keys[KeyEvent.VK_A];
		
		right = keys[KeyEvent.VK_RIGHT];
		d = keys[KeyEvent.VK_D];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
}
