package catcher;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InputManager implements KeyListener, MouseListener {

	public static final InputManager instance = new InputManager();
	
	private static final int KEY_COUNT = 600;
	private final boolean keys[] = new boolean[KEY_COUNT];
	
	public InputManager() {
		for (int i = 0; i < KEY_COUNT; i++) {
			keys[i] = false;
		}
	}
	
	public void setPanel(Component comp) {
		if (comp == null) {
			return;
		}
		comp.addKeyListener(this);
		comp.addMouseListener(this);
	}
	
	public boolean isPressed(int key) {
		if (key > KEY_COUNT || key < 0) {
			return false;
		} else {
			return keys[key];
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		if (key > KEY_COUNT || key < 0) {
			return;
		}
		
		keys[key] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		if (key > KEY_COUNT || key < 0) {
			return;
		}
		
		keys[key] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
