package clases;

public class Tragaperras extends Juego {

	private Fruta fruta;

	public Tragaperras() {
		super();
	}

	public Tragaperras(Fruta fruta) {
		super();
		this.fruta = fruta;
	}

	public Fruta getFruta() {
		return fruta;
	}

	public void setFruta(Fruta fruta) {
		this.fruta = fruta;
	}

	@Override
	public String toString() {
		return "Tragaperras [fruta=" + fruta + ", getGiros()=" + getGiros() + ", getDineroapostado()="
				+ getDineroapostado() + ", getUsuario()=" + getUsuario() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
	
}
