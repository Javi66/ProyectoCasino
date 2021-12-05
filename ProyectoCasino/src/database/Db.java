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
public void crearTablaCliente() {
		
		try(Statement stmt = con.createStatement()){
			stmt.executeQuery("CREATE TABLE usuario ( dni varchar(9), nombre varchar(55), nomUsuario varchar(55), pass varchar(55));");
			System.out.println("Valores introducidos correctamente");
			
		}
		catch(SQLException e) {
			System.out.println("No se ha podido ejecutar la sentencia");
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
	public static void modificarUsuario(String dni, String nom,String nomUsuario,String pass) throws SQLException {
		Statement statement = con.createStatement();
		String sent = "update usuario set nombre='"+nom+"',nomUsuario="+nomUsuario+"',pass="+pass+" where dni="+dni;
		statement.executeUpdate(sent);
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



