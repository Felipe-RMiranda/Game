package game;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Player {
	
	private int x, y;
	private int dx, dy;
	private Image img;
	private static int VELOCIDADE = 4;
	private int alt, larg;
	private List <Attack> attack;
	
	public Player() {
		this.x = 100;
		this.y = 100;
		
		attack = new ArrayList<Attack>();
	}
	
	public void load() {
		ImageIcon referencia = new ImageIcon("src\\player\\__Idle.gif");
		img = referencia.getImage();
		
		alt = img.getHeight(null);
		larg = img.getWidth(null);		
	}
	
	public void update() {
		x += dx;
		y += dy;		
	}
	
	public void attack() {
		this.attack.add(new Attack(x+larg, y+(alt/2)));
	}
	
	
	
	public void keyPressed(KeyEvent tecla) {
		int cod = tecla.getKeyCode();
		
		if(cod == KeyEvent.VK_J) {
			attack();
		}
		if(cod == KeyEvent.VK_W) {
			dy=-1 * Player.VELOCIDADE;
		}
		if(cod == KeyEvent.VK_S) {
			dy= 1 * Player.VELOCIDADE;
		}
		if(cod == KeyEvent.VK_A) {
			dx=-1 * Player.VELOCIDADE;
		}
		if(cod == KeyEvent.VK_D) {
			dx = 1 * Player.VELOCIDADE;
		}
	}
		
		public void keyRelease(KeyEvent tecla) {
			int cod = tecla.getKeyCode();
			
			if(cod == KeyEvent.VK_W) {
				dy=0;
			}
			if(cod == KeyEvent.VK_S) {
				dy=0;
			}
			if(cod == KeyEvent.VK_A) {
				dx=0;
			}
			if(cod == KeyEvent.VK_D) {
				dx=0;
			}		
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Image getImg() {
		return img;
	}

	public List<Attack> getAttack() {
		return attack;
	}
	
	
}
