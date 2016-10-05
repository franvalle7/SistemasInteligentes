package presentación;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.*;

public class VentanaJuego extends JFrame{
	BufferedImage imgs[];
	BufferedImage img;
	int n,m,ancho,alto;
	
	public VentanaJuego(BufferedImage img, int m, int n) throws IOException {
		super("JUGANDO");
		setSize(img.getWidth(),img.getHeight()+30);
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
		this.img=img;
		this.m=m;
		this.n=n;
		dividirImagen();
		construyeVentana();
		
	}
	
	public void dividirImagen(){
		
        int miniImgs = m * n;
        ancho = img.getWidth() / n; // determines the chunk width and height
        alto = img.getHeight() / m;
        int count = 0;
        imgs = new BufferedImage[miniImgs]; //Image array to hold image chunks
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                //Initialize the image array with image chunks
                imgs[count] = new BufferedImage(ancho, alto, img.getType());

                // dibujando las sub-imagenes
                Graphics2D gr = imgs[count++].createGraphics();
                gr.drawImage(img, 0, 0, ancho, alto, ancho * y, alto * x, ancho * y + ancho, alto * x + alto, null);
                //gr.dispose();
            }
        }

        
        System.out.println("Splitting done");

        //writing mini images into image files
        for (int i = 0; i < imgs.length; i++) {
            try {
				ImageIO.write(imgs[i], "png", new File( i + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        System.out.println("Mini images created");
        
        
	}
	
	public BufferedImage[] getImages(){
		
		return imgs;
	}
	
	void construyeVentana(){
		
        JPanelJuego panel=new JPanelJuego(m,n,imgs);
		setContentPane(panel);
        
	}
}
