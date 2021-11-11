package clases;

import java.io.Serializable;
import java.util.Map.Entry;

public class Usuario implements Serializable, Comparable<Usuario>, Entry<String, Usuario>{
	
	private static final long serialVersionUID = 1L;
	private String dni;
	private String nombre;
	private String apellido;
	private int edad;
	private String gmail;
	private int numUsuario;
	private String nomUsuario;
	private String contrasenia;
	private int numerotargeta;
	
	
	public Usuario() {
		super();
	}
	
	public Usuario(String dni, String nombre, String apellido, int edad, String gmail, int numUsuario, String nomUsuario, String contrasenia, int numerotargeta) {
		super(); 
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.numUsuario = numUsuario;
		this.nomUsuario = nomUsuario;
		this.gmail = gmail;
		this.contrasenia = contrasenia;
		this.numerotargeta = numerotargeta;
	}

	public int getNumUsuario() {
		return numUsuario;
	}

	public void setNumUsuario(int numUsuario) {
		this.numUsuario = numUsuario;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getGmail() {
		return gmail;
	}


	public void setGmail(String gmail) {
		this.gmail = gmail;
	}


	public String getContrasenia() {
		return contrasenia;
	}



	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}



	public int getNumerotargeta() {
		return numerotargeta;
	}


	public void setNumerotargeta(int numerotargeta) {
		this.numerotargeta = numerotargeta;
	}

	

	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", gmail="
				+ gmail + ", numUsuario=" + numUsuario + ", nomUsuario=" + nomUsuario + ", contrasenia=" + contrasenia
				+ ", numerotargeta=" + numerotargeta + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		if (obj instanceof Usuario) {
			Usuario other = (Usuario) obj;
			if (dni == null) {
				if (other.dni != null)
					return false;
			} else if (!dni.equals(other.dni))
				return false;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	public int compareTo(Usuario elOtroUsuario) {

		return numUsuario - elOtroUsuario.numUsuario;
	}

	@Override
	public String getKey() {

		return dni;
	}

	@Override
	public Usuario getValue() {

		return this;
	}

	@Override
	public Usuario setValue(Usuario value) {
		
		//No usamos este método
		return null;
	}



}
