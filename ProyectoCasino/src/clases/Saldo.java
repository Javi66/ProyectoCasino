package clases;

import java.util.ArrayList;

public class Saldo  extends Usuario{
	private Usuario usuario;
private Integer numCuenta;
private Integer Dinerodisponible;
private ArrayList<Pagos> pagos;
public Usuario getUsuario() {
	return usuario;
}
public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}
public Integer getNumCuenta() {
	return numCuenta;
}
public void setNumCuenta(Integer numCuenta) {
	this.numCuenta = numCuenta;
}
public Integer getDinerodisponible() {
	return Dinerodisponible;
}
public void setDinerodisponible(Integer dinerodisponible) {
	Dinerodisponible = dinerodisponible;
}
public ArrayList<Pagos> getPagos() {
	return pagos;
}
public void setPagos(ArrayList<Pagos> pagos) {
	this.pagos = pagos;
}
}
