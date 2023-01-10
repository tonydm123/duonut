import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Vintage {
	private Personagem personagem; // Adiciona um personagem
	private Inimigo[] inimigo;// Adiciona um vetor de inimigos
	private Coletaveis[] donut;
	private Image fundo;// Adiciona um fundo
	private Image fundoF;
	private Image gameOver;// Adiciona uma imagem de game over
	private Plataformas[] plataforma;// Adiciona um vetor de plataformas
	private final int inicioX = 100;// da um X inicial
	private final int inicioY = 510;// da um Y inicial
	private boolean gameReset = false;// um boolean para ver se pode ou nao usar
	private boolean win = false; // // o game reset
	private int xMundo = 0;// pocisao da tela inicial
	private int xLE = 500, xLD = 575;// Adiciona um limite para o personagem
										// para a esquerda e a direita
	private boolean centro = false;// boolean para ver se o personagem chegou ao
									// centro da tela
	private boolean buttonpressD = false;
	private boolean buttonpressE = false;
	private Tempo timer;
	private Image donutI;

	// debug

	public Vintage() {
		personagem = new Personagem();

		ImageIcon referencia = new ImageIcon("res//VINTAGE.png");
		fundo = referencia.getImage();

		ImageIcon referencia1 = new ImageIcon("res//VINTAGE FRENTE.png");
		fundoF = referencia1.getImage();

		ImageIcon referencia2 = new ImageIcon("res//donutInterface.png");
		donutI = referencia2.getImage();

		// da valor de posicao e tamanho as plataformas
		plataforma = new Plataformas[13];
		plataforma[0] = new Plataformas(0, 610, 50, 410);
		plataforma[1] = new Plataformas(565, 610, 50, 850);
		plataforma[2] = new Plataformas(670, 469, 30, 495);
		plataforma[3] = new Plataformas(0, 371, 30, 500);
		plataforma[4] = new Plataformas(1490, 479, 30, 115);
		plataforma[5] = new Plataformas(1680, 610, 50, 272);
		plataforma[6] = new Plataformas(2088, 570, 80, 1110);
		plataforma[7] = new Plataformas(2320, 450, 30, 430);
		plataforma[8] = new Plataformas(2755, 345, 30, 200);
		plataforma[9] = new Plataformas(2897, 230, 30, 597);
		plataforma[10] = new Plataformas(3470, 610, 50, 5000);
		plataforma[11] = new Plataformas(3655, 230, 30, 170);
		plataforma[12] = new Plataformas(3953, 230, 30, 170);

		// inicia os inimigos
		iniciaInimigos();
		voltaColetaveis();

	}

	public void iniciaTempo() {
		this.timer = new Tempo();
	}

	public void voltaColetaveis() {
		donut = new Coletaveis[27];
		// primeira parte
		donut[0] = new Coletaveis(100, 235);
		donut[1] = new Coletaveis(150, 235);
		donut[2] = new Coletaveis(200, 235);
		donut[3] = new Coletaveis(250, 235);
		donut[4] = new Coletaveis(300, 235);
		donut[5] = new Coletaveis(350, 235);
		donut[6] = new Coletaveis(850, 350);
		donut[7] = new Coletaveis(900, 350);
		donut[8] = new Coletaveis(950, 350);
		donut[9] = new Coletaveis(1000, 350);
		donut[10] = new Coletaveis(1050, 350);

		// segunda parte
		donut[18] = new Coletaveis(2550, 315);
		donut[19] = new Coletaveis(2600, 315);
		donut[20] = new Coletaveis(2400, 315);
		donut[21] = new Coletaveis(2450, 315);
		donut[22] = new Coletaveis(2500, 315);

		// terceira parte
		donut[11] = new Coletaveis(3000, 100);
		donut[12] = new Coletaveis(3050, 100);
		donut[13] = new Coletaveis(3100, 100);
		donut[14] = new Coletaveis(3150, 100);
		donut[15] = new Coletaveis(3200, 100);
		donut[16] = new Coletaveis(3250, 100);
		donut[17] = new Coletaveis(3300, 100);

		donut[23] = new Coletaveis(3750, 100);

		donut[24] = new Coletaveis(4050, 100);

	}

	public void iniciaInimigos() {
		// adiciona inimigos e suas localizaçoes

		inimigo = new Inimigo[11];
		for (int i = 0; i < plataforma.length; i++) {
			inimigo[0] = new Inimigo(960, 562, 320, (int) plataforma[i].getY());
			inimigo[1] = new Inimigo(820, 360, 70, (int) plataforma[i].getY());
			inimigo[2] = new Inimigo(1000, 280, 80, (int) plataforma[i].getY());
			inimigo[3] = new Inimigo(210, 280, 100, (int) plataforma[i].getY());
			inimigo[4] = new Inimigo(2500, 280, 170, (int) plataforma[i].getY());
			inimigo[5] = new Inimigo(2490, 500, 270, (int) plataforma[i].getY());
			inimigo[6] = new Inimigo(2955, 500, 155, (int) plataforma[i].getY());
			inimigo[7] = new Inimigo(3350, 130, 80, (int) plataforma[i].getY());
			inimigo[8] = new Inimigo(3100, 130, 145, (int) plataforma[i].getY());
			inimigo[9] = new Inimigo(4105, 280, 100, (int) plataforma[i].getY());
			inimigo[10] = new Inimigo(4505, 280, 120,
					(int) plataforma[i].getY());
		}

	}

	public void update() {

		// torna o game reset e a tela de game over disponivel
		if (personagem.getVidas() == 0
				|| (timer != null && timer.getTimer() != null && timer
						.getTimer().equals("00:00"))) {
			gameReset = true;
			ImageIcon referencia2 = new ImageIcon("res//gameover.png");
			gameOver = referencia2.getImage();
		}

		if (!gameReset) {// Jogo ainda esta rodando

			if (personagem.isNoCentro()) {
				if (xMundo > 0) {
					if (personagem.getX() <= xLE) {
						if (buttonpressE) {
							personagem.setDx(0);
							xMundo -= 6;
						}
					}
				} else if (xMundo <= 0 && personagem.getX() <= xLE) {
					xMundo = 0;
					if (buttonpressE) {
						personagem.setDx(-(personagem
								.getVELOCIDADE_DA_CAMINHADA()));
					}
				}
			}

			personagem.mexer(xMundo); // chama a movimentacao do personagem

			if (personagem.getX() >= xLD && buttonpressD && xMundo <= 4880) {
				xMundo += personagem.getVELOCIDADE_DA_CAMINHADA();
			}

			if (centro) {
				if (personagem.getX() <= xLE && buttonpressE && xMundo >= 0) {
					xMundo -= personagem.getVELOCIDADE_DA_CAMINHADA();
				}

			}
			if (xMundo >= 4320) {
				win = true;

			}

			// ve se o personagem caiu no buraco
			if (personagem.getY() >= 600) {

				personagem.setNoChao(true);
				personagem.setNoCentro(false);
				personagem.setVidas(personagem.getVidas() - 1);
				xMundo = 0;
				personagem.setX(inicioX);
				personagem.setY(inicioY);
				iniciaInimigos();

			}

			for (int i = 0; i < inimigo.length; i++) {

				// ve so o personagem matou o inimigo if (inimigo[i] != null) {
				if (inimigo[i] != null) {
					inimigo[i].mexer();
					if (personagem.colideInimigo(inimigo[i], xMundo)) {
						if (personagem.getY() <= inimigo[i].getY() - 45) {
							personagem.pulo();
							inimigo[i] = null;

						} else { // ve se o personagem morreu pro inimigo

							personagem.setNoCentro(false);
							personagem.setVidas(personagem.getVidas() - 1);
							personagem.setNoChao(true);
							personagem.setX(inicioX);
							personagem.setY(inicioY);
							iniciaInimigos();
							xMundo = 0;
						}
					}

				}
			}

			// colisao de personagem e plataforma
			for (int i = 0; i < plataforma.length; i++) {
				if (personagem.colidePlataforma(plataforma[i], xMundo)) {
					// se o personagem caiu em cima da plataforma
					if (personagem.getY() + 33 < plataforma[i].getY()) {
						personagem
								.setY((int) (plataforma[i].getY() - personagem
										.getAltura()));
						personagem.setChao((int) plataforma[i].getY());
						personagem.setDy(+6);
						personagem.setNoChao(true);
						// se o personagem bate em baixo da plataforma
					} else if (personagem.getY() > plataforma[i].getY()) {
						personagem
								.setY((int) (plataforma[i].getY() + plataforma[i]
										.getAltura()));
						personagem.trataColBaixo();
					} else {
						personagem.setNoChao(false);
						personagem.setDy(7);
						personagem.setDx(0);

					}

				}

			}
			for (int i = 0; i < plataforma.length; i++) {
				if (personagem.getY() + personagem.getAltura() - 40 > personagem
						.getChao()) {
					personagem.setNoChao(false);
				}

			}

			// colisao do inimigo e plataforma
			for (int i = 0; i < plataforma.length; i++) {
				for (int j = 0; j < inimigo.length; j++) {
					if (inimigo[j] != null) {
						if (inimigo[j].colidePlataforma(plataforma[i], xMundo)) {
							if (inimigo[j].getY() < plataforma[i].getY()) {
								inimigo[j]
										.setY((int) (plataforma[i].getY() - inimigo[j]
												.getAltura()));
								inimigo[j].setChao((int) plataforma[i].getY());
							}
						}
					}
				}
			}

			for (int i = 0; i < donut.length; i++) {
				if (donut[i] != null) {
					if (personagem.colideColetaveis(donut[i], xMundo)) {
						personagem.setDonuts(personagem.getDonuts() + 1);
						personagem.oneUP(personagem.getDonuts());
						donut[i] = null;
					}

				}

			}
		}
	}

	// pinta os elementos na tela
	public void paint(Graphics2D g) {

		if (!gameReset) {

			g.drawImage(fundo, 0 - xMundo, -10, null);

			// desenha as plataformas

			g.setColor(Color.YELLOW);
			g.fillRect((int) 4884 - xMundo, (int) 0, (int) 40, (int) 580);

			for (int i = 0; i < donut.length; i++) {
				if (donut[i] != null) {
					g.drawImage(donut[i].getImagem(), donut[i].getX() - xMundo,
							donut[i].getY(), null);
				}
			}
			/*
			 * for (int i = 0; i < plataforma.length; i++) {
			 * plataforma[i].paint(g, xMundo,1); }
			 */

			// desenha os inimigos

			for (int i = 0; i < inimigo.length; i++) {
				if (inimigo[i] != null) {
					g.drawImage(inimigo[i].getImagem(), inimigo[i].getX()
							- xMundo, inimigo[i].getY(), null);
				}
			}

			// desenha o personagem
			g.drawImage(personagem.getImagem(), personagem.getX(),
					personagem.getY(), null);

			// desenha o contador de vidas
			g.setColor(Color.BLACK);
			g.setFont(new Font("Jokerman", Font.BOLD, 40));
			g.drawString("Vidas: " + personagem.getVidas(), (int) 20, (int) 40);
			g.drawImage(donutI, 20, 60, null);
			g.setFont(new Font("Jokerman", Font.BOLD, 20));
			g.drawString("X" + personagem.getDonuts(), 50, 78);

			g.drawImage(fundoF, 0 - xMundo, 0, null);

			if (xMundo >= 4320) {
				g.setColor(Color.YELLOW);
				g.setFont(new Font("Jokerman", Font.BOLD, 100));
				g.drawString("LEVEL CLEARED", (int) 200, (int) 300);

			}

			if (timer.getTimer().equals("00:00")) {
				gameReset = true;
				timer.cancela();
			} else {
				g.setFont(new Font("Jokerman", Font.BOLD, 40));
				if(timer.getTimer().equals("03:00")){
					g.setColor(Color.BLACK);
				}else if(timer.getTimer().equals("00:30")){
					g.setColor(Color.RED);
				}
				g.drawString("" + timer.getTimer(), 500, 50);

			}

		}
		if (gameReset) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 1160, 660);
			g.drawImage(gameOver, 100, 50, null);
		}

	}

	public void keyPressed(KeyEvent tecla) {

		personagem.keyPressed(tecla);// ve se a tecla esta presionada

		int codigo = tecla.getKeyCode();

		// movimenta para direita
		if (codigo == KeyEvent.VK_D || codigo == KeyEvent.VK_RIGHT) {
			// limite direita para o personagem parar e a tela começcar a andar
			buttonpressD = true;

		}

		// movimenta para esquerda
		if (codigo == KeyEvent.VK_A || codigo == KeyEvent.VK_LEFT) {
			// limite esquerda para o personagem parar e a tela começcar a andar
			buttonpressE = true;
		}

	}

	public void keyReleased(KeyEvent tecla) {

		personagem.keyReleased(tecla);// ve se a tecla foi solta

		int codigo = tecla.getKeyCode();

		// apertar enter para resetar o jogo

		if (gameReset || win) {
			if (codigo == KeyEvent.VK_ENTER) {
				timer = new Tempo();
				personagem.setNoCentro(false);
				personagem.setNoChao(true);
				win = false;
				gameReset = false;
				xMundo = 0;
				iniciaInimigos();
				personagem.setDonuts(0);
				personagem.setVidas(3);
				voltaColetaveis();
				personagem.setX(inicioX);
				personagem.setY(inicioY);

			}
		}
		if (codigo == KeyEvent.VK_A || codigo == KeyEvent.VK_LEFT) {
			buttonpressE = false;
		}
		if (codigo == KeyEvent.VK_D || codigo == KeyEvent.VK_RIGHT) {
			buttonpressD = false;
		}

	}

	// Getters e setters

	public Personagem getPersonagem() {
		return personagem;
	}

	public Coletaveis[] getDonut() {
		return donut;
	}

	public void setDonut(Coletaveis[] donut) {
		this.donut = donut;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public boolean isButtonpressD() {
		return buttonpressD;
	}

	public void setButtonpressD(boolean buttonpressD) {
		this.buttonpressD = buttonpressD;
	}

	public boolean isButtonpressE() {
		return buttonpressE;
	}

	public void setButtonpressE(boolean buttonpressE) {
		this.buttonpressE = buttonpressE;
	}

	public Tempo getTimer() {
		return timer;
	}

	public void setTimer(Tempo timer) {
		this.timer = timer;
	}

	public Image getDonutI() {
		return donutI;
	}

	public void setDonutI(Image donutI) {
		this.donutI = donutI;
	}

	public int getInicioX() {
		return inicioX;
	}

	public int getInicioY() {
		return inicioY;
	}

	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}

	public Inimigo[] getInimigo() {
		return inimigo;
	}

	public void setInimigo(Inimigo[] inimigo) {
		this.inimigo = inimigo;
	}

	public Image getFundo() {
		return fundo;
	}

	public void setFundo(Image fundo) {
		this.fundo = fundo;
	}

	public Image getGameOver() {
		return gameOver;
	}

	public void setGameOver(Image gameOver) {
		this.gameOver = gameOver;
	}

	public Plataformas[] getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataformas[] plataforma) {
		this.plataforma = plataforma;
	}

	public boolean isGameReset() {
		return gameReset;
	}

	public void setGameReset(boolean gameReset) {
		this.gameReset = gameReset;
	}

	public int getxMundo() {
		return xMundo;
	}

	public void setxMundo(int xMundo) {
		this.xMundo = xMundo;
	}

	public int getxLE() {
		return xLE;
	}

	public void setxLE(int xLE) {
		this.xLE = xLE;
	}

	public int getxLD() {
		return xLD;
	}

	public void setxLD(int xLD) {
		this.xLD = xLD;
	}

	public int getPOSICAO_INICIAL_X() {
		return inicioX;
	}

	public int getPOSICAO_INICIAL_Y() {
		return inicioY;
	}

	public boolean isCentro() {
		return centro;
	}

	public void setCentro(boolean centro) {
		this.centro = centro;
	}

}
