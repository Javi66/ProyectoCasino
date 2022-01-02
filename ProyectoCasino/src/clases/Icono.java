package clases;

import java.util.Random;

import ventana.VentanaTragaperras;

public class Icono {
	private int X;
	private int Y;
	private int icono;
	private boolean girando;
	
	public static int iconoRandom() {
		int iconoR = new Random().nextInt(VentanaTragaperras.iconos.size());
		return iconoR;
	}
	
	public Icono() {
		this.X = 550;
		this.Y = 50;
		this.icono = iconoRandom();
		this.girando = false;
	}
	
	public void girar(int cant) {
		if(girando==true) {
			if(Y+cant>550) {
				icono = iconoRandom();
				Y = Y+cant-600;
			} else {
				Y += cant;
			}
		}
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public int getIcono() {
		return icono;
	}

	public void setIcono(int icono) {
		this.icono = icono;
	}

	public boolean isGirando() {
		return girando;
	}

	public void setGirando(boolean girando) {
		this.girando = girando;
	}
	
	
}
