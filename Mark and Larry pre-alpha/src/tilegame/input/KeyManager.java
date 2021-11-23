package tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyManager implements KeyListener{

	private ArrayList<KeyEvent> keys;
	private boolean[] keysDown;
	public boolean up, down, left, right, w, a, s, d;
	
	public KeyManager() {
		keysDown = new boolean[256];
		keys = new ArrayList<KeyEvent>();
	}

	public void tick() {
		up = keysDown[KeyEvent.VK_UP];
		w = keysDown[KeyEvent.VK_W];
		
		down = keysDown[KeyEvent.VK_DOWN];
		s = keysDown[KeyEvent.VK_S];
		
		left = keysDown[KeyEvent.VK_LEFT];
		a = keysDown[KeyEvent.VK_A];
		
		right = keysDown[KeyEvent.VK_RIGHT];
		d = keysDown[KeyEvent.VK_D];
		
//		for(int i = 0; i < keys.size(); i++) {
//			System.out.println(keys.get(i).getKeyChar());
//		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keysDown[e.getKeyCode()] = true;
//		System.out.println("Pressed: " + e.getKeyChar());
		int counter = 0;
		if(keys.size() > 0) {
			for(KeyEvent key : keys) {
				if(key.getKeyCode() == e.getKeyCode()) {
					counter ++;
				}
			}
			if(counter == 0) {
				keys.add(e);
			}
		}
		else {
			keys.add(e);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keysDown[e.getKeyCode()] = false;
		if(keys.size() > 0) {
			for(int i = 0; i < keys.size(); i++) {
				KeyEvent key = keys.get(i);
//				System.out.println("Released: " + key.getKeyChar());
				if(key.getKeyCode() == e.getKeyCode()) {
					keys.remove(i);
				}
			}
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	public int getLastKeyHeld() {
		if(keys.size() > 0) {			
			return keys.get(keys.size() - 1).getKeyCode();
		}
		return -1;
	}
	
	public int getFirstKeyHeld() {
		if(keys.size() > 0) {			
			return keys.get(0).getKeyCode();
		}
		return -1;
	}
}
