package clases;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

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

}
