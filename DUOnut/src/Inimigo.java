import java.awt.Image;

import javax.swing.ImageIcon;

public class Inimigo {

	private int x, y;// seta o X e Y do inimigo
	private int dx, dy; // seta o movimento do inimigo
	private Image imagem; // imagem do inimigo
	private final float velocidade = 4; // velocidade do inimigo
	private int chao; // chao para o inimigo
	private float altura, largura; // altura e largura do inimigo
	private int limite; // o limite de pixels que o inimigo ira andar
	private int iX, iY; // X e Y inicial dos inimigos
	private int proximoSprite = 0;
	private boolean esquerda = true;

	// construtor de inimigos
	public Inimigo(int x, int y, int limite, int chao) {
		// adiciona uma imagem para o inimigo
		ImageIcon referencia = new ImageIcon("res//enemyD.png");
		imagem = referencia.getImage();

		this.limite = limite;
		this.chao = chao;
		this.x = x;
		this.y = y;
		this.largura = 35;
		this.altura = 66;

		iX = x;
		iY = y;
		dy = 7; // simula gravidade do inimigo
		dx -= velocidade; // atribui a velocia ao movimento

	}

	// colisao com plataformas
	public boolean colidePlataforma(Plataformas plata, int xMundo) {
		if (x - xMundo < plata.getX() + plata.getLargura() - xMundo
				&& x - xMundo + largura > plata.getX() - xMundo
				&& y < plata.getY() + plata.getAltura()
				&& altura + y > plata.getY()) {

			return true;
		}

		return false;
	}

	// mexe o inimigo
	public void mexer() {

		x += dx;
		y += dy;

		if (x > iX + limite) { // movimento para a esquerda
			dx *= -1;
		
		}

		if (x < iX - limite) { // movimento para a esquerda
			dx *= -1;
		
		}
		
		
		if(dx < 0){
			switch (proximoSprite) {
			case 0:
				imagem = new ImageIcon("res//enemyE.png").getImage();
				proximoSprite++;
				break;
			case 5:
				imagem = new ImageIcon("res//enemyE2.png").getImage();
				proximoSprite++;
				break;
			case 10:
				imagem = new ImageIcon("res//enemyE.png").getImage();
				proximoSprite++;
				break;
			case 15:
				imagem = new ImageIcon("res//enemyE2.png").getImage();
				proximoSprite++;
				break;
			case 20:
				proximoSprite = 0;
				break;
			default:
				proximoSprite++;
			}
		}
		
		
		
		
		if (dx > 0) {
			switch (proximoSprite) {
			case 0:
				imagem = new ImageIcon("res//enemyD.png").getImage();
				proximoSprite++;
				break;
			case 5:
				imagem = new ImageIcon("res//enemyD2.png").getImage();
				proximoSprite++;
				break;
			case 10:
				imagem = new ImageIcon("res//enemyD.png").getImage();
				proximoSprite++;
				break;
			case 15:
				imagem = new ImageIcon("res//enemyD2.png").getImage();
				proximoSprite++;
				break;
			case 20:
				proximoSprite = 0;
				break;
			default:
				proximoSprite++;
			}
		}

	}

	// getters e setters

	public Image getImagem() {
		return imagem;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getPOSICAO_CHAO() {
		return chao;
	}

	public void setPOSICAO_CHAO(int pOSICAO_CHAO) {
		chao = pOSICAO_CHAO;
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public int getiX() {
		return iX;
	}

	public void setiX(int iX) {
		this.iX = iX;
	}

	public int getiY() {
		return iY;
	}

	public void setiY(int iY) {
		this.iY = iY;
	}

	public float getVELOCIDADE_DA_CAMINHADA() {
		return velocidade;
	}

	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getLargura() {
		return largura;
	}

	public void setLargura(float largura) {
		this.largura = largura;
	}

	public int getChao() {
		return chao;
	}

	public void setChao(int chao) {
		this.chao = chao;
	}

	public float getVelocidade() {
		return velocidade;
	}

}
