package clases;


public class Ruleta extends Juego {

	private int casillas;
	private String color;
	private String parImpar;
	
	

	public Ruleta() {
		super();
	}

	public Ruleta(int casillas, String color, String parImpar) {
		super();
		this.casillas = casillas;
		this.color = color;
		this.parImpar = parImpar;
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

	public String getParImpar() {
		return parImpar;
	}

	public void setParImpar(String parImpar) {
		this.parImpar = parImpar;
	}

	@Override
	public String toString() {
		return "Ruleta [casillas=" + casillas + ", color=" + color + ", parImpar=" + parImpar +", getGiros()=" + getGiros() + ", getDineroapostado()="
				+ getDineroapostado() + ", getUsuario()=" + getUsuario() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	
}
