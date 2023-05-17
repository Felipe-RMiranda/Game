package game;

import javax.swing.JFrame;

public class Container extends JFrame {
	
	public Container() {
		//add(new Menu());
		add(new Fase());
		setTitle("Game");
		setSize(900,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Container();
	}

}
