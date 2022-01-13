package clases;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import database.Db;

public class Tests {

	
	@Before
	public void setUp() throws Exception {
		 Db.initDB("Datos.db",true);
	}

	@After
	public void tearDown() throws Exception {
		Db.closeBD();
	}
	
	//Test de implementacion de un usuario
	@Test
	public void test1() {	
		Usuario u = new Usuario("786385023F", "A", "B", 18, "dfghjk","iug","uyg",2);
		u.setNombre("Javier");
		u.setApellido("Pombo");
		u.setEdad(19);
		assertEquals("Javier", u.getNombre());
		assertEquals("Pombo", u.getApellido());
		assertEquals(19, u.getEdad());
	}
	
	
	//Test del metodo contar usuarios en la db
	@Test
	public void test() {
		try {
			int contAntesDeInsertar = Db.contarUsuarios();
			Usuario u = new Usuario("786385023F", "A", "B", 18, "dfghjk","iug","uyg",2);
			Db.anadirUsuario(u);
			int contDespuesDeInsertar = Db.contarUsuarios();
			assertTrue(contAntesDeInsertar == contDespuesDeInsertar - 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//Test de la clase tragaperras y su score
	@Test
	public void tragapScoreTest() {
		int sietes = 1000;
		int diamantes = 850;
		int dosfrutas = 50;
		assertTrue(Tragaperras.score(0, 0, 0, true)==sietes);
		assertTrue(Tragaperras.score(4, 4, 4, true)==diamantes);
		assertTrue(Tragaperras.score(6, 6, 0, true)==dosfrutas);
	}
	
	
	/*Test del metodo de obtener partidas de la db (no va bien)
	*@Test (expected = SQLException.class)
	*public void borrarRankTestConExcepc() throws SQLException {
	*	String nomUsuario = "pepe";
	*	Db.eliminarRankings(nomUsuario);
	*}
	*/

}
