package ventana;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VentanaGestiondePagos extends JFrame{

	private void publicVentanaGestiondePagos() {
		JPanel panelCentral= new JPanel();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 200, 975, 650);
		setSize(320,300);
		setTitle( "Gestion de Pagos" );
		//Array bidimensional con los datos de la tabla
		Object[][] data = { 
				
		};
		//Array String con los nombres de columna
		String[] columnas= {"Usuario","NumCuenta","Pagos","Saldo"};
	final JTable table= new JTable(data,columnas);
	table.setPreferredScrollableViewportSize(new Dimension(500, 80));
	JScrollPane scrollpane = new JScrollPane(table);
	
	panelCentral.add(table);
	getContentPane().add(panelCentral
			);
	

}
	public static void main (String[] args) {
		VentanaGestiondePagos ventanaGestiondePagos = new VentanaGestiondePagos();
		ventanaGestiondePagos.setVisible(true);
		System.out.println(ventanaGestiondePagos);
	}

}
