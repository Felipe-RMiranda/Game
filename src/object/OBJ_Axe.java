package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Projectile;
import main.GamePanel;

public class OBJ_Axe extends Projectile{

	GamePanel gamePanel;
	
	public OBJ_Axe(GamePanel gamePanel) {
		super(gamePanel);
		this.gamePanel = gamePanel;
		name = "Axe";
		maxLife = 40;
		life = maxLife;
		alive = false;
		speed = 10;
		
		getImage();
	}
	
	public void getImage() {
		try {
			down1 = ImageIO.read(getClass().getResourceAsStream("/weapons/axe.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/weapons/axe.png"));
			up1 = ImageIO.read(getClass().getResourceAsStream("/weapons/axe.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/weapons/axe.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/weapons/axe.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/weapons/axe.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/weapons/axe.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/weapons/axe.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
