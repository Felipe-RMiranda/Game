package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	public boolean upPressed, downPressed, leftPressed, rightPressed, shotKeyPressed;

	@Override
	public void keyTyped(KeyEvent e) { }

	@Override
	public void keyPressed(KeyEvent e) {
		var code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			upPressed = true;
		}
		
		if(code == KeyEvent.VK_S) {
			downPressed = true;	
		}
		
		if(code == KeyEvent.VK_A) {
			leftPressed = true;
		}

		if(code == KeyEvent.VK_D) {
			rightPressed = true;
		}
		
		if(code == KeyEvent.VK_SPACE) {
			shotKeyPressed = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		var code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			upPressed = false;
		}
		
		if(code == KeyEvent.VK_S) {
			downPressed = false;	
		}
		
		if(code == KeyEvent.VK_A) {
			leftPressed = false;
		}

		if(code == KeyEvent.VK_D) {
			rightPressed = false;
		}
		
		if(code == KeyEvent.VK_SPACE) {
			shotKeyPressed = false;
		}
		
	}
	
	public boolean isMovementKeyPressed() {
		if(upPressed || downPressed || leftPressed || rightPressed) {
			return true;
		}
		
		return false;
	}

}
