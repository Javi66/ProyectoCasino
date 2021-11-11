package ventana;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaLogin extends JFrame{
	private JLabel nombreusuario;
	private JLabel contrasenia;
	private JButton btnEntrar;
	private JButton btnSalir;
	
	public VentanaLogin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 200, 975, 650);
		setSize(500,400);
		Container cp = this.getContentPane();
		JPanel login = new JPanel();
		login.setLayout(new GridLayout(1, 2));
		cp.add(login);
	}

}
