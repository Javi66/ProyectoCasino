package clases;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class GestorUsuario {

	private static HashMap<String, Usuario> usuarios;

	public GestorUsuario() {
		
		usuarios = new HashMap<>();

	}


	public void anadirUsuario(Usuario u) {
		usuarios.put(u.getKey(), u.getValue());
	}

	

	public void borrarUsuario(Usuario u) {
		usuarios.remove(u.getKey());
	}

	

	public Usuario buscarUsuario(String dni) {
		return usuarios.get(dni);
	}

	

	public static HashMap<String, Usuario> obtenerUsuarios() {
		return usuarios;
	}


	public static ArrayList<Usuario> obtenerUsuariosOrdenados() {
		TreeSet<Usuario> conjuntoOrdenadoDeUsuarios = new TreeSet<>();
		for (Usuario u : usuarios.values()) {
			conjuntoOrdenadoDeUsuarios.add(u);
		}
		return new ArrayList<Usuario>(conjuntoOrdenadoDeUsuarios);
	}
	public static int obtenerNumeroDeSocio(int dni) {
		return 0;
	}

	public static HashMap<String, Usuario> getUsuarios() {
		return usuarios;
	}

	public static void setUsuarios(HashMap<String, Usuario> usuarios) {
		GestorUsuario.usuarios = usuarios;
	}

}