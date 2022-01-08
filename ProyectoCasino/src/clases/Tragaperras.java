package clases;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Tragaperras extends Juego {
	
	public static ArrayList<ImageIcon> arrayIconos() {
		ArrayList<ImageIcon> iconos = new ArrayList<ImageIcon>();
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
		
		return iconos;
	}
	
	public static void score(int puntos, int a, int b, int c) {
		puntos = 100;
	}
	
}
