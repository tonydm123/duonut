import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

public class Personagem {

	private int x, y;// seta o X e Y do personagem
	private int dx, dy; // seta o movimento do personagem
	private Image imagem;// imagem do personagem
	private boolean noChao = true; // verifica se esta no chao
	private boolean limitePulo = false; // verifica se chegou ao limite de pulo
	private final int velocidadePulo = 10; // velocidade do pulo do personagem
	private final int velocidade = 5; // velocidade do personagem
	private int chao;// chao para o personagem
	private final int inicioX = 100; // X inicial dos personagem
	private final int inicioY = 510;// Y inicial dos personagem
	private final int puloLimite = 220; // limite do pulo do personagem
	private int vidas = 3;// vida inicias do personagem
	private float altura, largura;// altura e largura do personagem
	private int proximoSprite;
	private boolean noCentro = false;
	private int donuts = 0;
	private boolean pressD = false;
	private boolean pressE = false;
	private boolean lastPress = false;
	
	// construtor do personagem
	public Personagem() {

		// atribui uma imagem

		ImageIcon referencia = new ImageIcon("res//sprites//d0.png");
		imagem = referencia.getImage();
		noChao = true;
		proximoSprite = 0;
		this.x = inicioX;
		this.y = inicioY;
		altura = 65;
		largura = 35;
		dy = +5; // inicia o personagem caindo

	}
	
	
	

	// colisao com as plataformas
	public boolean colidePlataforma(Objeto plata, int xMundo) {
		if (x < plata.getX() + plata.getLargura() - xMundo
				&& x + largura > plata.getX() - xMundo
				&& y < plata.getY() + plata.getAltura()
				&& altura + y > plata.getY()) {

			return true;
		}

		return false;
	}

	// Pulo do personagem
	public void pulo() {
		dy = -velocidadePulo;
	}

	public void oneUP(int donuts) {
		if (donuts == 10) {
			vidas++;
			setDonuts(0);
		}
	}

	public boolean colideColetaveis(Objeto donut, int xMundo) {
		if (x < donut.getX() + donut.getLargura() - xMundo
				&& x + largura > donut.getX() - xMundo
				&& y < donut.getY() + donut.getAltura()
				&& altura + y > donut.getY()) {

			return true;
		}

		return false;

	}

	// colisao com inimigos
	public boolean colideInimigo(Inimigo inimigo, int xMundo) {
		if (x < inimigo.getX() + inimigo.getLargura() - xMundo
				&& x + largura > inimigo.getX() - xMundo
				&& y < inimigo.getY() + inimigo.getAltura()
				&& altura + y > inimigo.getY()) {

			return true;

		}

		return false;

	}

	// trata a colisao com a parte de baixo das plataformas
	public void trataColBaixo() {
		dy = velocidadePulo;

	}

	// mexe o personagem
	public void mexer(int xMundo) {

		x += dx;
		y += dy;

		
		if (noChao) {

			if (pressD) {
				lastPress = false;
				switch (proximoSprite) {
				case 0:
					imagem = new ImageIcon("res//sprites//d0.png").getImage();
					proximoSprite++;
					break;
				case 4:
					imagem = new ImageIcon("res//sprites//d1.png").getImage();
					proximoSprite++;
					break;
				case 8:
					imagem = new ImageIcon("res//sprites//d2.png").getImage();
					proximoSprite++;
					break;
				case 12:
					imagem = new ImageIcon("res//sprites//d3.png").getImage();
					proximoSprite++;
					break;
				case 16:
					imagem = new ImageIcon("res//sprites//d4.png").getImage();
					proximoSprite++;
					break;
				case 20:
					imagem = new ImageIcon("res//sprites//d5.png").getImage();
					proximoSprite++;
					break;
				case 24:
					imagem = new ImageIcon("res//sprites//d6.png").getImage();
					proximoSprite++;
					break;
				case 28:
					imagem = new ImageIcon("res//sprites//d7.png").getImage();
					proximoSprite++;
					break;
				case 32:
					imagem = new ImageIcon("res//sprites//d8.png").getImage();
					proximoSprite++;
					break;
				case 36:
					imagem = new ImageIcon("res//sprites//d9.png").getImage();
					proximoSprite++;
					break;
			    case 40:
					proximoSprite = 0;
					break;
				default:
					proximoSprite++;
				}

			}
			if (pressE) {
				lastPress = true;
				switch (proximoSprite) {
				case 0:
					imagem = new ImageIcon("res//sprites//e0.png").getImage();
					proximoSprite++;
					break;
				case 4:
					imagem = new ImageIcon("res//sprites//e1.png").getImage();
					proximoSprite++;
					break;
				case 8:
					imagem = new ImageIcon("res//sprites//e2.png").getImage();
					proximoSprite++;
					break;
				case 12:
					imagem = new ImageIcon("res//sprites//e3.png").getImage();
					proximoSprite++;
					break;
				case 16:
					imagem = new ImageIcon("res//sprites//e4.png").getImage();
					proximoSprite++;
					break;
				case 20:
					imagem = new ImageIcon("res//sprites//e5.png").getImage();
					proximoSprite++;
					break;
				case 24:
					imagem = new ImageIcon("res//sprites//e6.png").getImage();
					proximoSprite++;
					break;
				case 28:
					imagem = new ImageIcon("res//sprites//e7.png").getImage();
					proximoSprite++;
					break;
				case 32:
					imagem = new ImageIcon("res//sprites//e8.png").getImage();
					proximoSprite++;
					break;
				case 36:
					imagem = new ImageIcon("res//sprites//e9.png").getImage();
					proximoSprite++;
					break;
			    case 40:
					proximoSprite = 0;
					break;
				default:
					proximoSprite++;
				}

			}

		} else if(!noChao){
			if(!lastPress||pressD){
				imagem = new ImageIcon("res//sprites//d10.png").getImage();
			}
			if(lastPress||pressE){
				imagem = new ImageIcon("res//sprites//e10.png").getImage();
			}
			

		}

		// limite da esquerda
		if (x <= 1) {
			x = 1;
		}
		if (x >= 575) {
			x = 575;
			noCentro = true;
		}

		if (noCentro) {
			if (x == 200) {
				x = 200;
			}
		}

		// seta o limite de pulo em relacao com o chao e o puloLimite
		int limiteDePulo = chao - puloLimite;

		// verifica se chegou ao limite do pulo
		if (y < limiteDePulo) {
			y = limiteDePulo;
			dy = 0;
		}

		// inicia queda se chega ao limite
		if (limitePulo) {
			dy = velocidadePulo;
			limitePulo = false;
		}

		// torna true o limiteDePulo
		if (y <= limiteDePulo) {
			limitePulo = true;

			// torna false o limiteDePulo quando toca no chao
		} else if (y+altura >= chao) {
			limitePulo = false;
			if(!pressD && !pressE){
				if (!lastPress) {
					imagem = new ImageIcon("res//sprites//d0.png").getImage();
				} else {
					imagem = new ImageIcon("res//sprites//e0.png").getImage();
				}
			}
			
		}

	}

