package entity;

import main.GamePanel;

import java.util.Random;

public class Npc extends Entity{

	public Npc(GamePanel gamePanel) {
		super(gamePanel);
		direction = Direction.Down;
		speed = 1;
		
		getNpcImage();
	}
	
	public void getNpcImage() {
		up1 = setup("/weapons/axe");
		up2 = setup("/weapons/axe");
		left1 = setup("/weapons/axe");
		left2 = setup("/weapons/axe");
		right1 = setup("/weapons/axe");
		right2 = setup("/weapons/axe");
		down1 = setup("/weapons/axe");
		down2 = setup("/weapons/axe");
	}
	
	public void setAction() {
		var random = new Random();
		int i = random.nextInt(100) + 1;
		
		if(i < 50) {
			direction = Direction.Left;
		} else {
			direction = Direction.Right;
		}
		
		direction = Direction.Left;
	}

}
