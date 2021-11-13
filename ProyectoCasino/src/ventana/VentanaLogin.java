package ventana;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import ventana.Main;
public class VentanaLogin extends JFrame{
	private JLabel nombreusuario;
	private JLabel contrasenia;
	private JButton btnEntrar;
	private JButton btnSalir;
	private JTextField textousuario;
	private JPasswordField textocontra;
	
	public VentanaLogin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 200, 975, 650);
		setSize(320,300);
		setTitle( "Inicio Sesion" );
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		
		nombreusuario = new JLabel("Introduzca su nombre de usuario: ");
		nombreusuario.setBounds(10, 20, 250, 25);
		contentPane.add(nombreusuario);
		nombreusuario.setFont(new Font("Tahoma", Font.BOLD, 12));
	
		textousuario = new JTextField(25);
		textousuario.setBounds(50, 50, 200, 20);
		contentPane.add(textousuario);
	
		contrasenia = new JLabel("Introduzca su contrase�a: ");
		contrasenia.setBounds(10, 80, 250, 25);
		contentPane.add(contrasenia);
		contrasenia.setFont(new Font("Tahoma", Font.BOLD, 12));
	
		textocontra = new JPasswordField(25);
		textocontra.setBounds(50, 110, 200, 20);
		contentPane.add(textocontra);
	
		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(180, 200, 100, 40);
		contentPane.add(btnSalir);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBounds(10, 200, 100, 40);
		contentPane.add(btnEntrar);
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		btnEntrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (textousuario.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Escribe un nombre de usuario");
				} else if (textocontra.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Escribe una contrase�a");
				} else {
					dispose();
					Main.activarBotones();
				}
			}
		});
	}

}
