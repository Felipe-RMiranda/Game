package entity;

import main.GamePanel;

public class Npc extends Entity{

	public Npc(GamePanel gamePanel, int speed) {
		super(gamePanel);
		this.speed = speed;
		onPath = true;
		
		getNpcImage();
	}
	
	public void getNpcImage() {
		up1 = setup("/monster/orc_up_1");
		up2 = setup("/monster/orc_up_2");
		left1 = setup("/monster/orc_left_1");
		left2 = setup("/monster/orc_left_2");
		right1 = setup("/monster/orc_right_1");
		right2 = setup("/monster/orc_right_2");
		down1 = setup("/monster/orc_down_1");
		down2 = setup("/monster/orc_down_2");
	}
	
	public void setAction() {
		if(onPath) {
			int goalCol = (gamePanel.player.x + gamePanel.player.collisionArea.x) / gamePanel.tileSize;
			int goalRow = (gamePanel.player.y + gamePanel.player.collisionArea.y) / gamePanel.tileSize;
			
			searchPath(goalCol, goalRow);
		}
	}

}
