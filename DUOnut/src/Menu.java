import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;


public class Menu {
	private Image menu;
	private Image logo;
	private Image menu2;
	private int  dy= -6, y=360;
	
	public Menu(){
		ImageIcon referencia = new ImageIcon("res//Menu1.png");
		menu = referencia.getImage();
		
		ImageIcon referencia2 = new ImageIcon("res//MENU.png");
		menu2 = referencia2.getImage();
		
		ImageIcon referencia1 = new ImageIcon("res//LOGO.png");
		logo = referencia1.getImage();
	}
	
	
	public void pintar(Graphics g){
	
		y += dy;
	
		
		
		g.drawImage(menu,0,0,null);
	
		g.drawImage(logo,360,y,null);
		
		if(y<=-110){
			dy = 0;
			y = -110;
			g.drawImage(menu2,0,0,null); 
		    g.setColor(Color.WHITE);
            g.setFont(new Font("foda-se", Font.BOLD, 50));
		    g.drawString("EXIT", (int) 975, (int) 620);
		}
		
		
		
		
	
	}
	
	
	
	
	

}
