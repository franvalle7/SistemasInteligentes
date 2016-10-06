package presentación;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PanelDatos extends JPanel implements ActionListener {
	private JTextField textColum;
	private JTextField textFilas;
	JButton btnIniciar;
	BufferedImage img;
	int m=2;
	int n=2;

	/**
	 * Create the panel.
	 */
	public PanelDatos(BufferedImage img) {
		setName("Dimension del tablero");
		this.img=img;
		setLayout(new GridLayout(2, 3, 5, 5));
		
		JLabel lblColumnas = new JLabel("Columnas:");
		lblColumnas.setHorizontalAlignment(SwingConstants.CENTER);
		lblColumnas.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 11));
		add(lblColumnas);
		
		textColum = new JTextField();
		add(textColum);
		textColum.setColumns(10);
		
		JLabel label = new JLabel("");
		add(label);
		
		JLabel lblFilas = new JLabel("Filas:");
		lblFilas.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilas.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 11));
		add(lblFilas);
		
		textFilas = new JTextField();
		add(textFilas);
		textFilas.setColumns(10);
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 11));
		add(btnIniciar);
		btnIniciar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==(btnIniciar)) {
            VentanaJuego ventanajuego=null;
			try {
				ventanajuego = new VentanaJuego(img, m,n);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			ventanajuego.setVisible(true);
            
        }
		
	}

}
