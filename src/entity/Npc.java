package entity;

import main.GamePanel;

import java.util.Random;

public class Npc extends Entity{

	public Npc(GamePanel gamePanel) {
		super(gamePanel);
		speed = 3;
		onPath = true;
		
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
		if(onPath) {
			int goalCol = (gamePanel.player.x + gamePanel.player.collisionArea.x) / gamePanel.tileSize;
			int goalRow = (gamePanel.player.y + gamePanel.player.collisionArea.y) / gamePanel.tileSize;
			
			searchPath(goalCol, goalRow);
		}
	}

}
