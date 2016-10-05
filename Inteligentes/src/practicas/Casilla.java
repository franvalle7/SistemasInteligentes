package practicas;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Casilla extends JButton {
	
	public Casilla(int x, int y, BufferedImage img) {
		this.id = id;
		this.x = x;
		this.y = y;
		setIcon(new ImageIcon(img));
		setOpaque(true);
	}

	int id, x, y;

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
