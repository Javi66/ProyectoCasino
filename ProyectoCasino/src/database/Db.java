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
	
	
	public static Connection initDB(String nombreBD, boolean primeraVez) throws SQLException {
		
		try {
			Class.forName("org.sqlite.JDBC");
			logger.log( Level.INFO, "Abriendo conexion con " + nombreBD );
			con = DriverManager.getConnection("jdbc:sqlite:data/"+ nombreBD );
			
			if(primeraVez) {  //Si queremos reiniciar la BD esto ser� true
				crearTablaCliente(nombreBD);
				logger.log(Level.INFO, "Creada nueva tabla clientes");
			}
			return con;		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log( Level.SEVERE, "Excepción", e );
			e.printStackTrace();
			return null;
		}
	}
	
	public static void closeBD() {
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
	
public static void crearTablaCliente(String nombreBD) throws SQLException{
		try{
			Statement stmt = con.createStatement();
			String sentSQL = "DROP TABLE IF EXISTS usuario;";  //La eliminamos si ya existe
			logger.log( Level.INFO, "Statement: " + sentSQL );
			stmt.execute( sentSQL );
			
			//Despu�s creamos la tabla nueva
			sentSQL = "CREATE TABLE usuario ( dni varchar(9) PRIMARY KEY, nombre varchar(55), apellido varchar(55), edad int, gmail varchar(55), nomUsuario varchar(55), contrasenia varchar(55), numerotarjeta int);";
			logger.log( Level.INFO, "Statement: " + sentSQL );
			stmt.execute(sentSQL);
			
			stmt.close();
			System.out.println("Valores introducidos correctamente");
		}
		catch(SQLException e) {
			logger.log( Level.SEVERE, "No se ha podido ejecutar la sentencia" );
		}
		
	}
	
	public static void anadirUsuario(Usuario u) {
		try (Statement stmt = con.createStatement()){
			String sentSQL = "INSERT INTO usuario VALUES('"+u.getDni()+"','"+u.getNombre()+"','"+u.getApellido()+"',"+u.getEdad()+",'"+u.getGmail()+"','"+u.getNomUsuario()+"','"+u.getContrasenia()+"',"+u.getNumerotarjeta()+")";
			logger.log( Level.INFO, "Statement: " + sentSQL );
			stmt.executeUpdate(sentSQL);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log( Level.SEVERE, "Excepción", e );
			e.printStackTrace();
		}
	}

	
	public static void borrarUsuario(String nomUsuario, String contrasenia) {
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
	public static void modificarUsuario(String dni, String nom,String apellido,Integer edad,String gmail,String nomUsuario,String contrasenia, Integer tarjeta) throws SQLException {
		Statement statement = con.createStatement();
		String sent = "update usuario set nombre='"+nom+"',apellido='"+apellido+"',edad='"+edad+"',gmail="+gmail+"',nomUsuario="+nomUsuario+"',contrasenia="+contrasenia+"',numerotarjeta='"+tarjeta+" where dni="+dni;
		logger.log( Level.INFO, "Statement: " + sent );
		statement.executeUpdate(sent);
	}
	
	
	public static TreeMap<String, Usuario> obtenerMapaUsuario(){
		try (Statement stmt = con.createStatement()){
			TreeMap<String, Usuario> tmUsuarios = new TreeMap<>();
			String sentSQL = "SELECT * FROM usuario;";
			logger.log( Level.INFO, "Statement: " + sentSQL );
			ResultSet rs = stmt.executeQuery(sentSQL);
			while(rs.next()) {  //repasa rs y a�ade todos los usuarios al treemap
				String dni = rs.getString("dni");
				String nom = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				int edad = rs.getInt("edad");
				String gmail = rs.getString("gmail");
				String nomUsuario = rs.getString("nomUsuario");
				String contrasenia = rs.getString("contrasenia");
				int numerotarjeta = rs.getInt("numerotarjeta");
				Usuario u = new Usuario(dni, nom, apellido, edad, gmail, nomUsuario, contrasenia, numerotarjeta);
				tmUsuarios.put(nomUsuario, u);
			}
			logger.log(Level.INFO, "TreeMap cargado");
			return tmUsuarios;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log( Level.SEVERE, "Excepción", e );
			e.printStackTrace();
			return null;
		}
		
	}
	public static ArrayList<Usuario> getUsuarios() {
		try (Statement statement = con.createStatement()) {
			ArrayList<Usuario> ret = new ArrayList<>();
			String sent = "select * from usuario;";
			logger.log( Level.INFO, "Statement: " + sent );
			ResultSet rs = statement.executeQuery( sent );
			while( rs.next() ) { // Leer el resultset
				String dni = rs.getString("dni");
				String nom = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				int edad = rs.getInt("edad");
				String gmail = rs.getString("gmail");
				String nomUsuario = rs.getString("nomUsuario");
				String contrasenia = rs.getString("contrasenia");
				int numerotarjeta = rs.getInt("numerotarjeta");
				Usuario u = new Usuario(dni, nom, apellido, edad, gmail, nomUsuario, contrasenia, numerotarjeta);
				ret.add(u);
			}
			return ret;
		} catch (Exception e) {
			logger.log( Level.SEVERE, "Excepción", e );
			return null;
		}
	}

	
}



