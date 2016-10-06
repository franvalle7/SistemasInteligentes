package presentación;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Point;


public class VentanaInicio extends JFrame implements ActionListener{
	JMenuBar menubar;	 
    JMenu menu; 
    JMenuItem itemAbrir, itemSalir;
    private BufferedImage imagen;
    JPanelImagen panel=null;
    VentanaJuego frame;
    private JLabel lblNewLabel;
    private JPanel panel_1;
    private JLabel lblColumnas;
    private JTextField textColum;
    private JLabel lblFilas;
    private JTextField textFilas;
    private JButton btnIniciar;
    private JLabel label;
    int m,n;
    
    public VentanaInicio(){
    	super("Seleccionar Imagen");
    	setTitle("Configurar Tablero");
    	setResizable(false);
    	setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaInicio.class.getResource("/resources/1475593196364404541620.jpg")));
    	getContentPane().setBackground(Color.DARK_GRAY);
    	
    	lblNewLabel = new JLabel("   Presiona Inicio para cargar una imagen");
    	lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 11));
    	lblNewLabel.setForeground(Color.WHITE);
    	getContentPane().add(lblNewLabel, BorderLayout.NORTH);
    	
    	panel_1 = new JPanel();
    	panel_1.setBackground(Color.DARK_GRAY);
    	getContentPane().add(panel_1, BorderLayout.CENTER);
    	panel_1.setLayout(new GridLayout(2, 3, 0, 0));
    	
    	lblColumnas = new JLabel("Columnas:");
    	lblColumnas.setHorizontalAlignment(SwingConstants.CENTER);
    	lblColumnas.setForeground(Color.WHITE);
    	lblColumnas.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 11));
    	panel_1.add(lblColumnas);
    	
    	textColum = new JTextField();
    	textColum.setToolTipText("Tama\u00F1o 3x3 m\u00EDnimo");
    	textColum.setSize(new Dimension(20, 20));
    	textColum.setHorizontalAlignment(SwingConstants.CENTER);
    	panel_1.add(textColum);
    	textColum.setColumns(1);
    	
    	
    	label = new JLabel("");
    	panel_1.add(label);
    	
    	
    	
    	lblFilas = new JLabel("Filas:");
    	lblFilas.setHorizontalAlignment(SwingConstants.CENTER);
    	lblFilas.setForeground(Color.WHITE);
    	lblFilas.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 11));
    	panel_1.add(lblFilas);
    	
    	textFilas = new JTextField();
    	textFilas.setToolTipText("Tama\u00F1o 3x3 m\u00EDnimo");
    	textFilas.setHorizontalAlignment(SwingConstants.CENTER);
    	panel_1.add(textFilas);
    	textFilas.setColumns(10);
    	
    	
    	btnIniciar = new JButton("Iniciar");
    	btnIniciar.setEnabled(false);
    	panel_1.add(btnIniciar);
    	setSize(300, 200);
    	
	    menubar=new JMenuBar();
	    menubar.setBackground(Color.LIGHT_GRAY);
	    menubar.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
	    menu=new JMenu("Inicio");
	    menu.setToolTipText("Cargar Imagen");
	    itemAbrir= new JMenuItem("Abrir Imagen");
	    itemSalir= new JMenuItem("Salir");
	    
	    menu.add(itemAbrir);
	    menu.add(itemSalir);
	    menubar.add(menu);
	    setJMenuBar(menubar);
	    
	    itemAbrir.addActionListener(this);
	    itemSalir.addActionListener(this);
	    btnIniciar.addActionListener(this);
	    
    }
    
    public void cargarImagen() throws IOException{
    	FileInputStream fis = null;    	 
        File file = null;
        
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("PNG & JPG","png", "jpg");
        jfc.setFileFilter(filtroImagen);
        int resultado = jfc.showOpenDialog(this);
        if (resultado == jfc.APPROVE_OPTION) {
            file = jfc.getSelectedFile();
        }

        fis = new FileInputStream(file);
        imagen = ImageIO.read(fis);
        btnIniciar.setEnabled(true);          
        
    }	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==(itemAbrir)){
			try {
				cargarImagen();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else if (e.getSource() == itemSalir) { 
            System.exit(0);
 
        }else if(e.getSource()== btnIniciar){

			m=Integer.parseInt(textColum.getText());
			n=Integer.parseInt(textFilas.getText());
			if(m>=3 && n>=3){
				try {
					frame = new VentanaJuego(imagen,n,m);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
            frame.setVisible(true);
            dispose();
        }
	}     
    
}
	