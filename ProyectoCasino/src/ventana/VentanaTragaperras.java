package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.*;

import clases.Ranking;
import clases.Tragaperras;
import database.Db;

public class VentanaTragaperras extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel panelInfo;
	
	private JButton btnPlay;
	private JButton btnMenu;
	private JButton btnAniadir;
	
	private JLabel lblSaldo;
	private JLabel lblInfo;
	private JLabel lblPuntaje;
	private JLabel lblUsuario;
	private JLabel lblResult;
	
	private int saldo = 0;
	private int puntos = 0;
	private int numpartida;
	private int a = 0;
	private int b = 0;
	private int c = 0;
	private int scoreTirada;
	
	ArrayList<ImageIcon> iconos = new ArrayList<ImageIcon>();
	
	private Random r = new Random();
	
	public static void main(String[] args) {
		VentanaTragaperras frame = new VentanaTragaperras("");
		frame.setVisible(true);
	}
	
	//nueva clase panelimagen para establecer el fondo de la ventana
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
	
	public VentanaTragaperras(String usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setTitle("Tragaperras");
		Border bevel = BorderFactory.createBevelBorder(BevelBorder.RAISED);
		
		PanelImagen p = new PanelImagen("/images/fondo.jpg");
		p.setBorder(new EmptyBorder(5,5,5,5));
		p.setLayout(null);
		setContentPane(p);
		
		//rellenamos arraylist de iconos 
		ImageIcon siete = new ImageIcon((getClass().getResource("/images/7.jpg")));
		ImageIcon bar = new ImageIcon(getClass().getResource("/images/bar.jpg"));
		ImageIcon campana = new ImageIcon(getClass().getResource("/images/campana.jpg"));
		ImageIcon cerezas = new ImageIcon(getClass().getResource("/images/cerezas.jpg"));
		ImageIcon diamante = new ImageIcon(getClass().getResource("/images/diamante.jpg"));
		ImageIcon dolar = new ImageIcon(getClass().getResource("/images/dolar.jpg"));
		ImageIcon limon = new ImageIcon(getClass().getResource("/images/limon.jpg"));
		ImageIcon sandia = new ImageIcon(getClass().getResource("/images/sandia.jpg"));
		ImageIcon trebol = new ImageIcon(getClass().getResource("/images/trebol.jpg"));
		ImageIcon uva = new ImageIcon(getClass().getResource("/images/uva.jpg"));
			
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
		
		// LABELS, BOTONES Y PANEL INFO
		btnMenu = new JButton("MENU");
		btnMenu.setBounds(100, 600, 150, 75);
		btnMenu.setBackground(Color.RED);
		btnMenu.setForeground(Color.WHITE);
		btnMenu.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnMenu.setBorder(bevel);
		getContentPane().add(btnMenu);
		
		btnMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					Db.initDB("casino1.db", false);
					numpartida = Db.obtenerPartidas(usuario) + 1;
					Ranking r = new Ranking("Tragaperras", usuario, numpartida, puntos);
					Db.anadirRanking(r);
					Db.closeBD();
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		Main m = new Main(usuario);
        		m.setVisible(true);
        		dispose();
        		Main.activarBotones();
        	}
		});
		
		
		btnPlay = new JButton("PLAY");
		btnPlay.setBackground(Color.GREEN);
		btnPlay.setForeground(Color.WHITE);
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 55));
		btnPlay.setBounds(950, 100, 250, 125);
		btnPlay.setBorder(bevel);
		getContentPane().add(btnPlay);
		
		
		panelInfo = new JPanel();
		panelInfo.setBorder(bevel);
		panelInfo.setBounds(900, 275, 350, 400);
		panelInfo.setBackground(Color.WHITE);
		panelInfo.setLayout(null);
		
		lblSaldo = new JLabel("Saldo: " + saldo);
		lblSaldo.setFont(new java.awt.Font("Arial", 1, 22)); 
        lblSaldo.setForeground(new java.awt.Color(51, 51, 51));
        lblSaldo.setBounds(50, 100, 250, 40);
        
        lblInfo = new JLabel("Cada tirada vale 20");
        lblInfo.setFont(new java.awt.Font("Arial", 1, 22)); 
        lblInfo.setForeground(new java.awt.Color(51, 51, 51));
        lblInfo.setBounds(50, 200, 250, 40);
        
        lblUsuario = new JLabel("Usuario "+ usuario);
        lblUsuario.setFont(new java.awt.Font("Arial", 1, 22)); 
        lblUsuario.setForeground(new java.awt.Color(51, 51, 51));
        lblUsuario.setBounds(50, 50, 250, 40);
        
        lblPuntaje = new JLabel("Puntos: "+ puntos);
        lblPuntaje.setFont(new java.awt.Font("Arial", 1, 22)); 
        lblPuntaje.setForeground(new java.awt.Color(51, 51, 51));
        lblPuntaje.setBounds(50, 150, 250, 40);
        
        lblResult = new JLabel("", SwingConstants.CENTER);
		lblResult.setBounds(100, 400, 690, 150);
		lblResult.setOpaque(true);
		lblResult.setBackground(new java.awt.Color(51, 51, 51));
		lblResult.setForeground(Color.WHITE);
		lblResult.setFont(new java.awt.Font("Arial", 1, 30));
		getContentPane().add(lblResult);
		
		btnAniadir = new JButton("Añadir dinero");
        btnAniadir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int cant = Integer.parseInt(JOptionPane.showInputDialog("Introduce el dinero que quieres ingresar: "));
        		int total = cant +saldo;
        		saldo = total;
        		lblSaldo.setText("Saldo: " + saldo);
        	}
        });
        btnAniadir.setBackground(Color.CYAN);
        btnAniadir.setForeground(Color.BLACK);
        btnAniadir.setFont(new Font("Arial", 1, 22));
        btnAniadir.setBounds(50, 275, 250, 75);
        
		panelInfo.add(lblInfo);
		panelInfo.add(lblSaldo);
		panelInfo.add(lblUsuario);
		panelInfo.add(lblPuntaje);
		panelInfo.add(btnAniadir);
		getContentPane().add(panelInfo);
		
		//label tragaperras
		JLabel lblTragap1 = new JLabel();
		JLabel lblTragap2 = new JLabel();
		JLabel lblTragap3 = new JLabel();
		
		//creamos panel tragaperras
		JPanel panelTragap = new JPanel();
		panelTragap.setBorder(bevel);
		panelTragap.setBounds(100, 100, 690, 240);
		panelTragap.setBackground(Color.lightGray);
		
		JPanel panelTragap1 = new JPanel();
		panelTragap1.setBorder(new BevelBorder(BevelBorder.LOWERED));
		panelTragap1.setLayout(null);
		
		JPanel panelTragap2 = new JPanel();
		panelTragap2.setBorder(new BevelBorder(BevelBorder.LOWERED));
		panelTragap2.setLayout(null);
		
		JPanel panelTragap3 = new JPanel();
		panelTragap3.setBorder(new BevelBorder(BevelBorder.LOWERED));
		panelTragap3.setLayout(null);
		
		//organizamos el panel de la maquina tragaperras
		GroupLayout tragapLayout = new GroupLayout(panelTragap);
		panelTragap.setLayout(tragapLayout);
		tragapLayout.setHorizontalGroup(
				tragapLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(tragapLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelTragap1, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addGap(15,15,15)
					.addComponent(panelTragap2, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addGap(15,15,15)
					.addComponent(panelTragap3, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		tragapLayout.setVerticalGroup(
				tragapLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(tragapLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(tragapLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
							.addComponent(panelTragap1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
							.addComponent(panelTragap2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
							.addComponent(panelTragap3, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		
		//Ajustamos los iconos que saldrán en la tragaperras
		panelTragap1.add(lblTragap1);
		panelTragap2.add(lblTragap2);
		panelTragap3.add(lblTragap3);
		
		lblTragap1.setBounds(2,2,206,206);
		lblTragap2.setBounds(2,2,210,210);
		lblTragap3.setBounds(2,2,210,210);
		
		Icon icon1 = new ImageIcon(iconos.get(a).getImage().getScaledInstance(lblTragap1.getWidth(), lblTragap1.getHeight(), Image.SCALE_DEFAULT));
		Icon icon2 = new ImageIcon(iconos.get(b).getImage().getScaledInstance(lblTragap1.getWidth(), lblTragap1.getHeight(), Image.SCALE_DEFAULT));
		Icon icon3 = new ImageIcon(iconos.get(c).getImage().getScaledInstance(lblTragap1.getWidth(), lblTragap1.getHeight(), Image.SCALE_DEFAULT));
		
		lblTragap1.setIcon(icon1);
		lblTragap2.setIcon(icon2);
		lblTragap3.setIcon(icon3);
		
		getContentPane().add(panelTragap);
		
		//Accion que realiza el boton Play
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(saldo<=1) {
					JOptionPane.showMessageDialog(null, "No tienes saldo", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					saldo -= 2;
					lblSaldo.setText("Saldo: " + saldo);
					a = r.nextInt(iconos.size()); //Genera un número random para elegir la imagen de entre todos los iconos
					b = r.nextInt(iconos.size());
					c = r.nextInt(iconos.size());
					Icon icon1 = new ImageIcon(iconos.get(a).getImage().getScaledInstance(lblTragap1.getWidth(), lblTragap1.getHeight(), Image.SCALE_DEFAULT));
					Icon icon2 = new ImageIcon(iconos.get(b).getImage().getScaledInstance(lblTragap1.getWidth(), lblTragap1.getHeight(), Image.SCALE_DEFAULT));
					Icon icon3 = new ImageIcon(iconos.get(c).getImage().getScaledInstance(lblTragap1.getWidth(), lblTragap1.getHeight(), Image.SCALE_DEFAULT));
					lblTragap1.setIcon(icon1);
					lblTragap2.setIcon(icon2);
					lblTragap3.setIcon(icon3);
					scoreTirada = Tragaperras.score(a, b, c); //Llamamos al método de la clase tragaperras para calcular los puntos
					puntos = puntos + scoreTirada;
					lblPuntaje.setText("Puntos: "+ puntos);
					lblResult.setText("Has hecho una tirada de "+ scoreTirada +" puntos");
				}
			}
		});
		
	}
	
}
