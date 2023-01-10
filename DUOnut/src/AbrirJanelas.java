import javax.swing.JFrame;


public class AbrirJanelas extends JFrame {
	
	public AbrirJanelas() {
		
		add(new Jogo()); //adiciona um novo jogo
		setTitle("DUOnut"); //titulo
		setSize(1160, 675); //tamanho da tela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fechar a tela no x
		setLocationRelativeTo(null); //localizacao da tela; null = centro
		setResizable(false); //nao permite mover a tela
		setVisible(true); //mostra a tela do jogo
		
	}

	public static void main(String[] args) {
		new AbrirJanelas(); // começa o jogo

	}
}
