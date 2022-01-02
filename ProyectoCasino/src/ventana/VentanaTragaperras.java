package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

public class VentanaTragaperras extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JButton btnPlay;
	private JButton btnMenu;
	
	private JLabel lblCreditos;
	private JLabel lblResult;
	
	public static ArrayList<ImageIcon> iconos = new ArrayList<ImageIcon>();
	
	public static void main(String[] args) {
		VentanaTragaperras frame = new VentanaTragaperras();
		frame.setVisible(true);
	}
	
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
		setTitle("Tragaperras");
		
		PanelImagen p = new PanelImagen("/images/fondo.jpg");
		p.setBorder(new EmptyBorder(5,5,5,5));
		p.setLayout(null);
		setContentPane(p);
		
		
		btnMenu = new JButton("MENU");
		btnMenu.setBounds(100, 600, 150, 75);
		btnMenu.setBackground(Color.RED);
		btnMenu.setForeground(Color.WHITE);
		btnMenu.setFont(new Font("Tahoma", Font.BOLD, 30));
		getContentPane().add(btnMenu);
		
		try {
			btnPlay = new JButton();
			btnPlay.setBounds(1000, 100, 200, 100);
			ImageIcon play = new ImageIcon(getClass().getResource("/images/start.jpg"));
			Icon iconoPlay = new ImageIcon(play.getImage().getScaledInstance(btnPlay.getWidth(), btnPlay.getHeight(), Image.SCALE_DEFAULT));
			btnPlay.setIcon(iconoPlay);
		} catch(Exception e) {
			btnPlay = new JButton("PLAY");
			btnPlay.setBackground(Color.GREEN);
			btnPlay.setForeground(Color.WHITE);
			btnPlay.setFont(new Font("Tahoma", Font.BOLD, 50));
			btnPlay.setBounds(950, 100, 250, 125);
		}
		
		getContentPane().add(btnPlay);
		
		ImageIcon siete = new ImageIcon("/images/7.jpg");
		ImageIcon bar = new ImageIcon("/images/bar.jpg");
		ImageIcon campana = new ImageIcon("/images/campana.jpg");
		ImageIcon cerezas = new ImageIcon("/images/cerezas.jpg");
		ImageIcon diamante = new ImageIcon("/images/diamante.jpg");
		ImageIcon dolar = new ImageIcon("/images/dolar.jpg");
		ImageIcon limon = new ImageIcon("/images/limon.jpg");
		ImageIcon sandia = new ImageIcon("/images/sandia.jpg");
		ImageIcon trebol = new ImageIcon("/images/trebol.jpg");
		ImageIcon uva = new ImageIcon("/images/uva.jpg");
		
		iconos.add(siete);
		iconos.add(bar);
		iconos.add(campana);
		iconos.add(cerezas);
		iconos.add(diamante);
		iconos.add(dolar);
		iconos.add(limon);
		iconos.add(sandia);
		iconos.add(trebol);
		iconos.add(uva);
		
	}
	

}
