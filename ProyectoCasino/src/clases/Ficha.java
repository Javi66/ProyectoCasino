package clases;

public class Ficha {
	
	private int ValorEuros;
	private int ValorFicha;
	
	public Ficha() {
		super();
	}
	
	public Ficha(int ValorEuros, int ValorFicha) {
		super();
		this.ValorEuros = ValorEuros;
		this.ValorFicha = ValorFicha;
	}

	public int getValorFicha() {
		return ValorFicha;
	}

	public void setValorFicha(int valorFicha) {
		ValorFicha = valorFicha;
	}

	public int getValorEuros() {
		return ValorEuros;
	}

	public void setValor(int valorEuros) {
		ValorEuros = valorEuros;
	}

	@Override
	public String toString() {
		return "Ficha [ValorEuros=" + ValorEuros + ", ValorFicha=" + ValorFicha + "]";
	}

}
