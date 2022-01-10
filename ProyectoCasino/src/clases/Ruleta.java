package clases;

import java.util.Random;

public class Ruleta extends Juego {

	private int casillas= 37;
	private String color;
	
	
	public Ruleta() {
		super();
	}

	public Ruleta(int casillas, String color) {
		super();
		this.casillas = casillas;
		this.color = color;
	}

	public int getCasillas() {
		return casillas;
	}

	public void setCasillas(int casillas) {
		this.casillas = casillas;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Ruleta [casillas=" + casillas + ", color=" + color + ", getCasillas()=" + getCasillas()
				+ ", getColor()=" + getColor() + ", getGiros()=" + getGiros() + ", getDineroapostado()="
				+ getDineroapostado() + ", getUsuario()=" + getUsuario() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	 public int giraRuleta (){
	        
	        int posicion;
	        Random random = new Random();
	        //Calcular una posicion aleatoria de la ruleta
	        posicion = random.nextInt(casillas);
	        return posicion;
	    }
	

}
