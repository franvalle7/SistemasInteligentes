package presentación;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.*;
import dominio.*;

public class JPanelJuego extends JPanel {

	Casilla casillas[][];
	BufferedImage imgs[];
	int n,m, miniImages,ancho,alto, rand,aleatorios[];
	
	public JPanelJuego(int m, int n, BufferedImage [] imgs){
		this.imgs=imgs;
		this.n=n;
		this.m=m;
		miniImages=m*n;
		casillas= new Casilla[m][n];
		setLayout(new GridLayout(m,n,0,0));
		initialice();
	}
	
	public void initialice(){
		Random r= new Random();
		aleatorios=new int[imgs.length];
		for(int i=0;i<aleatorios.length;i++){
			aleatorios[i]=0;
		}
		ancho=imgs[0].getWidth();
		alto=imgs[0].getHeight();
		int contador=0;

		generaAleatorio(miniImages);
		for(int x=0;x<m;x++){
			for(int y=0;y<n;y++){
				if(aleatorios[contador]==0){
					Casilla casilla=new Casilla(aleatorios[contador],ancho * y, alto * x);
					add(casilla);
					
				}else{
					Casilla casilla=new Casilla(aleatorios[contador],ancho * y, alto * x,imgs[aleatorios[contador]]);
					casillas[x][y]=casilla;
					add(casilla);
					
				}
				contador++;
			}

		}
		     
	}
	
	public void reconstruir(Casilla casilla, String movimiento){
		
	}
	
	public void generaAleatorio(int cantidad){
		int i=0;
		
		aleatorios[0]=(int)(Math.random()*cantidad);
		for(i=1;i<cantidad;i++){
			aleatorios[i]= (int)(Math.random()*cantidad);
			for(int j=0;j<i;j++){
				if(aleatorios[j]==aleatorios[i]){
					i--;
				}
			}
		}
		
		
	}
	
}
