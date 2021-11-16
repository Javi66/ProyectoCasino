package clases;

public class Ficha {
	
	private int Valor;
	
	public Ficha() {
		super();
	}
	
	public Ficha(int Valor) {
		super();
		this.Valor = Valor;
	}

	public int getValor() {
		return Valor;
	}

	public void setValor(int valor) {
		Valor = valor;
	}

	@Override
	public String toString() {
		return "Ficha [Valor=" + Valor + "]";
		
	}

}
