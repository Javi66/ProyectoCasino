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

import clases.Ranking;
import clases.Usuario;

public class BDranking {
	private static Connection con = null;
	private static Logger logger = Logger.getLogger( "BaseDatos" );
	private static Handler handler ;
	
	public static void prepararLogger() {
		try {
			handler = new FileHandler("BaseDatosRANKING.xml");
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
	public static Connection initDB(String nombreBD, boolean primeraVez) throws SQLException{
		try {
			Class.forName("org.sqlite.JDBC");
			logger.log( Level.INFO, "Abriendo conexion con " + nombreBD );
			con = DriverManager.getConnection("jdbc:sqlite:data/"+ nombreBD );
			
			if(primeraVez) {  //Si queremos reiniciar la BD esto ser� true
				crearTablaRanking(nombreBD);
				logger.log(Level.INFO, "Creada nueva tabla Ranking");
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
	public static void crearTablaRanking(String nombreBD) throws SQLException{
		try{
			Statement stmt = con.createStatement();
			String sentSQL = "DROP TABLE IF EXISTS ranking;";  //La eliminamos si ya existe
			logger.log( Level.INFO, "Statement: " + sentSQL );
			stmt.execute( sentSQL );
			
			//Despu�s creamos la tabla nueva
			sentSQL = "CREATE TABLE ranking ( numpartida int PRIMARY KEY,nomjuego varchar(50), nombreusuario varchar(55),puntaje int);";
			logger.log( Level.INFO, "Statement: " + sentSQL );
			stmt.execute(sentSQL);
			
			stmt.close();
			System.out.println("Valores introducidos correctamente");
		}
		catch(SQLException e) {
			logger.log( Level.SEVERE, "No se ha podido ejecutar la sentencia" );
		}
		
	}
	public static void anadirRanking(Ranking r) {
		try (Statement stmt = con.createStatement()){
			String sentSQL = "INSERT INTO ranking  VALUES('"+r.getNumpartida()+"','"+r.getNomjuego()+"','"+r.getNombreusuario()+"','"+r.getPuntaje()+")";
			logger.log( Level.INFO, "Statement: " + sentSQL );
			stmt.executeUpdate(sentSQL);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log( Level.SEVERE, "Excepción", e );
			e.printStackTrace();
		}
	}
	public static void borrarRanking(String Nombreusuario) {
		String sentSQL = "DELETE FROM ranking WHERE nombreusuario ='"+Nombreusuario+"'";
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
	public static void eliminarRanking(String numpartida) throws SQLException {
		Statement statement = con.createStatement();
		String sent = "delete from ranking where numpartida = '"+numpartida + "';";
		logger.log( Level.SEVERE, "Statement: " + sent );
		statement.executeUpdate(sent);
	}
	public static void modificarRanking(String nomjuego,String nombreusuario,int numpartida,int puntaje) throws SQLException {
		Statement statement = con.createStatement();
		String sent = "update ranking set nomjuego='"+nomjuego+"',nombreusuario='"+nombreusuario+"',numpartida='"+numpartida+"',puntaje="+puntaje+ "';";
		logger.log( Level.INFO, "Statement: " + sent );
		statement.executeUpdate(sent);
	}
	public static TreeMap<String, Ranking> obtenerMapaRanking(){
		try (Statement stmt = con.createStatement()){
			TreeMap<String, Ranking> tmRanking = new TreeMap<>();
			String sentSQL = "SELECT * FROM Ranking;";
			logger.log( Level.INFO, "Statement: " + sentSQL );
			ResultSet rs = stmt.executeQuery(sentSQL);
			while(rs.next()) {  //repasa rs y a�ade todos los usuarios al treemap
				String nomjuego = rs.getString("nomjuego");
				String nombreusuario = rs.getString("nombreusuario");
				int numpartida = rs.getInt("numpartida");
				int puntaje = rs.getInt("puntaje");
				Ranking r = new Ranking(nomjuego, nombreusuario, numpartida, puntaje);
				tmRanking.put(nomjuego, r);
			}
			logger.log(Level.INFO, "TreeMap cargado");
			return tmRanking;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log( Level.SEVERE, "Excepción", e );
			e.printStackTrace();
			return null;
		}
		
	}
	public static ArrayList<Ranking> getRankings() {
		try (Statement statement = con.createStatement()) {
			ArrayList<Ranking> ret = new ArrayList<>();
			String sent = "select * from ranking;";
			logger.log( Level.INFO, "Statement: " + sent );
			ResultSet rs = statement.executeQuery( sent );
			while( rs.next() ) { // Leer el resultset
				String nomjuego = rs.getString("nomjuego");
				String nombreusuario = rs.getString("nombreusuario");
				int numpartida = rs.getInt("numpartida");
				int puntaje = rs.getInt("puntaje");
				Ranking r = new Ranking(nomjuego, nombreusuario, numpartida, puntaje);
				
				
				ret.add(r);
			}
			return ret;
		} catch (Exception e) {
			logger.log( Level.SEVERE, "Excepción", e );
			return null;
		}
	}

	
}
