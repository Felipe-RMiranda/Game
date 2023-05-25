package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import object.OBJ_Axe;

public class Player extends Entity{
	KeyHandler keyHandler;
	
	public Player(GamePanel gamePanel, KeyHandler keyHandler) {
		super(gamePanel);
		this.keyHandler = keyHandler;
		
		//referente ao tile do player
		collisionArea = new Rectangle(8, 16, 32, 32);
		defaultSolidAreaX = collisionArea.x;
		defaultSolidAreaY = collisionArea.y;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		x = 100;
		y = 100;
		speed = 4;
		direction = Direction.Down;
		projectile = new OBJ_Axe(gamePanel);
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
			}
			else if(keyHandler.downPressed) {
				direction = Direction.Down;				
			}
			else if(keyHandler.leftPressed) {
				direction = Direction.Left;				
			}
			else if(keyHandler.rightPressed) {
				direction = Direction.Right;				
			}
		
			collisionOn = false;
			gamePanel.collisionH.checkTile(this);
			
			int objIndex = gamePanel.collisionH.checkObject(this, true);
			pickUpObject(objIndex);
			
			int npcIndex = gamePanel.collisionH.checkEntity(this, gamePanel.npcs);
			
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
		
		if(gamePanel.keyHandler.shotKeyPressed) {
			if(!projectile.alive) {
				
				projectile.set(x, y, direction, true);
				gamePanel.projectiles.add(projectile);
			}
			
		}
	}
	
	public void pickUpObject(int i) {
		if(i != 999) {
			gamePanel.objects[i] = null;
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
