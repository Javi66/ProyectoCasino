package database;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import clases.Usuario;



public class Db {
	private static Connection con = null;
	private static Logger logger = Logger.getLogger( "BaseDatos" );
	private static Handler handler ;
	
	public static void prepararLogger() {
		try {
			handler = new FileHandler("BaseDatos.xml");
			handler.setFormatter(new SimpleFormatter());
			logger.addHandler(handler);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static Connection initDB(String nombreBD, boolean primeraVez) {
		
		try {
			Class.forName("org.sqlite.JDBC");
			logger.log( Level.INFO, "Abriendo conexion con " + nombreBD );
			con = DriverManager.getConnection("jdbc:sqlite:"+nombreBD);
			
			if(primeraVez) {
				Statement stmt = con.createStatement();
				String sentSQL = "DROP TABLE IF EXISTS usuario";
				logger.log( Level.INFO, "Statement: " + sentSQL );
				stmt.executeUpdate( sentSQL );
			}
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log( Level.SEVERE, "Excepción", e );
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void closeBD(Connection con) {
		if(con!=null) {
			try {
				logger.log( Level.INFO, "Cerrando conexion" );
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.log( Level.SEVERE, "Excepción", e );
				e.printStackTrace();
			}
		}
	}
public static void crearTablaCliente(String nombreBD) {
	con = initDB(nombreBD, false);
		try(Statement stmt = con.createStatement()){
			stmt.executeUpdate("CREATE TABLE usuario ( dni varchar(9) PRIMARY KEY, nombre varchar(55), apellido varchar(55), edad int(2), gmail varchar(55), numUsuario int(3), nomUsuario varchar(55), pass varchar(55), numerotargeta int(16));");
			logger.log( Level.INFO, "Statement: " + stmt );
			System.out.println("Valores introducidos correctamente");
			
		}
		catch(SQLException e) {
			logger.log( Level.SEVERE, "No se ha podido ejecutar la sentencia" );
		}
		
	}
	
	public static void anadirUsuario(Connection con, Usuario u) {
		String sentSQL = "INSERT INTO usuario VALUES('"+u.getDni()+"','"+u.getNombre()+"','"+u.getApellido()+"','"+u.getEdad()+"','"+u.getGmail()+"','"+u.getNumUsuario()+"','"+u.getNomUsuario()+"','"+u.getContrasenia()+"','"+u.getNumerotargeta()+"')";
		
		try {
			
			Statement stmt = con.createStatement();
			logger.log( Level.INFO, "Statement: " + sentSQL );
			stmt.executeUpdate(sentSQL);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log( Level.SEVERE, "Excepción", e );
			e.printStackTrace();
		}
	}

	
	public static void borrarUsuario(Connection con, String nomUsuario, String contrasenia) {
		String sentSQL = "DELETE FROM usuario WHERE nomUsuario ='"+nomUsuario+"' AND contrasenia = '"+contrasenia+"'";
		try {
			Statement stmt = con.createStatement();
			logger.log( Level.INFO, "Statement: " + sentSQL );
			stmt.executeUpdate(sentSQL);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log( Level.SEVERE, "Excepción", e );
			e.printStackTrace();
		}
	}
	public static void modificarUsuario(String dni, String nom,String nomUsuario,String contrasenia) throws SQLException {
		Statement statement = con.createStatement();
		String sent = "update usuario set nombre='"+nom+"',nomUsuario="+nomUsuario+"',contrasenia="+contrasenia+" where dni="+dni;
		logger.log( Level.INFO, "Statement: " + sent );
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
				logger.log( Level.INFO, "Statement: " + sentSQL );
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log( Level.SEVERE, "Excepción", e );
			e.printStackTrace();
		}
		
		return tmUsuarios;
	}
	

	
}



