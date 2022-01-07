package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.*;

import clases.Icono;
import clases.Ranking;
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
	
	private int saldo = 0;
	private int puntos = 0;
	private int numpartida;
	
	private Icono c11;
	private Icono c12;
	private Icono c21;
	private Icono c22;
	private Icono c31;
	private Icono c32;
	
	public static ArrayList<ImageIcon> iconos = new ArrayList<ImageIcon>();
	
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
		
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(saldo<=1) {
					JOptionPane.showMessageDialog(null, "No tienes saldo", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					saldo -= 2;
					lblSaldo.setText("Saldo: " + saldo);
				}
			}
		});
		
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
		
		//rellenamos arraylist de iconos 
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
		
		//creamos panel tragaperras
		JPanel panelTragap = new JPanel();
		panelTragap.setBorder(bevel);
		panelTragap.setBounds(100, 100, 690, 240);
		panelTragap.setBackground(Color.lightGray);
		
		JPanel panelTragap1 = new JPanel();
		panelTragap1.setBorder(new BevelBorder(BevelBorder.LOWERED));
		
		JPanel panelTragap2 = new JPanel();
		panelTragap2.setBorder(new BevelBorder(BevelBorder.LOWERED));
		
		JPanel panelTragap3 = new JPanel();
		panelTragap3.setBorder(new BevelBorder(BevelBorder.LOWERED));
		
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
		getContentPane().add(panelTragap);
		
		//Hacemos los tres carretes a partir del array de iconos
		//CARRETE 1
		c11 = new Icono();
		c11.setX(115);
		c12 = new Icono();
		c12.setX(115);
		c12.setY(c11.getY()-210);
		
		//CARRETE 2
		c21 = new Icono();
		c21.setX(340);
		c22 = new Icono();
		c22.setX(340);
		c22.setY(c21.getY()-210);
		
		//CARRETE 2
		c31 = new Icono();
		c31.setX(565);
		c32 = new Icono();
		c32.setX(565);
		c32.setY(c31.getY()-210);
		
		
	}
	
}
