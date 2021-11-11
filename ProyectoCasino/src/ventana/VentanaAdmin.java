package ventana;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.GestorUsuario;
import clases.Usuario;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class VentanaAdmin extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnImprimirUsuarios;
	private JTextField txtusuarios;
	public static void main(String[] args) {
		VentanaAdmin va = new VentanaAdmin();
		va.getContentPane().setBackground(Color.BLACK);
		va.setTitle("Ventana Admin");
		va.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		va.setVisible(true);
		}
	
	public VentanaAdmin() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		btnImprimirUsuarios = new JButton("Imprimir Usuarios");
		btnImprimirUsuarios.setForeground(Color.BLACK);
		btnImprimirUsuarios.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtusuarios = new JTextField();
		txtusuarios.setBounds(162, 91, 147, 37);
		panel.add(txtusuarios);
		txtusuarios.setColumns(10);
		btnImprimirUsuarios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Thread t = new Thread() {
					@Override
					public void run() {
						for (Usuario usuario : GestorUsuario.obtenerUsuariosOrdenados()) {
							System.out.println(usuario);
							txtusuarios.setText("Usuarios:"+" "+usuario);
							try {
								Thread.sleep(2000);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				};
				
				t.start();
			}
		});
	
		btnImprimirUsuarios.setBounds(162, 67, 147, 23);
		panel.add(btnImprimirUsuarios);
		
	}
	
	
}
