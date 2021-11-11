package clases;


public class Ruleta extends Juego {

	private int casillas;
	
	

	public Ruleta() {
		super();
	}

	public Ruleta(int casillas) {
		super();
		this.casillas = casillas;
	}

	public int getCasillas() {
		return casillas;
	}

	public void setCasillas(int casillas) {
		this.casillas = casillas;
	}

	@Override
	public String toString() {
		return "Ruleta [casillas=" + casillas + ", getGiros()=" + getGiros() + ", getDineroapostado()="
				+ getDineroapostado() + ", getUsuario()=" + getUsuario() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	
}
