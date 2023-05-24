package tile;

import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
	GamePanel gamePanel;
	Tile[] tiles;
	int[][] mapTilesNum;
	
	public TileManager(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		
		tiles = new Tile[4];
		mapTilesNum = new int[gamePanel.maxScreenCol][gamePanel.maxScreenRow];
		
		getTileImage();
		loadMap("/maps/map00.txt");
	}
	
	public void getTileImage() {
		try {
			tiles[2] = new Tile(ImageIO.read(getClass().getResourceAsStream("/tiles/floor01.png")));
			tiles[1] = new Tile(ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png")));
			tiles[0] = new Tile(ImageIO.read(getClass().getResourceAsStream("/tiles/grass01.png")));
			tiles[3] = new Tile(ImageIO.read(getClass().getResourceAsStream("/tiles/water01.png")));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadMap(String mapPath) {
		try {
			var inputStream = getClass().getResourceAsStream(mapPath);
			var bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			
			int col = 0;
			int row = 0;
			
			while(col < gamePanel.maxScreenCol && row < gamePanel.maxScreenRow) {
				var line = bufferedReader.readLine();
				
				while(col < gamePanel.maxScreenCol) {
					var numbers = line.split(" ");
					
					var num = Integer.parseInt(numbers[col]);
					
					mapTilesNum[col][row] = num;
					col++;
				}
				
				if(col == gamePanel.maxScreenCol) {
					col = 0;
					row++;
				}
				
			}
			
			bufferedReader.close();			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		while(col < gamePanel.maxScreenCol && row < gamePanel.maxScreenRow) {
			var tileNum = mapTilesNum[col][row];
			
			g2.drawImage(tiles[tileNum].image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
			col++;
			x += gamePanel.tileSize;
			
			if(col == gamePanel.maxScreenCol) {
				col = 0;
				x = 0;
				row++;
				y += gamePanel.tileSize;
			}
		}
	}
}
