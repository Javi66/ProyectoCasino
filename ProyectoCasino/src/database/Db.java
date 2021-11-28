package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

import clases.Usuario;


public class Db {
	private static Connection con = null;

	public static Connection initBD(String nombreBD) {
		
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:"+nombreBD);
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void closeBD(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static Statement usarCrearTablasBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			try {
				statement.executeUpdate("create table usuario " +
					"(dni string" +                    
					", nom string" +           
					", nomUsuario string, contrasenia string" +  
					")");
			} catch (SQLException e) {} // Tabla ya existe. Nada que hacer
			
			return statement;
		} catch (SQLException e) {
			return null;
		}
	}
	public static Statement reiniciarBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			statement.executeUpdate("drop table if exists usuario");
			return usarCrearTablasBD( con );
		} catch (SQLException e) {
			return null;
		}
	}
	public static void anadirUsuario(Connection con, String dni, String nom, String nomUsuario, String contrasenia) {
		String sentSQL = "INSERT INTO usuario VALUES('"+dni+"','"+nom+"','"+nomUsuario+"','"+contrasenia+"')";
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sentSQL);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public void registrarCliente(Usuario usuario) throws SQLException{
		
		
		try (PreparedStatement stmt = con.prepareStatement("INSERT INTO usuario (dni, nom, nomUsuario, contrasenia) VALUES (?, ?, ?, ?)");
			Statement stmtForId = con.createStatement()) {
			stmt.setString(1,usuario.getDni());
			stmt.setString(2, usuario.getNombre());
			stmt.setString(3,usuario.getNomUsuario());
			stmt.setString(4,usuario.getContrasenia());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("No se pudo guardar el usuario en la BD");
		}
	}
	
	public static void borrarUsuario(Connection con, String nomUsuario, String contrasenia) {
		String sentSQL = "DELETE FROM usuario WHERE nomUsuario ='"+nomUsuario+"' AND contrasenia = '"+contrasenia+"'";
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sentSQL);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static TreeMap<String, Usuario> obtenerMapaUsuario(Connection con){
		TreeMap<String, Usuario> tmUsuarios = new TreeMap<>();
		
		String sentSQL = "SELECT * FROM usuario";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sentSQL);
			while(rs.next()) { 
				String dni = rs.getString("dni");
				String nom = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				int edad = rs.getInt("edad");
				String gmail = rs.getString("gmail");
				int numUsuario = rs.getInt("numUsuario");
				String nomUsuario = rs.getString("nomUsuario");
				String contrasenia = rs.getString("contrasenia");
				int numerotarjeta = rs.getInt("numerotarjeta");
				Usuario u = new Usuario(dni,nom,apellido, edad, gmail, numUsuario, nomUsuario, contrasenia, numerotarjeta);
				tmUsuarios.put(nomUsuario, u);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tmUsuarios;
	}
	

	
}



