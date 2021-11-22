package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.LinkedList;

import org.junit.Test;

import paquete.Atraccion;
import paquete.Promocion;
import paquete.PromocionAbsoluta;
import paquete.Usuario;

public class UsuarioTest {

	@Test
	public void aceptarAtraccion() throws SQLException {
		Atraccion a1 = new Atraccion(3,"La Comarca", 3, 6.5, 150);
		Usuario u1 = new Usuario(3,"Sam", "36", "8");
		u1.aceptarAtraccion(a1);
		Double monedasRestantesEsperadas =  (double) 33;
		Double monedasRestantesReal=u1.getMonedasDisponibles();
		assertEquals(monedasRestantesReal,monedasRestantesEsperadas);	
		Double tiempoRestanteEsperado =  (double) 1.5;
		Double tiempoRestanteReal=u1.getTiempoDisponible();
		assertEquals(tiempoRestanteReal,tiempoRestanteEsperado);
	}

	@Test
	public void aceptarPromocion() throws SQLException {
		Atraccion a1 = new Atraccion(3,"La Comarca", 3, 6.5, 150);
		Atraccion a2 = new Atraccion(6,"Lothlórien", 35, 1, 30);
		LinkedList<Atraccion> atraccionesInc = new LinkedList<Atraccion>();
		atraccionesInc.add(a1);
		atraccionesInc.add(a2);
		Promocion p1 = new PromocionAbsoluta(2,"Pack Degustación", atraccionesInc, 36);
		Usuario u1 = new Usuario(3,"Sam", "36", "8");
		u1.aceptarPromocion(p1);
		Double monedasRestantesEsperadas =  (double) 0;
		Double monedasRestantesReal=u1.getMonedasDisponibles();
		assertEquals(monedasRestantesReal,monedasRestantesEsperadas);	
		Double tiempoRestanteEsperado =  (double) 0.5;
		Double tiempoRestanteReal=u1.getTiempoDisponible();
		assertEquals(tiempoRestanteReal,tiempoRestanteEsperado);
		assertEquals (atraccionesInc,u1.getAtraccionesVisitadas());
	}
}