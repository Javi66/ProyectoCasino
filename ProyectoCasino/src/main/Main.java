package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;

public class Main extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JButton btnSalir;
	private JButton btnIniciarSesion;
	private JButton btnRegistrarse;
	private JButton btnRuleta;
	private JButton btnTragaperras;

	/**
	 * Cargar la aplicación
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crear el JFrame.
	 */
	
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 975, 650);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(298)
					.addContainerGap(315, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(374, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
					.addGap(346))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
					.addGap(261))
		);
		btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setForeground(new Color(0, 0, 0));
		btnIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setForeground(new Color(0, 0, 0));
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 12));

		btnSalir = new JButton("Salir");
		btnSalir.setForeground(new Color(0, 0, 0));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 12));

		btnSalir.addActionListener(this);
		
		btnRuleta = new JButton("Ruleta");
		btnRuleta.setForeground(Color.BLACK);
		btnRuleta.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnTragaperras = new JButton("Tragaperras");
		btnTragaperras.setForeground(Color.BLACK);
		btnTragaperras.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnSalir, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnTragaperras, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnRuleta, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnIniciarSesion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnRegistrarse, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnRegistrarse, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnIniciarSesion, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRuleta, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnTragaperras, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(68, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		btnRegistrarse.addActionListener(this);
		btnIniciarSesion.addActionListener(this);
		contentPane.setLayout(gl_contentPane);	
	}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
