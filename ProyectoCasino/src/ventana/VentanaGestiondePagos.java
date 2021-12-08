package ventana;

import java.awt.Container;
import javax.swing.*;
import java.awt.Dimension;
import java.lang.invoke.LambdaConversionException;
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

public class VentanaGestiondePagos extends JFrame{
private JTable table;
private ArrayList<Usuario> usuarios;
	public  VentanaGestiondePagos() {
		JPanel panelCentral= new JPanel();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 200, 975, 650);
		setSize(320,300);
		setTitle( "Gestion de Pagos" );
		JTable table = new JTable();
		TreeMap<String, Usuario>usuarios = Db.obtenerMapaUsuario(null);
		//Array String con los nombres de columna
		
		Vector<String> columnas = new Vector<String>( Arrays.asList( "Usuario", "NumCuenta", "Pagos","Saldo" ) );
		DefaultTableModel model = new DefaultTableModel(  new Vector<Vector<Object>>(), columnas );
		for(Usuario u:usuarios) {
		model.addRow(new Object[] {"wqw","","",""});
		table.setModel(model);}
	JScrollPane scrollpane = new JScrollPane(table);
	
	

	getContentPane().add(table )
			;
	

}
	public static void main (String[] args) {
		VentanaGestiondePagos ventanaGestiondePagos = new VentanaGestiondePagos();
		ventanaGestiondePagos.setVisible(true);
		System.out.println(ventanaGestiondePagos);
	}

}
