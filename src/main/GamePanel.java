package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	final int baseTileSize = 16; //Tamanho da Imagem 16x16
	final int scale = 3;
	
	final public int tileSize = baseTileSize * scale; //Tamanho da Imagem no Jogo 48x48
	final public int maxScreenCol = 16;
	final public int maxScreenRow = 12;
	final public int screenW = tileSize * maxScreenCol;
	final public int screenH = tileSize * maxScreenRow;
	
	KeyHandler keyHandler = new KeyHandler();
	Thread gameThread;
	
	Player player = new Player(this, keyHandler);
	TileManager tileManager = new TileManager(this);
	
	final int FPS = 60;
	
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenW, screenH));
		this.setBackground(Color.black);
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
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		var g2 = (Graphics2D)g;
		
		tileManager.draw(g2);
		player.draw(g2);
		
		g2.dispose();
	}
}
