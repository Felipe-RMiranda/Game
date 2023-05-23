package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	GamePanel gamePanel;
	KeyHandler keyHandler;
	
	public Player(GamePanel gamePanel, KeyHandler keyHandler) {
		this.gamePanel = gamePanel;
		this.keyHandler = keyHandler;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		x = 100;
		y = 100;
		speed = 4;
		direction = Direction.Down;
	}
	
	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		if(keyHandler.isMovementKeyPressed()) {
			if(keyHandler.upPressed) {
				direction = Direction.Up;
				y -= speed;
			}
			else if(keyHandler.downPressed) {
				direction = Direction.Down;
				y += speed;
			}
			else if(keyHandler.leftPressed) {
				direction = Direction.Left;
				x -= speed;
			}
			else if(keyHandler.rightPressed) {
				direction = Direction.Right;
				x += speed;
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
}
