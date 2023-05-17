package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu extends JPanel {
	
	private Image fundo;
	
	public Menu() {
		//Obigeto de imagem para backgorund
		var ref = new ImageIcon("src\\sprites\\menup.PNG");
		fundo = ref.getImage();
		setLayout(null);
		
		//Botão de inicio
		var play = new JButton("PLAY");
		play.setBounds(400,400,100,30);	
		play.setForeground(Color.red);
		play.setFont(new Font("calibre",Font.BOLD,20));
		this.add(play);
		play.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				add(new Fase());
				
			}
		});
			
	}
	//Metodo de pintura do background
	public void paint(Graphics g) {
		var graf = (Graphics2D) g;
		graf.drawImage(fundo, 40, 0, null);
		g.dispose();
	}

}
