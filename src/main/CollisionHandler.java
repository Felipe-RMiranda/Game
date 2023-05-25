package main;

import entity.Entity;

public class CollisionHandler {
	GamePanel gamePanel;
	
	public CollisionHandler(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	public void checkTile(Entity entity) {
		int leftEntityX = entity.x + entity.collisionArea.x;
		int rightEntityX = entity.x + entity.collisionArea.x + entity.collisionArea.width;
		int topEntityY = entity.y + entity.collisionArea.y;
		int bottomEntityY = entity.y + entity.collisionArea.y + entity.collisionArea.height;
		
		int leftEntityCol = leftEntityX / gamePanel.tileSize;
		int rightEntityCol = rightEntityX / gamePanel.tileSize;
		int topEntityRow = topEntityY / gamePanel.tileSize;
		int bottomEntityRow = bottomEntityY / gamePanel.tileSize;
		
		int[] tilesToCheck = new int[2];
		
		switch(entity.direction) {
		case Up:
			topEntityRow = (topEntityY - entity.speed)/gamePanel.tileSize;
			tilesToCheck[0] = gamePanel.tileManager.mapTilesNum[leftEntityCol][topEntityRow];
			tilesToCheck[1] = gamePanel.tileManager.mapTilesNum[rightEntityCol][topEntityRow];
			
			entity.collisionOn = gamePanel.tileManager.isTilesColision(tilesToCheck);
			break;
		case Down:
			bottomEntityRow = (bottomEntityY + entity.speed)/gamePanel.tileSize;
			tilesToCheck[0] = gamePanel.tileManager.mapTilesNum[leftEntityCol][bottomEntityRow];
			tilesToCheck[1] = gamePanel.tileManager.mapTilesNum[rightEntityCol][bottomEntityRow];
			
			entity.collisionOn = gamePanel.tileManager.isTilesColision(tilesToCheck);
			break;
		case Left:
			leftEntityCol = (leftEntityX - entity.speed)/gamePanel.tileSize;
			tilesToCheck[0] = gamePanel.tileManager.mapTilesNum[leftEntityCol][bottomEntityRow];
			tilesToCheck[1] = gamePanel.tileManager.mapTilesNum[leftEntityCol][topEntityRow];
			
			entity.collisionOn = gamePanel.tileManager.isTilesColision(tilesToCheck);
			break;
		case Right:
			rightEntityCol = (rightEntityX + entity.speed)/gamePanel.tileSize;
			tilesToCheck[0] = gamePanel.tileManager.mapTilesNum[rightEntityCol][bottomEntityRow];
			tilesToCheck[1] = gamePanel.tileManager.mapTilesNum[rightEntityCol][topEntityRow];
			
			entity.collisionOn = gamePanel.tileManager.isTilesColision(tilesToCheck);
			break;
		}
	}
}
