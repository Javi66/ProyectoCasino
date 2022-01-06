package ventana;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import clases.Ranking;

import database.Db;
import java.awt.BorderLayout;
public class VentanaRanking extends JFrame{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JTable table;
private ArrayList<Ranking> rankings;
private DefaultTableModel mDatos;
private JButton tragaperras;
private JButton ruleta;
private JButton Todo;

	public  VentanaRanking() {
		JPanel panelCentral= new JPanel();
		getContentPane().add(panelCentral);
		JPanel panelbotones = new JPanel();
		JButton tragaperras = new JButton("Tragaperras");
	   
		JButton ruleta= new JButton("Ruletas");
		JButton todo = new JButton("Todo");
		panelbotones.add(tragaperras);
		panelbotones.add(ruleta);
		panelbotones.add(todo);
		table=new JTable();
		table.setFont( new Font( "Arial", Font.PLAIN, 14 ) );
		getContentPane().add( new JScrollPane(table), BorderLayout.CENTER );
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
				mostrarRankings();  // Según se inicia la ventana se visualizan los productos
			}
				
			
			public void windowClosed(WindowEvent e) {
				Db.closeBD();
			}}
		);
			tragaperras.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					mostrarRankingsTragaperras();
					
				}
				
			});
			ruleta.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					mostrarRankingsruletas();
					
				}
				
			});;
			todo.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					mostrarRankings();
					
				}
				
			});
}
	public static void main (String[] args) {
	
		Ranking r1= new Ranking("Tragaperras","nombreusuario",1,1);
		VentanaRanking ventanaRanking = new VentanaRanking();
		ventanaRanking.setTitle("Ventana Ranking");
		ventanaRanking.setSize(1000, 500);
		ventanaRanking.setVisible(true);
		System.out.println(ventanaRanking);
	}
 private void mostrarRankings() {
	 final long serialVersionUID = 1L;
	 Vector<String> cabeceras = new Vector<String>( Arrays.asList( "nomjuego","nombreusuario","numpartida","Puntaje" ) );
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
	 
	 rankings = Db.getRankings() ;
	 for (Ranking r : rankings) {
			mDatos.addRow( new Object[] { r.getNomjuego(),r.getNombreusuario(),r.getNumpartida(),r.getPuntaje()} );
		}
	 table.setModel(mDatos);
	 table.getColumnModel().getColumn(0).setMinWidth(140);
		table.getColumnModel().getColumn(0).setMaxWidth(140);
		table.getColumnModel().getColumn(1).setMinWidth(160);
		table.getColumnModel().getColumn(1).setMaxWidth(160);
		table.getColumnModel().getColumn(2).setMinWidth(160);
		table.getColumnModel().getColumn(2).setMaxWidth(160);		
		table.getColumnModel().getColumn(3).setMinWidth(140);
		table.getColumnModel().getColumn(3).setMaxWidth(140);
		
		
		}
 private void mostrarRankingsTragaperras() {
	 final long serialVersionUID = 1L;
	 Vector<String> cabeceras = new Vector<String>( Arrays.asList( "nomjuego","nombreusuario","numpartida","Puntaje" ) );
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
	 
	 rankings = Db.getRankingstragaperras() ;
	 for (Ranking r : rankings) {
			mDatos.addRow( new Object[] { r.getNomjuego(),r.getNombreusuario(),r.getNumpartida(),r.getPuntaje()} );
		}
	 table.setModel(mDatos);
	 table.getColumnModel().getColumn(0).setMinWidth(140);
		table.getColumnModel().getColumn(0).setMaxWidth(140);
		table.getColumnModel().getColumn(1).setMinWidth(160);
		table.getColumnModel().getColumn(1).setMaxWidth(160);
		table.getColumnModel().getColumn(2).setMinWidth(160);
		table.getColumnModel().getColumn(2).setMaxWidth(160);		
		table.getColumnModel().getColumn(3).setMinWidth(140);
		table.getColumnModel().getColumn(3).setMaxWidth(140);
		
		
		}
 private void mostrarRankingsruletas() {
	 final long serialVersionUID = 1L;
	 Vector<String> cabeceras = new Vector<String>( Arrays.asList( "nomjuego","nombreusuario","numpartida","Puntaje" ) );
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
	 
	 rankings = Db.getRankingsruleta() ;
	 for (Ranking r : rankings) {
			mDatos.addRow( new Object[] { r.getNomjuego(),r.getNombreusuario(),r.getNumpartida(),r.getPuntaje()} );
		}
	 table.setModel(mDatos);
	 table.getColumnModel().getColumn(0).setMinWidth(140);
		table.getColumnModel().getColumn(0).setMaxWidth(140);
		table.getColumnModel().getColumn(1).setMinWidth(160);
		table.getColumnModel().getColumn(1).setMaxWidth(160);
		table.getColumnModel().getColumn(2).setMinWidth(160);
		table.getColumnModel().getColumn(2).setMaxWidth(160);		
		table.getColumnModel().getColumn(3).setMinWidth(140);
		table.getColumnModel().getColumn(3).setMaxWidth(140);
		
		
		}}
