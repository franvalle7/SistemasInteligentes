package practicas;

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


public class VentanaPrincipal extends JFrame implements ActionListener{
	JMenuBar menubar;	 
    JMenu menu; 
    JMenuItem itemAbrir, itemSalir;
    private BufferedImage imagen;
    JPanelImagen panel=null;
    private JLabel lblNewLabel;
    
    public VentanaPrincipal(){
    	super("Seleccionar Imagen");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/resources/1475593196364404541620.jpg")));
    	getContentPane().setBackground(Color.DARK_GRAY);
    	
    	lblNewLabel = new JLabel("   Presiona Inicio para cargar una imagen");
    	lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 11));
    	lblNewLabel.setForeground(Color.WHITE);
    	getContentPane().add(lblNewLabel, BorderLayout.CENTER);
    	setSize(300, 200);
    	
	    menubar=new JMenuBar();
	    menu=new JMenu("Inicio");
	    itemAbrir= new JMenuItem("Abrir Imagen");
	    itemSalir= new JMenuItem("Salir");
	    
	    menu.add(itemAbrir);
	    menu.add(itemSalir);
	    menubar.add(menu);
	    setJMenuBar(menubar);
	    
	    itemAbrir.addActionListener(this);
	    itemSalir.addActionListener(this);
	    
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
                  
        VentanaInicio frame = new VentanaInicio(imagen);
        frame.setVisible(true);
        dispose();
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
 
        }		
	}     
    
}
	