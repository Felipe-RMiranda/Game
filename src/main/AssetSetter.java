package main;

import entity.Npc;
import object.OBJ_staticAxe;

public class AssetSetter {
	GamePanel gamePanel;
	
	public AssetSetter(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	public void setObject() {
		gamePanel.objects[0] = new OBJ_staticAxe(gamePanel);
		gamePanel.objects[0].x = 200;
		gamePanel.objects[0].y = 200;
	}
	
	public void setNpc() {
		gamePanel.npcs[0] = new Npc(gamePanel);
		gamePanel.npcs[0].x = 500;
		gamePanel.npcs[0].y = 400;
	}
}
