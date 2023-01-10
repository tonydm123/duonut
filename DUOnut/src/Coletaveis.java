import java.awt.Image;

import javax.swing.ImageIcon;


public class Coletaveis extends Objeto{

	private Image imagem;
	
	public Coletaveis(int x, int y) {
		super(x, y, 25, 25);
		ImageIcon referencia = new ImageIcon("res//donut.png");
		imagem = referencia.getImage();
	}


	
	
	
	//Getters e setters
	
	public Image getImagem() {
		return imagem;
	}

	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}

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
