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
		gamePanel.npcs[0].x = 8 * gamePanel.tileSize;
		gamePanel.npcs[0].y = 11 * gamePanel.tileSize;
		int[][] positions = {
			{8 * gamePanel.tileSize, 0},
			{9 * gamePanel.tileSize, 0},
			{8 * gamePanel.tileSize, 11 * gamePanel.tileSize},
			{9 * gamePanel.tileSize, 11 * gamePanel.tileSize},
			{0 * gamePanel.tileSize, 6 * gamePanel.tileSize},
			{0 * gamePanel.tileSize, 7 * gamePanel.tileSize},
			{15 * gamePanel.tileSize, 6 * gamePanel.tileSize},
			{15 * gamePanel.tileSize, 7 * gamePanel.tileSize},
		};
		
		for(int i = 0; i < gamePanel.npcs.length; i++) {
			
		}
	}
}
