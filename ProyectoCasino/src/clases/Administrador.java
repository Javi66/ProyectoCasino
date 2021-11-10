package clases;

public class Administrador {

	private String nombre;
	private String apellido;
	private String dni;
	private String contrasenia;
	private String gmail;
	
	
	
	public Administrador() {
		super();
	}


	public Administrador(String nombre, String apellido, String dni, String contrasenia, String gmail) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.contrasenia = contrasenia;
		this.gmail = gmail;
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


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	public String getGmail() {
		return gmail;
	}


	public void setGmail(String gmail) {
		this.gmail = gmail;
	}


	@Override
	public String toString() {
		return "Administrador [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", contrasenia="
				+ contrasenia + ", gmail=" + gmail + "]";
	}
	
	
	
}
