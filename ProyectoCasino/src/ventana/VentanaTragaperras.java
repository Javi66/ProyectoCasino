package ventana;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

public class VentanaTragaperras extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JButton btnPlay;
	private JButton btnMenu;
	
	private JLabel lblCreditos;
	private JLabel lblResult;
	
	/*public static void main(String[] args) {
		VentanaTragaperras frame = new VentanaTragaperras();
		frame.setVisible(true);
	}*/
	
	public class PanelImagen extends JPanel{
		ImageIcon imagen;
		String direccion;
		
		public PanelImagen(String direccion) {
			this.direccion = direccion;
		}
		
		@Override
		public void paintComponent(Graphics g) {
			Dimension tamanyo = getSize();
			imagen = new ImageIcon(getClass().getResource(direccion));
			g.drawImage(imagen.getImage(), 0, 0, tamanyo.width, tamanyo.height, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	}
	
	public VentanaTragaperras() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		
		PanelImagen p = new PanelImagen("/images/fondo.jpg");
		this.add(p);
		
		
	}
	

}
