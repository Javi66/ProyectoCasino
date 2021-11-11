package ventana;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

public class VentanaRegistrar extends JFrame  {
	private static final long  serialVersionUID = 1L;
	private JPanel contentpane;
	private JButton btnGuardar ;
	private JButton btnSalir;
	public VentanaRegistrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 975, 650);
		contentpane = new JPanel();
		this.setSize(600, 800);
		setContentPane(contentpane);
		
		
	}
	public static void main (String[] args) {
		VentanaRegistrar v= new VentanaRegistrar();
		
		v.setVisible(true);
		
	}

}
