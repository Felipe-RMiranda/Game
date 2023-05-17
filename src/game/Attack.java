package game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Attack {
	
	private Image img;//Imagem do tiro
	private int x, y;//posição do tiro
	private int alt, larg;//dimenções do tiro
	private boolean isVisivel;//desaparecimento do tiro pós colizão
	
	private static final int LARGURA = 750;//	controle de alcanse do tiro
	private static int VELOCIDADE = 2;//velocidade do tiro
	
	public Attack(int x, int y) {
		this.x = x;
		this.y = y;
		isVisivel = true;
	}
	
	public void load() {
		var ref = new ImageIcon("src\\sprites\\machado.png");
		img = ref.getImage();
		
		this.alt = img.getHeight(null);
		this.larg = img.getWidth(null);
	}
	
	public void update() {
		this.x =+ VELOCIDADE;
			if(this.x > LARGURA) {
				isVisivel = false;
			}
	}

	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public static int getVELOCIDADE() {
		return VELOCIDADE;
	}

	public static void setVELOCIDADE(int vELOCIDADE) {
		VELOCIDADE = vELOCIDADE;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImg() {
		return img;
	}

	
	
}
