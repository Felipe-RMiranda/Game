package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import tile.TileManager;
import ai.PathFinder;

public class GamePanel extends JPanel implements Runnable{
	final int baseTileSize = 16; //Tamanho da Imagem 16x16
	final int scale = 3;
	
	final public int tileSize = baseTileSize * scale; //Tamanho da Imagem no Jogo 48x48
	final public int maxScreenCol = 16;
	final public int maxScreenRow = 12;
	final public int screenW = tileSize * maxScreenCol;
	final public int screenH = tileSize * maxScreenRow;
	
	public KeyHandler keyHandler = new KeyHandler();
	Thread gameThread;
	
	public Player player = new Player(this, keyHandler);
	public TileManager tileManager = new TileManager(this);
	public CollisionHandler collisionH = new CollisionHandler(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public PathFinder pathFinder = new PathFinder(this);
	public Entity[] objects = new Entity[10];
	public Entity[] npcs = new Entity[100];
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	public ArrayList<Entity> projectiles = new ArrayList<Entity>();
	
	final int FPS = 60;
	
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	public void setupGame() {
		aSetter.setNpc();
	}
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenW, screenH));
		this.setDoubleBuffered(true); //Melhora a performance do jogo no geral
		this.addKeyListener(keyHandler);
		this.setFocusable(true);
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	//Esse metodo eh chamado toda vez que um thread eh iniciado
	@Override
	public void run() { 
		double drawInterval = 1000000000/FPS; //1 segundo em nanoSegundos
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		while(gameThread != null) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			//Garante que a Imagem sera gerada em ate 60 vezes por segundo
			if(delta >= 1) {
				update();
				repaint(); //Chama o metodo "paintComponent"
				
				delta--;
				drawCount++;
			}
			
			if(timer >= 1000000000) {
				System.out.println("FPS: " + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
		
	}
	
	public void update() {
		player.update();
		for(int i = 0; i < npcs.length; i++) {
			if(npcs[i] != null) {
				npcs[i].update();
			}
		}
		
		for(int i = 0; i < projectiles.size(); i++) {
			if(projectiles.get(i) != null) {
				if(projectiles.get(i).alive) {		
					projectiles.get(i).update();
				}else {
					projectiles.remove(i);
				}
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		var g2 = (Graphics2D)g;
		if(player.alive) {		
			tileManager.draw(g2);
			
			entities.add(player);
			for(int i = 0; i < npcs.length; i++) {
				if(npcs[i] != null) {
					entities.add(npcs[i]);
				}
			}
			
			for(int i = 0; i < projectiles.size(); i++) {
				if(projectiles.get(i) != null) {
					entities.add(projectiles.get(i));
				}
			}
			
			for(int i = 0; i < entities.size(); i++) {
				entities.get(i).draw(g2);
				entities.remove(i);
			}
		}else {
			
			try {		
				Image image = ImageIO.read(getClass().getResourceAsStream("/screen/gameOver.jpg"));
				image = image.getScaledInstance(798, 596, Image.SCALE_DEFAULT);
				g2.drawImage(image, 0, 0, null);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		g2.dispose();
	}
}
