import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JPanel;
import javax.swing.Timer;

public class Jogo extends JPanel implements ActionListener {

	private Timer timer; // chama a classe Timer(classe de funçao do java)
	private Hitech hitech; // chama a classe fase
	private Vintage vintage;
	private Menu menu;
	private boolean menuVisivel = true;
	private int escolhaDeFase;

	public Jogo() {

		setFocusable(true);
		setDoubleBuffered(true);

		addKeyListener(new tecladoAdapter()); // chama a funçao de teclado
		addMouseListener(new MouseInputHandler());

		menu = new Menu();
		hitech = new Hitech(); // adiciona a classe Fase
		vintage = new Vintage();
		timer = new Timer(25, this);// adiciona a classe Timer(milesegundos,
									// chama a propria classe)
		timer.start(); // aciona o timer

	}

	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g; // adiciona uma imagem 2D

		if (menuVisivel) {
			menu.pintar(graficos);
		}
		if (escolhaDeFase == 1 && !menuVisivel) {

			hitech.paint(graficos); // chama a funçao paint da classe Fase
		}
		if (escolhaDeFase == 2 && !menuVisivel) {
			vintage.paint(graficos);
		}

		g.dispose(); // Apaga

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (escolhaDeFase == 1) {
			hitech.update(); // chama o update da fase
		}
		if (escolhaDeFase == 2) {
			vintage.update(); // chama o update da fase 2
		}

		repaint(); // repinta a tela(atualiza)

	}

	public class MouseInputHandler extends MouseAdapter {
		@Override
		public void mouseClicked (MouseEvent e) {
			if (menuVisivel) {
				if (e.getX() > 668 && e.getX() < 989 && e.getY() < 230
						&& e.getY() > 73) {
					vintage.iniciaTempo();
					menuVisivel = false;
					escolhaDeFase = 2;
				}
				if (e.getX() > 251 && e.getX() < 478 && e.getY() < 544
						&& e.getY() > 196) {
					hitech.iniciaTempo();
					menuVisivel = false;
					escolhaDeFase = 1;
				}

				if (e.getX() > 970 && e.getX() < 1082 && e.getY() < 625
						&& e.getY() > 571) {
					System.exit(0);

				}
			}

		}

	}

	private class tecladoAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {

			hitech.keyPressed(e);
			vintage.keyPressed(e);// chama a funçao de tecla presionada da
									// classe Fase

		}

		@Override
		public void keyReleased(KeyEvent e) {

			vintage.keyReleased(e);
			hitech.keyReleased(e); // chama a funçao de tecla solta da classe
									// Fase

		}

	}

}
