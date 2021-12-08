package clases;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

	public static HashMap<String, Usuario> getUsuarios() {
		return usuarios;
	}

	public static void setUsuarios(HashMap<String, Usuario> usuarios) {
		GestorUsuario.usuarios = usuarios;
	}

	public HashMap<String, Usuario> leerFicheroUsuarios(String nomFic) {
		HashMap<String, Usuario> ret = new HashMap<>();
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(nomFic));
			while (true) {
				Usuario u = (Usuario) ois.readObject();
				// ret.add( u );
				ret.put(u.getKey(), u.getValue());
			}
		} catch (EOFException e) {
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ois != null)
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return ret;
	}

	public void escribirFicheroUsuarios(String nomFic, HashMap<String, Usuario> l) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(nomFic));

			for (Usuario u : l.values()) {
				oos.writeObject(u);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (oos != null)
				try {
					oos.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
		}
	}


	public void escribirFicheroUsuarios() {
		escribirFicheroUsuarios("usuarios.txt", obtenerUsuarios());
	}

	public void leerFicheroUsuarios() {
		usuarios = leerFicheroUsuarios("usuarios.txt");
	}

}
