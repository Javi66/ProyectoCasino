package ventana;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.TreeMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import clases.Usuario;
import database.Db;
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
		setResizable(false);
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
				Main vl = new Main("");
				vl.setVisible(true);
			}
		});
		
		btnEntrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String usuario = textousuario.getText();
				String contrasenya = String.valueOf(textocontra.getPassword());
				String admin = "admin";
				if (usuario.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Escribe un nombre de usuario", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (contrasenya.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Escribe una contrase�a", "Error", JOptionPane.ERROR_MESSAGE);
				} else if( usuario.equals(admin)  && contrasenya.equals(admin)) {
					//SI EL USUARIO ES ADMIN ABRIMOS UN MAIN PARA ADMIN
					JOptionPane.showMessageDialog(null, "Bienvenido administrador " , "Credenciales correctas.", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					Main vl = new Main(usuario);
					vl.setVisible(true);
					Main.activarBotones();
				}  else {
					try {
						Db.initDB("casino1.db", false);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					TreeMap<String, Usuario> tmUsuarios = new TreeMap<>();
					tmUsuarios = Db.obtenerMapaUsuario();
					if(tmUsuarios.containsKey(usuario)) {
						Usuario u = new Usuario();
						u = tmUsuarios.get(usuario);
						String c = u.getContrasenia();
						if(contrasenya.equals(c)) {
							JOptionPane.showMessageDialog(null, "Bienvenido usuario: " + usuario, "Credenciales correctas.", JOptionPane.INFORMATION_MESSAGE);
							//Si el usuario es correcto cerramos esta y abrimos la principal
							dispose();
							Db.closeBD();
							Main vl = new Main(usuario);
							vl.setVisible(true);
							Main.activarBotones();
							
						} else {
							JOptionPane.showMessageDialog(null, "Datos incorrectos", "Error",
									JOptionPane.ERROR_MESSAGE);
							//Si el usuario no es correcto damos mensaje de error
							
						}
					} else {
						JOptionPane.showMessageDialog(null, "Ese usuario no existe", "Error",
								JOptionPane.ERROR_MESSAGE);	
					}
				}
			}
		});
	}

}
