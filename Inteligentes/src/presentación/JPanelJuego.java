package presentación;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import javax.swing.*;
import dominio.Casilla;

public class JPanelJuego extends JPanel {

	Casilla casillas[], bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10,bt11,bt12,bt13,bt14,bt15,bt16;
	BufferedImage imgs[];
	int n,m, miniImages,ancho,alto;
	
	public JPanelJuego(int m, int n, BufferedImage [] imgs){
		this.imgs=imgs;
		this.n=n;
		this.m=m;
		miniImages=m*n;
		casillas= new Casilla[imgs.length];
		setLayout(new GridLayout(m,n,0,0));
		initialice();
	}
	
	public void initialice(){
		ancho=imgs[0].getWidth();
		alto=imgs[0].getHeight();
		int contador=0;
		for(int x=0;x<m;x++){
			for(int y=0;y<n;y++){
				Casilla casilla=new Casilla(ancho * y, alto * x,imgs[contador]);
				//casilla.setImagen(imgs[contador]);
				casillas[contador]=casilla;
				add(casilla);
				contador++;
			}
		}
		       
	}
}
