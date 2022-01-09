package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.*;

import clases.Usuario;
import database.Db;


import javax.swing.GroupLayout.Alignment;


public class VentanaRegistrar extends JFrame  {
	private static final long  serialVersionUID = 1L;
	private JPanel contentpane;
	private JTextField Dnijt;
	private JTextField Nombrejt;
	private JTextField Apellidojt;
	private JTextField Edadjt;
	private JTextField Gmailjt;
	private JTextField nomusuariojt;
	private JTextField contraseniajt;
	private JTextField numtarjetajt;
	private JButton btnGuardar;
	private JButton btnSalir;
	private JProgressBar progressBar;
	
	
	public VentanaRegistrar() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 975, 650);
		setResizable(false);
		
		contentpane = new JPanel();
		contentpane.setBackground(new Color(255, 255, 255));
	
		//Aniadir Jlabels y Jtextfields
		JLabel Dnijp = new JLabel("DNI:");
		Dnijp.setBounds(10, 10, 80, 25);
		JLabel Nombrejp= new JLabel("Nombre:");
		Nombrejp.setBounds(10, 50, 80, 25);
		JLabel Apellidojp = new JLabel("Apellido:");
		Apellidojp.setBounds(10, 90, 80, 25);
		JLabel Edadjp= new JLabel("Edad:");
		Edadjp.setBounds(10, 130, 80, 25);
		JLabel Gmailjp=new JLabel("Gmail:");
		Gmailjp.setBounds(10, 170, 80, 25);
		JLabel nomusuariojp=new JLabel("Usuario:");
		nomusuariojp.setBounds(10, 210, 80, 25);
		JLabel contraseniajp =new JLabel("Contraseña:");
		contraseniajp.setBounds(10, 250, 80, 25);
		JLabel numtarjetajp =new JLabel("Tarjeta:");
		numtarjetajp.setBounds(10, 290, 80, 25);
		Dnijt = new JTextField(50);
		Dnijt.setBounds(80, 10, 200, 25);
		Nombrejt= new JTextField(30);
		Nombrejt.setBounds(80, 50, 200, 25);
		Apellidojt = new JTextField(30);
		Apellidojt.setBounds(80, 90, 200, 25);
		Edadjt= new JTextField(30);
		Edadjt.setBounds(80, 130, 200, 25);
		Gmailjt=new JTextField(30);
		Gmailjt.setBounds(80, 170, 200, 25);
		nomusuariojt=new JTextField(30);
		nomusuariojt.setBounds(80, 210, 200, 25);
		contraseniajt =new JTextField(30);
		contraseniajt.setBounds(80, 250, 200, 25);
		numtarjetajt =new JTextField(30);
		numtarjetajt.setBounds(80, 290, 200, 25);
		
		
		//Aniadir Botones 
		JPanel panelbotones = new JPanel();
		panelbotones.setBounds(0, 0, 0, 0);
		
		
		btnGuardar= new JButton("GUARDAR");
		btnSalir= new JButton("SALIR");
		btnGuardar.setBounds(10, 337, 100, 25);
		btnSalir.setBounds(150, 337, 100, 25);
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String dni = Dnijt.getText();
				String nombre = Nombrejt.getText();
				String nombreus = nomusuariojt.getText();
				String contrasenia = contraseniajt.getText();
				String apellido = Apellidojt.getText();
				String gmail = Gmailjt.getText();
				int edad = Integer.parseInt(Edadjt.getText());
				int numerotarjeta = Integer.parseInt(numtarjetajt.getText());
				Usuario u = new Usuario(dni, nombre, apellido, edad, gmail, nombreus, contrasenia, numerotarjeta);
				try {
					Db.initDB("casino1.db", false);
					Db.anadirUsuario(u);
					Thread hilo = new Thread() {
						@Override
						public void run() {
							for (int i=1;i<100;i++) {
								progressBar.setValue(i);
								try {Thread.sleep( 50 ); } catch (Exception e) {}
							}

							JOptionPane.showMessageDialog(null, "Se ha registrado correctamente", "Registro finalizado.",JOptionPane.INFORMATION_MESSAGE);
							dispose();
							Db.closeBD();
							Main vl = new Main("");
							vl.setVisible(true);
						}
					};
					hilo.start();
					
								
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}); 
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main vl = new Main("");
				vl.setVisible(true);
			}
		});
		contentpane.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(10, 373, 146, 9);
		contentpane.add(progressBar);
		
		contentpane.add(Dnijp);
		contentpane.add(Dnijt);
		contentpane.add(Nombrejp);
		contentpane.add(Nombrejt);
		contentpane.add(Apellidojp);
		contentpane.add(Apellidojt);
		contentpane.add(Edadjp);
		contentpane.add(Edadjt);
		contentpane.add(Gmailjp);
		contentpane.add(Gmailjt);
		contentpane.add(nomusuariojp);
		contentpane.add(nomusuariojt);
		contentpane.add(contraseniajp);
		contentpane.add(contraseniajt);
		contentpane.add(numtarjetajp);
		contentpane.add(numtarjetajt);
		contentpane.add(panelbotones);
		contentpane.add(btnGuardar);
		contentpane.add(btnSalir);
		this.setSize(301, 436);
		
		setContentPane(contentpane);
		contentpane.setLayout(null);
		contentpane.add(progressBar);
		contentpane.add(Dnijp);
		contentpane.add(Dnijt);
		contentpane.add(Nombrejp);
		contentpane.add(Nombrejt);
		contentpane.add(Apellidojp);
		contentpane.add(Apellidojt);
		contentpane.add(Edadjp);
		contentpane.add(Edadjt);
		contentpane.add(Gmailjp);
		contentpane.add(Gmailjt);
		contentpane.add(nomusuariojp);
		contentpane.add(nomusuariojt);
		contentpane.add(contraseniajp);
		contentpane.add(contraseniajt);
		contentpane.add(numtarjetajp);
		contentpane.add(numtarjetajt);
		contentpane.add(panelbotones);
		contentpane.add(btnGuardar);
		contentpane.add(btnSalir);
		
		
	}
	public static void main (String[] args) {
		VentanaRegistrar v= new VentanaRegistrar();
		v.setVisible(true);

	}
}