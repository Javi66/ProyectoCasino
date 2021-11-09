package clases;

public class Usuario implements Comparable<Usuario>{
	private String dni;
	private String nombre;
	private String apellido;
	private int edad;
	private String gmail;
	private String contrasenia;
	private int numerotargeta;
	
	
	public Usuario() {
		super();
	}
	
	public Usuario(String dni, String nombre, String apellido, int edad, String gmail, String contrasenia, int numerotargeta) {
		super(); 
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.gmail = gmail;
		this.contrasenia = contrasenia;
		this.numerotargeta = numerotargeta;
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
				+ gmail + ", contrasenia=" + contrasenia + ", numerotargeta=" + numerotargeta + "]";
	}

	@Override
	public int compareTo(Usuario o) {
		// TODO Auto-generated method stub
		return o.dni.compareTo(this.dni);
	}


}
