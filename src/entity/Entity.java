package entity;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Entity {
	public int x, y;
	public int speed;
	
	public int maxLife;
	public int life;
	public boolean alive;
	
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
	public Direction direction = Direction.Down;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	
	public Rectangle collisionArea = new Rectangle(0, 0, 48, 48);
	public boolean collisionOn = false;
	
	public String name;
	public boolean collision = false;
	
	public int defaultSolidAreaX, defaultSolidAreaY;
	
	public Projectile projectile;
	GamePanel gamePanel;
	
	public Entity(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	public void setAction() {}
	public void update() {
		setAction();
		
		collisionOn = false;
		gamePanel.collisionH.checkTile(this);
		
		if(collisionOn == false) {
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
		}
		
		spriteCounter++;
		
		if(spriteCounter > 15) {
			if(spriteNum == 1) {
				spriteNum = 2;
			}
			else if(spriteNum == 2) {
				spriteNum = 1;
			}
			
			spriteCounter = 0;
		}
	}
	
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		
		switch(direction) {
		case Up:
			if(spriteNum == 1) {
				image = up1;
			}
			else if(spriteNum == 2) {
				image = up2;
			}
			break;
		case Down:
			if(spriteNum == 1) {
				image = down1;
			}
			else if(spriteNum == 2) {
				image = down2;
			}
			break;
		case Left:
			if(spriteNum == 1) {			
				image = left1;
			}
			else if(spriteNum == 2) {
				image = left2;				
			}
			break;
		case Right:
			if(spriteNum == 1) {			
				image = right1;
			}
			else if(spriteNum == 2) {
				image = right2;
			}
			break;
		}
		
		g2.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
	}
	
	public BufferedImage setup(String imageName) {
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imageName + ".png"));
			image.getScaledInstance(gamePanel.tileSize, gamePanel.tileSize, Image.SCALE_DEFAULT);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return image;
	}
}
