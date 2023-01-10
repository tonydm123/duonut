import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Plataformas extends Objeto{
  
	private Image imagem;
	//private Image imagem2;

	//construtor de plataformas
	public Plataformas(int x, int y, int altura, int largura) {
		super(x,y,altura,largura);
		ImageIcon referencia = new ImageIcon("res//chao.png");
		imagem = referencia.getImage();
		
		
	}

	// pinta as plataformas  na tela
	public void paint(Graphics2D g, int xMundo , int fase) {
		
			g.setColor(Color.CYAN);
		g.fillRect((int) x-xMundo, (int) y, (int) largura, (int) altura);
		
		
		
		
	}

	
	
	
	
	
	// Getters e setters
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

}
