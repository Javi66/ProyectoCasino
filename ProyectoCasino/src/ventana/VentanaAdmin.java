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

public class VentanaAdmin extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnImprimirUsuarios;
	
	public VentanaAdmin() {
		
		JPanel panel = new JPanel();
		
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		btnImprimirUsuarios = new JButton("Imprimir Usuarios");
		btnImprimirUsuarios.setForeground(Color.BLACK);
		btnImprimirUsuarios.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnImprimirUsuarios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Thread t = new Thread() {
					@Override
					public void run() {
						for (Usuario usuario : GestorUsuario.obtenerUsuariosOrdenados()) {
							System.out.println(usuario);
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
	
		btnImprimirUsuarios.setBounds(169, 93, 89, 23);
		panel.add(btnImprimirUsuarios);
	}
	
	
}
