package clases;

import java.util.Random;

public class Ruleta extends Juego {

	private int numeros= 36;
	private String color;
	
	
	public Ruleta() {
		super();
	}

	public Ruleta(int numeros, String color) {
		super();
		this.numeros = numeros;
		this.color = color;
	}

	public int getCasillas() {
		return numeros;
	}

	public void setCasillas(int numeros) {
		this.numeros = numeros;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Ruleta [numeros=" + numeros + ", color=" + color + ", getCasillas()=" + getCasillas()
				+ ", getColor()=" + getColor() + ", getGiros()=" + getGiros() + ", getDineroapostado()="
				+ getDineroapostado() + ", getUsuario()=" + getUsuario() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	 public int giraRuleta (){
	        
	        int numero;
	        Random random = new Random();
	        //Calcular un numero aleatoria de la ruleta
	        numero = random.nextInt(numeros);
	        return numero;
	    }
	

}
