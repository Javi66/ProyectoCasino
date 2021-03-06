package ventana;

import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class VentanaAdmin extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel mDatos;
	private JTable table;
	private ArrayList<Usuario> usuarios;
	public static void main(String[] args) {
		VentanaAdmin va = new VentanaAdmin("admin");
		va.setVisible(true);
		
		}
	
	public VentanaAdmin(String admin) {
		
		getContentPane().setBackground(Color.BLACK);
		setTitle("Ventana Admin");
		setSize(1300, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
					// Poner el parÃ¡metro a true si se quiere reiniciar la base de datos
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
				verUsuarios();  // SegÃºn se inicia la ventana se visualizan los productos
			}
			@Override
			public void windowClosed(WindowEvent e) {
				Db.closeBD();
			}
		});
		JButton salir = new JButton("Salir");
		salir.setFont(new Font( "Arial", Font.PLAIN, 12));
		
		salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Main vl = new Main(admin);
				vl.setVisible(true);
				Main.activarBotones();
			}
		});
		
		
		
		JButton borrar = new JButton( "Borrar" );
		borrar.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
		pBotonera.add( borrar );
		borrar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int fil = table.getSelectedRow();
				if(fil!=-1) {
					String dni = mDatos.getValueAt(fil, 0).toString();
					try {
						Db.eliminarUsuario(dni);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					verUsuarios();
				}
			}
		});
		
		
		this.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		    	table.getModel().addTableModelListener(new TableModelListener() {
					
					public void tableChanged(TableModelEvent e) {
						for( int i = 0; i<table.getRowCount(); i++) {
							String dni = (String) mDatos.getValueAt(i, 0).toString();
							String nom = (String) mDatos.getValueAt(i, 1).toString();
							String ape = (String) mDatos.getValueAt(i, 2).toString();
							int edad = Integer.parseInt(mDatos.getValueAt(i, 3).toString());
							String gmail = (String) mDatos.getValueAt(i, 4).toString();
							String nomus = (String) mDatos.getValueAt(i, 5).toString();
							String con = (String) mDatos.getValueAt(i, 6).toString();
							int tarjeta = Integer.parseInt(mDatos.getValueAt(i, 7).toString());
							
							try {
								Db.modificarUsuario(dni, nom, ape,edad,gmail,nomus,con,tarjeta);
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
					}
				});
		    }
		});
		
		JButton baniadir = new JButton("AÃ±adir");
		baniadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dni =  JOptionPane.showInputDialog("Introduce el dni: ");
				String nom =  JOptionPane.showInputDialog("Introduce el nombre: ");
				String apellido =  JOptionPane.showInputDialog("Introduce el apellido: ");
				int edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce la edad: "));
				String gmail = JOptionPane.showInputDialog("Introduce el gmail: ");
				String nomUsuario = JOptionPane.showInputDialog("Introduce el nombre de usuario: ");
				String contrasenia = JOptionPane.showInputDialog("Introduce la contrasenia: ");
				int numerotarjeta = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de tarjeta: "));
				Usuario u = new Usuario(dni, nom, apellido, edad, gmail, nomUsuario, contrasenia, numerotarjeta);
				usuarios.add(u);
				Db.anadirUsuario(u);
				verUsuarios();
			}
		});
		baniadir.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
		pBotonera.add(baniadir);
		pBotonera.add( salir );
		
				
	}
	
	@SuppressWarnings("serial")
	private void verUsuarios() {
		Vector<String> cabeceras = new Vector<String>( Arrays.asList( "Dni", "Nombre","Apellido","Edad","Gmail", "Nombre usuario","Contrasenia","Tarjeta" ) );
		mDatos = new DefaultTableModel(  // Inicializa el modelo
			new Vector<Vector<Object>>(),  // Datos de la jtable (vector de vectores) - vacÃ­os de momento
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
		// Pone tamaÃ±os a las columnas de la tabla
		table.getColumnModel().getColumn(0).setMinWidth(140);
		table.getColumnModel().getColumn(0).setMaxWidth(140);
		table.getColumnModel().getColumn(1).setMinWidth(160);
		table.getColumnModel().getColumn(1).setMaxWidth(160);
		table.getColumnModel().getColumn(2).setMinWidth(160);
		table.getColumnModel().getColumn(2).setMaxWidth(160);		
		table.getColumnModel().getColumn(3).setMinWidth(140);
		table.getColumnModel().getColumn(3).setMaxWidth(140);
		table.getColumnModel().getColumn(4).setMinWidth(180);
		table.getColumnModel().getColumn(4).setMaxWidth(180);		
		table.getColumnModel().getColumn(5).setMinWidth(180);
		table.getColumnModel().getColumn(5).setMaxWidth(180);
		table.getColumnModel().getColumn(6).setMinWidth(160);
		table.getColumnModel().getColumn(6).setMaxWidth(160);		
		table.getColumnModel().getColumn(7).setMinWidth(180);
		table.getColumnModel().getColumn(7).setMaxWidth(180);
		
		
	}

	//MÃƒÂ©ï¸�todo que recorre la informaciÃƒÂ³n de los usuarios de forma recursiva y los escribe en un fichero de texto
		@SuppressWarnings("unused")
		private void escribirUsuariosEnFichero(int fila, DefaultTableModel mDatos, PrintWriter pw) {
			if(fila<mDatos.getRowCount()) {
				String dni = (String) mDatos.getValueAt(fila, 0);
				String nom = (String)mDatos.getValueAt(fila, 1);
				int edad = (int)mDatos.getValueAt(fila, 3);
				pw.println(dni+" "+nom+" "+edad);
				escribirUsuariosEnFichero(fila+1, mDatos, pw);
			}
		
		}	
}
