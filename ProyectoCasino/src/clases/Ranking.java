package clases;

import java.io.Serializable;
import java.util.Map.Entry;
import java.util.Objects;

public class Ranking implements Serializable, Entry<String, Ranking>{
	private static final long serialVersionUID = 1L;
	private Tragaperras tragaperras ;
	private Ruleta ruleta;
	private  String nombreusuario;
	private String nomjuego;
	private int numpartida=0;
	private int puntaje=0;
	
	public Ranking() {
		super();
		
	}
	public Ranking(String nomjuego,String nombreusuario,int numpartida,int puntaje ) {
		super();
		this.nomjuego=nomjuego;
		this.nombreusuario=nombreusuario;
		this.numpartida=numpartida;
		this.puntaje=puntaje;
	}
	public Tragaperras getTragaperras() {
		return tragaperras;
	}
	public void setTragaperras(Tragaperras tragaperras) {
		this.tragaperras = tragaperras;
	}
	public Ruleta getRuleta() {
		return ruleta;
	}
	public void setRuleta(Ruleta ruleta) {
		this.ruleta = ruleta;
	}
	
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Ranking getValue() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Ranking setValue(Ranking value) {
		// TODO Auto-generated method stub
		return null;
	}
	public String getNomjuego() {
		return nomjuego;
	}
	public void setNomjuego(String nomjuego) {
		this.nomjuego = nomjuego;
	}
	@Override
	public String toString() {
		return "Ranking [tragaperras=" + tragaperras + ", ruleta=" + ruleta + ", usuario=" + nombreusuario + ", nomjuego="
				+ nomjuego + ", numpartida=" + numpartida + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(nomjuego, numpartida, ruleta, tragaperras, nombreusuario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ranking other = (Ranking) obj;
		return Objects.equals(nomjuego, other.nomjuego) && numpartida == other.numpartida
				&& Objects.equals(ruleta, other.ruleta) && Objects.equals(tragaperras, other.tragaperras)
				&& Objects.equals(nombreusuario, other.nombreusuario);
	}
	public int getNumpartida() {
		return numpartida;
	}
	public void setNumpartida(int numpartida) {
		this.numpartida = numpartida;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public String getNombreusuario() {
		return nombreusuario;
	}
	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}
	
	

}
