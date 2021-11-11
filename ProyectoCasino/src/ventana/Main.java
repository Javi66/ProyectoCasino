package ventana;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import clases.GestorUsuario;
import clases.Usuario;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
	private JButton btnImprimirUsuarios;
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
		
		ImageIcon icon = createImageIcon("\\images\\Casino.jpg", "");
		JLabel lblNewLabel = new JLabel("", icon, SwingConstants.CENTER);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(298)
					.addComponent(lblNewLabel)
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
					.addComponent(lblNewLabel)
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
		btnRuleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRuleta vr = new VentanaRuleta();
				vr.setVisible(true);
				
			}
		});
		btnRuleta.setForeground(Color.BLACK);
		btnRuleta.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnTragaperras = new JButton("Tragaperras");
		btnTragaperras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaTragaperras vt = new VentanaTragaperras();
				vt.setVisible(true);
			}
		});
		btnTragaperras.setForeground(Color.BLACK);
		btnTragaperras.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnImprimirUsuarios = new JButton("Imprimir");
		btnImprimirUsuarios.setForeground(Color.BLACK);
		btnImprimirUsuarios.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnTragaperras, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnRuleta, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnIniciarSesion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnRegistrarse, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnSalir, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnImprimirUsuarios, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
							.addContainerGap(31, Short.MAX_VALUE))))
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
					.addComponent(btnImprimirUsuarios, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		btnRegistrarse.addActionListener(this);
		btnIniciarSesion.addActionListener(this);
		contentPane.setLayout(gl_contentPane);	

	btnSalir.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	});

Thread reloj = new Thread(new Runnable() {
	public void run() {
		while(true)
		{
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
			String timeLabel = new String(LocalTime.now().format(dtf));
								
			setTitle(timeLabel);				
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}				
	}
});

reloj.start();

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
}
	
	private ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = Main.class.getClassLoader().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
