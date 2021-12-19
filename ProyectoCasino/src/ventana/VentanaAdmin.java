package ventana;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import clases.Usuario;
import database.Db;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class VentanaAdmin extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private JButton btnImprimirUsuarios;
//	private JTextField txtusuarios; 
	private DefaultTableModel mDatos;
	private JTable table;
	private ArrayList<Usuario> usuarios;
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
		table = new JTable();
		table.setFont( new Font( "Arial", Font.PLAIN, 14 ) );
		JPanel pBotonera = new JPanel();
		getContentPane().add( new JScrollPane(table), BorderLayout.CENTER );
		getContentPane().add( pBotonera, BorderLayout.SOUTH );
		addWindowListener( new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				if (new File("casino1.db").exists()) {
					// Poner el parámetro a true si se quiere reiniciar la base de datos
					try {
						Db.initDB( "casino1.db", false );
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  // Abrir base de datos existente
				} else {
					try {
						Db.initDB( "casino1.db", true );
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  // Crear base de datos con datos iniciales
				}
				verUsuarios();  // Según se inicia la ventana se visualizan los productos
			}
			@Override
			public void windowClosed(WindowEvent e) {
				Db.closeBD();
			}
		});
	
		JButton b = new JButton( "Usuarios" );
		b.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
		pBotonera.add( b );
		b.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				verUsuarios();
			}
		});
		
		
//		btnImprimirUsuarios = new JButton("Imprimir Usuarios");
//		btnImprimirUsuarios.setForeground(Color.BLACK);
//		btnImprimirUsuarios.setFont(new Font("Tahoma", Font.BOLD, 12));
//		txtusuarios = new JTextField();
//		txtusuarios.setBounds(162, 91, 147, 37);
//		panel.add(txtusuarios);
//		txtusuarios.setColumns(10);
//		btnImprimirUsuarios.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				Thread t = new Thread() {
//					@Override
//					public void run() {
//						for (Usuario usuario : GestorUsuario.obtenerUsuariosOrdenados()) {
//							System.out.println(usuario);
//							txtusuarios.setText("Usuarios:"+" "+usuario);
//							try {
//								Thread.sleep(2000);
//							} catch (Exception e) {
//								e.printStackTrace();
//							}
//						}
//					}
//				};
//				
//				t.start();
//			}
//		});
//	
//		btnImprimirUsuarios.setBounds(162, 67, 147, 23);
//		panel.add(btnImprimirUsuarios);
//		
	}
	
	@SuppressWarnings("serial")
	private void verUsuarios() {
		Vector<String> cabeceras = new Vector<String>( Arrays.asList( "Dni", "Nombre","Apellido","Edad","Gmail", "Nombre usuario","Contrasenia","Tarjeta" ) );
		mDatos = new DefaultTableModel(  // Inicializa el modelo
			new Vector<Vector<Object>>(),  // Datos de la jtable (vector de vectores) - vacíos de momento
			cabeceras  // Cabeceras de la jtable
				) {
			
			public boolean isCellEditable(int row, int column) {
				if(column==0)
					return false;
				return true;
			}
		};
		
		usuarios = Db.getUsuarios();
		for (Usuario u : usuarios) {
			mDatos.addRow( new Object[] { u.getDni(), u.getNombre(),u.getApellido(),u.getEdad(),u.getGmail(), u.getNomUsuario(), u.getContrasenia(), u.getNumerotarjeta() } );
		}
		table.setModel( mDatos );
		// Pone tamaños a las columnas de la tabla
		table.getColumnModel().getColumn(0).setMinWidth(40);
		table.getColumnModel().getColumn(0).setMaxWidth(40);
		table.getColumnModel().getColumn(1).setMinWidth(60);
		table.getColumnModel().getColumn(1).setMaxWidth(60);
		table.getColumnModel().getColumn(2).setMinWidth(60);
		table.getColumnModel().getColumn(2).setMaxWidth(60);		
		table.getColumnModel().getColumn(3).setMinWidth(40);
		table.getColumnModel().getColumn(3).setMaxWidth(40);
		table.getColumnModel().getColumn(4).setMinWidth(80);
		table.getColumnModel().getColumn(4).setMaxWidth(80);		
		table.getColumnModel().getColumn(5).setMinWidth(80);
		table.getColumnModel().getColumn(5).setMaxWidth(80);
		table.getColumnModel().getColumn(6).setMinWidth(60);
		table.getColumnModel().getColumn(6).setMaxWidth(60);		
		table.getColumnModel().getColumn(7).setMinWidth(80);
		table.getColumnModel().getColumn(7).setMaxWidth(80);
		
//		table.getModel().addTableModelListener(new TableModelListener() {
//			
//			public void tableChanged(TableModelEvent e) {
//				// TODO Auto-generated method stub
//				int fil = e.getFirstRow();
//				String dni = (String) mDatos.getValueAt(fil, 1);
//				String nom = (String) mDatos.getValueAt(fil, 2);
//				String ape = (String) mDatos.getValueAt(fil, 3);
//				int edad = (int) mDatos.getValueAt(fil, 4);
//				String gmail = (String) mDatos.getValueAt(fil, 5);
//				String nomus = (String) mDatos.getValueAt(fil, 6);
//				String con = (String) mDatos.getValueAt(fil, 7);
//				int tarjeta = (int) mDatos.getValueAt(fil, 8);
//				
//				try {
//					Db.modificarUsuario(dni, nom, ape,edad,gmail,nomus,con,tarjeta);
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		});
	}
	
	
	
}
