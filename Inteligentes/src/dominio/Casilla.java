package dominio;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import presentación.JPanelImagen;

public class Casilla extends JPanelImagen {
	private BufferedImage img;
	private int id, x, y;
	
	public Casilla(int id,int x, int y,BufferedImage img) {
		super(img);
		this.img=img;
		this.x = x;
		this.y = y;
		setOpaque(true);
		
		
	}
	public Casilla(int id, int x, int y) {
		super();
		this.x = x;
		this.y = y;
		setOpaque(true);
		
		
	}
	
	/*public Casilla( BufferedImage img) {
		this.id = id;
		this.x = x;
		this.y = y;
		setOpaque(true);
	}*/

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	

}
