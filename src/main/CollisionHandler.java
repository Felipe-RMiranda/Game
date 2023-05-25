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
	
	public int checkObject(Entity entity, boolean player) {
		int index = 999;
		
		for(int i = 0; i < gamePanel.objects.length; i++) {
			if(gamePanel.objects[i] != null) {
				entity.collisionArea.x += entity.x;
				entity.collisionArea.y += entity.y;
				
				gamePanel.objects[i].collisionArea.x += gamePanel.objects[i].x;
				gamePanel.objects[i].collisionArea.y += gamePanel.objects[i].y;
				
				switch(entity.direction) {
				case Up:
					entity.collisionArea.y -= entity.speed;
					if(entity.collisionArea.intersects(gamePanel.objects[i].collisionArea)) {
						if(gamePanel.objects[i].collision) {
							entity.collisionOn = true;
						}
						if(player) {
							index = i;
						}
					}
					break;
				case Down:
					entity.collisionArea.y += entity.speed;
					if(entity.collisionArea.intersects(gamePanel.objects[i].collisionArea)) {
						if(gamePanel.objects[i].collision) {
							entity.collisionOn = true;
						}
						if(player) {
							index = i;
						}
					}
					break;
				case Right:
					entity.collisionArea.x -= entity.speed;
					if(entity.collisionArea.intersects(gamePanel.objects[i].collisionArea)) {
						if(gamePanel.objects[i].collision) {
							entity.collisionOn = true;
						}
						if(player) {
							index = i;
						}
					}
					break;
				case Left:
					entity.collisionArea.x += entity.speed;
					if(entity.collisionArea.intersects(gamePanel.objects[i].collisionArea)) {
						if(gamePanel.objects[i].collision) {
							entity.collisionOn = true;
						}
						if(player) {
							index = i;
						}
					}
					break;
				}
				entity.collisionArea.x = entity.defaultSolidAreaX;
				entity.collisionArea.y = entity.defaultSolidAreaY;
				gamePanel.objects[i].collisionArea.x = gamePanel.objects[i].defaultSolidAreaX;
				gamePanel.objects[i].collisionArea.y = gamePanel.objects[i].defaultSolidAreaX;
			}
			
		}
		
		return index;
	}
	
	public int checkEntity(Entity entity, Entity[] target) {
		int index = 999;
		
		for(int i = 0; i < target.length; i++) {
			if(target[i] != null) {
				entity.collisionArea.x += entity.x;
				entity.collisionArea.y += entity.y;
				
				target[i].collisionArea.x += target[i].x;
				target[i].collisionArea.y += target[i].y;
				
				switch(entity.direction) {
				case Up:
					entity.collisionArea.y -= entity.speed;
					if(entity.collisionArea.intersects(target[i].collisionArea)) {						
						entity.collisionOn = true;		
						index = i;
					}
					break;
				case Down:
					entity.collisionArea.y += entity.speed;
					if(entity.collisionArea.intersects(target[i].collisionArea)) {						
						entity.collisionOn = true;	
						index = i;
					}
					break;
				case Right:
					entity.collisionArea.x -= entity.speed;
					if(entity.collisionArea.intersects(target[i].collisionArea)) {						
						entity.collisionOn = true;	
						index = i;
					}
					break;
				case Left:
					entity.collisionArea.x += entity.speed;
					if(entity.collisionArea.intersects(target[i].collisionArea)) {						
						entity.collisionOn = true;	
						index = i;
					}
					break;
				}
				entity.collisionArea.x = entity.defaultSolidAreaX;
				entity.collisionArea.y = entity.defaultSolidAreaY;
				target[i].collisionArea.x = target[i].defaultSolidAreaX;
				target[i].collisionArea.y = target[i].defaultSolidAreaY;
			}
			
		}
		
		return index;
	}

	public void checkProjectile(Entity[] npc, Entity projectile) {
		for(int i = 0; i < npc.length; i++) {
			projectile.collisionArea.x += projectile.x;
			projectile.collisionArea.y += projectile.y;
			if(npc[i] != null) {				
				npc[i].collisionArea.x += npc[i].x;
				npc[i].collisionArea.y += npc[i].y;
				
				if(projectile.collisionArea.intersects(npc[i].collisionArea)) {
					gamePanel.npcs[i] = null;
				}
			}
			
			projectile.collisionArea.x = projectile.defaultSolidAreaX;
			projectile.collisionArea.y = projectile.defaultSolidAreaY;
			if(npc[i] != null) {		
				npc[i].collisionArea.x = npc[i].defaultSolidAreaX;
				npc[i].collisionArea.y = npc[i].defaultSolidAreaY;
			}
			
		}
	}
}
