package presentación;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.*;

public class VentanaInicio extends JFrame implements ActionListener {
	private JTextField columnas,filas;
	JPanelImagen panel;
	String col, fil;
	int m,n;
	BufferedImage img;
	JButton btnJugar;
	
	public VentanaInicio(BufferedImage img){
		super("Puzzle");
		this.img=img;
		getContentPane().setLayout(null);
		setSize(img.getWidth(),img.getHeight());
		
		initialice();
	}
	
	public void initialice(){
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setSize(img.getWidth(),img.getHeight());
		getContentPane().add(splitPane);
		
		JPanelImagen panel_1 = new JPanelImagen(img);
		splitPane.setRightComponent(panel_1);
		panel_1.setSize(img.getWidth(), img.getHeight());
       
		JPanel panel_2 =new JPanel();
		
        JLabel lblNewLabel = new JLabel("Numero de columnas:");
    	lblNewLabel.setBackground(Color.BLACK);
    	lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
    	panel_2.add(lblNewLabel);
    	
    	columnas = new JTextField();
    	//columnas.setBounds(286, 114, 43, 20);
    	panel_2.add(columnas);
    	columnas.setColumns(10);
    	
    	JLabel lblNewLabel_1 = new JLabel("Numero de filas:");
    	lblNewLabel_1.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
    	lblNewLabel_1.setBounds(82, 156, 175, 14);
    	panel_2.add(lblNewLabel_1);
    	
    	filas = new JTextField();
    	filas.setBounds(286, 153, 43, 20);
    	panel_2.add(filas);
    	filas.setColumns(10);
    	
    	btnJugar = new JButton("JUGAR");
    	btnJugar.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 11));
    	btnJugar.setBounds(800, 113, 89, 23);
    	panel_2.add(btnJugar);
    	btnJugar.addActionListener(this);
    	
        splitPane.setLeftComponent(panel_2);
		
		
		/*panel = new JPanelImagen(img);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1013,688);
		//setResizable(false);
		setContentPane(panel);
		
		JLabel lblNewLabel = new JLabel("Numero de columnas:");
    	lblNewLabel.setBackground(Color.BLACK);
    	lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
    	lblNewLabel.setBounds(82, 116, 194, 14);
    	getContentPane().add(lblNewLabel);
    	
    	JLabel lblNewLabel_1 = new JLabel("Numero de filas:");
    	lblNewLabel_1.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
    	lblNewLabel_1.setBounds(82, 156, 175, 14);
    	getContentPane().add(lblNewLabel_1);
    	
    	columnas = new JTextField();
    	columnas.setBounds(286, 114, 43, 20);
    	getContentPane().add(columnas);
    	columnas.setColumns(10);
    	col=columnas.getText();
    	
    	filas = new JTextField();
    	filas.setBounds(286, 153, 43, 20);
    	getContentPane().add(filas);
    	filas.setColumns(10);
    	fil=filas.getText();
    	
    	
    	JLabel lblNota2 = new JLabel("y las filas que tendr\u00E1 el puzzle");
    	lblNota2.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 13));
    	lblNota2.setBounds(82, 60, 247, 14);
    	getContentPane().add(lblNota2);
    	
    	JLabel lblNota1 = new JLabel("Introduce las columnas");
    	lblNota1.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 13));
    	lblNota1.setBounds(82, 42, 247, 14);
    	getContentPane().add(lblNota1);
    	
    	btnJugar = new JButton("JUGAR");
    	btnJugar.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 11));
    	btnJugar.setBounds(800, 113, 89, 23);
    	getContentPane().add(btnJugar);
    	btnJugar.addActionListener(this);*/
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==(btnJugar)) {
			dispose();
            VentanaJuego ventanajuego=null;
			try {
				ventanajuego = new VentanaJuego(img, m,n);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ventanajuego.setVisible(true);
            
        }
		
	}
}
