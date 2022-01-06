package clases;

import static org.junit.Assert.*;
import java.sql.Connection;

import java.sql.SQLException;

import org.junit.AfterClass;

public class Test {

	@Test
	public void testInsertarNuevoUsuario() {
		try {
			Connection con = Db.initBD("Datos.db");
			int contAntesDeInsertar = Db.contarUsuarios();
			Db.anadirUsuario("786385023F", "A", "B", "AB", "dfghjk");
			int contDespuesDeInsertar = Db.contarUsuarios();
			assertTrue(contAntesDeInsertar == contDespuesDeInsertar - 1);
			Db.closeBD(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