	// teclas e movimentaçao

	// pressionada
	public void keyPressed(KeyEvent tecla) {

		int codigo = tecla.getKeyCode();

		// movimenta para esquerda
		if (codigo == KeyEvent.VK_A || codigo == KeyEvent.VK_LEFT) {
			pressE = true;
            lastPress = true;
			dx = -velocidade;

		}

		// movimenta para direita
		if (codigo == KeyEvent.VK_D || codigo == KeyEvent.VK_RIGHT) {
			pressD = true;
			lastPress = false;
			dx = velocidade;

		}

		// comando de pulo
		if (!limitePulo) {
			if (codigo == KeyEvent.VK_SPACE || codigo == KeyEvent.VK_UP|| codigo == KeyEvent.VK_W) {
				if (noChao) {// verifica so o personagem esta no chao para poder
					noChao = false;
					pulo();// pular
				}
			}

		}

	}

	// solta
	public void keyReleased(KeyEvent tecla) {

		int codigo = tecla.getKeyCode();

		if (codigo == KeyEvent.VK_SPACE|| codigo == KeyEvent.VK_UP|| codigo == KeyEvent.VK_W) {
			dy = velocidadePulo;

		}

		if (codigo == KeyEvent.VK_A || codigo == KeyEvent.VK_LEFT) {
			pressE = false;
			dx = 0;
		}

		if (codigo == KeyEvent.VK_D || codigo == KeyEvent.VK_RIGHT) {
			pressD = false;
			dx = 0;
		}

	}

	// Getter e setters

	public int getVidas() {
		return vidas;
	}

	public int getChao() {
		return chao;
	}

	public void setChao(int chao) {
		this.chao = chao;
	}

	public int getProximoSprite() {
		return proximoSprite;
	}

	public void setProximoSprite(int proximoSprite) {
		this.proximoSprite = proximoSprite;
	}

	public int getDonuts() {
		return donuts;
	}

	public void setDonuts(int donuts) {
		this.donuts = donuts;
	}

	public int getVelocidadePulo() {
		return velocidadePulo;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public int getInicioX() {
		return inicioX;
	}

	public int getInicioY() {
		return inicioY;
	}

	public int getPuloLimite() {
		return puloLimite;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
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

	public Image getImagem() {
		return imagem;
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

	public boolean isNoChao() {
		return noChao;
	}

	public void setNoChao(boolean noChao) {
		this.noChao = noChao;
	}

	public boolean isLimitePulo() {
		return limitePulo;
	}

	public void setLimitePulo(boolean limitePulo) {
		this.limitePulo = limitePulo;
	}

	public int getPOSICAO_CHAO() {
		return chao;
	}

	public void setPOSICAO_CHAO(int pOSICAO_CHAO) {
		chao = pOSICAO_CHAO;
	}

	public int getVELOCIDADE_DO_PULO() {
		return velocidadePulo;
	}

	public int getVELOCIDADE_DA_CAMINHADA() {
		return velocidade;
	}

	public int getPOSICAO_INICIAL_X() {
		return inicioX;
	}

	public int getPOSICAO_INICIAL_Y() {
		return inicioY;
	}

	public int getALTURA_PULO() {
		return puloLimite;
	}

	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}

	public boolean isNoCentro() {
		return noCentro;
	}

	public void setNoCentro(boolean noCentro) {
		this.noCentro = noCentro;
	}

}
