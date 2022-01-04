package ventana;

import java.awt.Container;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.lang.invoke.LambdaConversionException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clases.Usuario;
import database.Db;
import java.awt.BorderLayout;
public class VentanaRanking extends JFrame{
private JTable table;
private ArrayList<Usuario> usuarios;
private DefaultTableModel mDatos;

	public  VentanaRanking() {
		JPanel panelCentral= new JPanel();
		getContentPane().add(panelCentral);
		JPanel panelbotones = new JPanel();
		getContentPane().add(panelbotones,BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 200, 975, 650);
		setSize(320,300);
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
				MostrarUsuarios();  // Según se inicia la ventana se visualizan los productos
			}
				
			
			public void windowClosed(WindowEvent e) {
				Db.closeBD();
			}}
		);
			
		Object[] columnas ={"Usuario ", "Puntos "};
	    Object datos [][]= {{"Nombre 1","apellido"},{"dada","feef"}};
		
		JTable table = new JTable(datos,columnas);
	JScrollPane scrollpane = new JScrollPane(table);
	
	

	getContentPane().add(scrollpane )
			;
	

}
	public static void main (String[] args) {
		
		VentanaRanking ventanaRanking = new VentanaRanking();
		ventanaRanking.setVisible(true);
		System.out.println(ventanaRanking);
	}
 private void mostrarUsuarios() {
	 final long serialVersionUID = 1L;
	 Vector<String> cabeceras = new Vector<String>( Arrays.asList( "Usuario","Puntos" ) );
	 mDatos = new DefaultTableModel(  // Inicializa el modelo
				new Vector<Vector<Object>>(),  // Datos de la jtable (vector de vectores) - vacíos de momento
				cabeceras  // Cabeceras de la jtable
					) {
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column) {
						if(column==0)
							return false;
						return true;
 }
};
	 
	 usuarios = Db.getUsuarios() ;}}
