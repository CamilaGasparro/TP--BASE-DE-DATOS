package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import paquete.Atraccion;

public class AtraccionTest {

	Atraccion atraccion = new Atraccion(4,"Mordor", 25, 3, 4); 
	
	@Test
	public void crearAtraccion() {
		assertNotNull(atraccion);
	}
	
	@Test
	public void consultarCosto() {
		assertEquals(25, atraccion.getCosto(), 0);
	}

	@Test
	public void consultarDuracion() {
		assertEquals(3, atraccion.getDuracion(), 0);
	}
	
	@Test
	public void consultarCupoDisponible() {
		assertEquals(4, atraccion.getCupoDisponible(), 0);
	}
	
	@Test
	public void consultarSiDescuentaCupo() throws SQLException {
		atraccion.reservar();

		assertEquals(3, atraccion.getCupoDisponible(), 0);
	}
	
	@Test
	public void setearCupo() {
		atraccion.setCupoDisponible();

		assertEquals(4, atraccion.getCupoDisponible(), 0);
	}
	
	@Test (expected = RuntimeException.class)
	public void instanciarDuracionNegativa() {
		Atraccion otraAtraccion = new Atraccion(4,"Mordor", 25, -3, 4);
		
		assertNull(otraAtraccion);
	}
	
	@Test (expected = RuntimeException.class)
	public void instanciarCostoNegativo() {
		Atraccion otraAtraccion = new Atraccion(4,"Mordor", -25, 3, 4);
		
		assertNull(otraAtraccion);
	}
}
