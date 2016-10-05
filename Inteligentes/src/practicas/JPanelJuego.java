package practicas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class JPanelJuego extends JPanel implements ActionListener{

	Casilla casillas[], bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10,bt11,bt12,bt13,bt14,bt15,bt16;
	BufferedImage imgs[];
	int n,m, miniImages;
	
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
		int contador=0;
		for(int x=0;x<m;x++){
			for(int y=0;y<n;y++){
				Casilla casilla=new Casilla(x,y,imgs[contador]);
				casillas[contador]=casilla;
				add(casillas[contador]);
				casillas[contador].addActionListener(this);
				contador++;
			}
		}
		
		/*bt1=new JButton();
		bt1.setBackground(Color.black);
		//bt1.setForeground(Color.black);
        bt2=new JButton("2");
        bt2.setIcon(new ImageIcon(imgs[1]));
        bt3=new JButton("3");
        bt3.setIcon(new ImageIcon(imgs[2]));
        bt4=new JButton("4");
        bt4.setIcon(new ImageIcon(imgs[3]));
        bt5=new JButton("5");
        bt5.setIcon(new ImageIcon(imgs[4]));
        bt6=new JButton("6");
        bt6.setIcon(new ImageIcon(imgs[5]));
        bt7=new JButton("7");
        bt7.setIcon(new ImageIcon(imgs[6]));
        bt8=new JButton("8");
        bt8.setIcon(new ImageIcon(imgs[7]));
        bt9=new JButton("9");
        bt9.setIcon(new ImageIcon(imgs[8]));
        bt10=new JButton("10");
        bt10.setIcon(new ImageIcon(imgs[9]));
        bt11=new JButton("11");
        bt11.setIcon(new ImageIcon(imgs[10]));
        bt12=new JButton("12");
        bt12.setIcon(new ImageIcon(imgs[11]));
        bt13=new JButton("13");
        bt13.setIcon(new ImageIcon(imgs[12]));
        bt14=new JButton("14");
        bt14.setIcon(new ImageIcon(imgs[13]));
        bt15=new JButton("15");
        bt15.setIcon(new ImageIcon(imgs[14]));
        bt16=new JButton("16");
        bt16.setIcon(new ImageIcon(imgs[15]));
        add(bt1);
        add(bt2);
        add(bt3);
        add(bt4);
        add(bt5);
        add(bt6);
        add(bt7);
        add(bt8);
        add(bt9);
        add(bt10);
        add(bt11);
        add(bt12);
        add(bt13);
        add(bt14);
        add(bt15);
        add(bt16);*/
        
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
