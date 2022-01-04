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
		
		Object[] columnas ={"Nombre ", "Apellido"};
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

}
