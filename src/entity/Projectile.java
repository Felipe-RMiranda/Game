package entity;

import main.GamePanel;

public class Projectile extends Entity{
	GamePanel gamePanel;
	
	public Projectile(GamePanel gamePanel) {
		super(gamePanel);
		this.gamePanel = gamePanel;
	}
	
	public void set(int x, int y, Direction direction, boolean alive) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.alive = alive;
		this.life = this.maxLife;
	}
	
	public void update() {
		switch(direction) {
		case Up:
			y -= speed;
			break;
		case Down:
			y += speed;
			break;
		case Left:
			x -= speed;
			break;
		case Right:
			x += speed;
			break;
		}
		
		gamePanel.collisionH.checkProjectile(gamePanel.npcs, this);
		
		life--;
		if(life <= 0) {
			alive = false;
		}
	}
}
