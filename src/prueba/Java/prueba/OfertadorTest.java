package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.LinkedList;

import org.junit.Test;

import paquete.Atraccion;
import paquete.Ofertador;
import paquete.Promocion;
import paquete.PromocionAbsoluta;
import paquete.Usuario;

public class OfertadorTest {

	@Test
	public void testOfertarAtraccion() throws SQLException {
		// preparar pureba, crear elementos y contexto
		boolean valorObtenido;
		Usuario u1 = new Usuario(1,"Eowyn", "10", "8");
		Atraccion a1 = new Atraccion(1, "Moria", 10, 2, 6);
		Atraccion a2 = new Atraccion(2, "Minas Tirith", 5, 2.5, 6);
		Atraccion a3 = new Atraccion(3,"La Comarca", 3, 6.5, 150);
		Atraccion a4 = new Atraccion(5, "Abismo de Helm", 5, 2, 15);
		Atraccion a5 = new Atraccion(8, "Bosque Negro", 3, 4, 12);
		LinkedList<Atraccion> atraccionesInc2 = new LinkedList<Atraccion>();
		atraccionesInc2.add(a1);
		atraccionesInc2.add(a2);
		atraccionesInc2.add(a3);
		atraccionesInc2.add(a4);
		atraccionesInc2.add(a5);

		Ofertador o1 = new Ofertador();
		
		//ejecutar
		valorObtenido=o1.ofertarAtraccion(atraccionesInc2,u1);
		
		// verificar respuestas
		assertEquals(valorObtenido,true);
	
	}
	
	@Test
	public void testOfertarPromocion() throws SQLException {
		// preparar pureba, crear elementos y contexto
		boolean valorObtenido;
		Atraccion a1 = new Atraccion(3,"La Comarca", 3, 6.5, 150);
		Atraccion a2 = new Atraccion(6,"Lothlórien", 35, 1, 30);
		Atraccion a3 = new Atraccion(7, "Erebor", 12, 3, 32);

		
		LinkedList<Atraccion> atraccionesInc = new LinkedList<Atraccion>();
		atraccionesInc.add(a1);
		atraccionesInc.add(a2);
		
		LinkedList<Atraccion> atraccionesInc2 = new LinkedList<Atraccion>();
		atraccionesInc2.add(a1);
		atraccionesInc2.add(a2);
		atraccionesInc2.add(a3);
		
		Promocion p1 = new PromocionAbsoluta(1,"Pack Degustación", atraccionesInc, 36);
		Promocion p2 = new PromocionAbsoluta(2,"Pack Degustación Plus", atraccionesInc2, 46);
		
		LinkedList<Promocion> promos = new LinkedList<Promocion>();
		promos.add(p1);
		promos.add(p2);
		Usuario u1 = new Usuario(3,"Sam", "36", "8");
		Ofertador o1 = new Ofertador();
		
		//ejecutar
		valorObtenido=o1.ofertarPromociones(promos,u1);
		
		// verificar respuestas
		assertEquals(valorObtenido,true);
	
	}
}