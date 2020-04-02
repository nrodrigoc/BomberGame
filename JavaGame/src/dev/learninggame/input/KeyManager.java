package dev.learninggame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	private boolean[] keys;
	public boolean up, down, right, left, bombBoy;
	public boolean up2, down2, right2, left2, bombGirl;
	
	public KeyManager() {
		keys = new boolean[1048];
	}
	
	public void tick() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		bombBoy = keys[KeyEvent.VK_SPACE];
		
		up2 = keys[KeyEvent.VK_UP];
		down2 = keys[KeyEvent.VK_DOWN];
		left2 = keys[KeyEvent.VK_LEFT];
		right2 = keys[KeyEvent.VK_RIGHT];
		bombGirl = keys[KeyEvent.VK_I];
		
	}
	
	@Override//Metodo chamado sempre que o user aperta uma tecla
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override//Metodo chamado sempre que o user soltar uma tecla
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
