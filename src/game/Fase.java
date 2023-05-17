package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener {
	
	private Image fundo;
	private Player player;
	private Timer timer;
	
	public Fase() {
		setFocusable(true);
		setDoubleBuffered(true);
		
		ImageIcon referencia = new ImageIcon("src\\sprites\\cenario1.PNG");
		fundo = referencia.getImage();
		
		player = new Player();
		player.load();
		
		addKeyListener(new TecladoAdapter());
		
		timer = new Timer(5, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo, 0, 0, null);
		graficos.drawImage(player.getImg(), player.getX(), player.getY(), this);
		
		List<Attack> attack = player.getAttack();
		for(int i = 0; i < attack.size(); i++) {
			Attack m = attack.get(i);
			m.load();
			graficos.drawImage(m.getImg(), m.getX(), m.getY(), this);
		}		
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		List<Attack> attack = player.getAttack();
			for(int i = 0; i < attack.size(); i++) {
				Attack m = attack.get(i);
					if(m.isVisivel()) {
						m.update();
					}else {
						attack.remove(i);
					}
			}
		repaint();
		
	}
	
	private class TecladoAdapter extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			player.keyRelease(e);
		}
	}
}
