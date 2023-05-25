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
		gamePanel.npcs[0] = new Npc(gamePanel, 2);
		gamePanel.npcs[0].x = 8 * gamePanel.tileSize;
		gamePanel.npcs[0].y = 11 * gamePanel.tileSize;
		
		gamePanel.npcs[1] = new Npc(gamePanel, 1);
		gamePanel.npcs[1].x = 8 * gamePanel.tileSize;
		gamePanel.npcs[1].y = 0 * gamePanel.tileSize;
		
		gamePanel.npcs[2] = new Npc(gamePanel, 4);
		gamePanel.npcs[2].x = 7 * gamePanel.tileSize;
		gamePanel.npcs[2].y = 0 * gamePanel.tileSize;
		
		gamePanel.npcs[3] = new Npc(gamePanel, 2);
		gamePanel.npcs[3].x = 14 * gamePanel.tileSize;
		gamePanel.npcs[3].y = 5 * gamePanel.tileSize;
		
		gamePanel.npcs[4] = new Npc(gamePanel, 4);
		gamePanel.npcs[4].x = 0 * gamePanel.tileSize;
		gamePanel.npcs[4].y = 5 * gamePanel.tileSize;
		
		gamePanel.npcs[5] = new Npc(gamePanel, 4);
		gamePanel.npcs[5].x = 14 * gamePanel.tileSize;
		gamePanel.npcs[5].y = 6 * gamePanel.tileSize;
		
		gamePanel.npcs[6] = new Npc(gamePanel, 3);
		gamePanel.npcs[6].x = 0 * gamePanel.tileSize;
		gamePanel.npcs[6].y = 6 * gamePanel.tileSize;
		
		gamePanel.npcs[7] = new Npc(gamePanel, 3);
		gamePanel.npcs[7].x = 7 * gamePanel.tileSize;
		gamePanel.npcs[7].y = 11 * gamePanel.tileSize;
		
	}
}
