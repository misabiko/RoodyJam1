package com.misabiko.RJ01.Controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	public boolean wIsHeld, aIsHeld, sIsHeld, dIsHeld = false;
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			wIsHeld = true;
			break;
		case KeyEvent.VK_A:
			aIsHeld = true;
			break;
		case KeyEvent.VK_S:
			sIsHeld = true;
			break;
		case KeyEvent.VK_D:
			dIsHeld = true;
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			wIsHeld = false;
			break;
		case KeyEvent.VK_A:
			aIsHeld = false;
			break;
		case KeyEvent.VK_S:
			sIsHeld = false;
			break;
		case KeyEvent.VK_D:
			dIsHeld = false;
			break;
		default:
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
