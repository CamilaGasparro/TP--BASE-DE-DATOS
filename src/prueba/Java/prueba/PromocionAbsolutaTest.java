package test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import paquete.Atraccion;
import paquete.PromocionAbsoluta;

public class PromocionAbsolutaTest {

	@Test
	public void consultarPrecioConDescuento() {
		LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
		atracciones.add(new Atraccion(3,"La Comarca", 3, 6.5, 150));
		atracciones.add(new Atraccion(6,"Lothlórien", 35, 1, 30));

		PromocionAbsoluta promocionAbs = new PromocionAbsoluta(2, "Pack Degustación", atracciones, 36);
		Double costoEsperado = 36.0;
		Double calculoCosto = promocionAbs.getCosto();

		assertEquals(costoEsperado, calculoCosto);
	}

	@Test
	public void consultarDuracionTotal() {
		LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
		atracciones.add(new Atraccion(3,"La Comarca", 3, 6.5, 150));
		atracciones.add(new Atraccion(6,"Lothlórien", 35, 1, 30));

		PromocionAbsoluta promocionAbs = new PromocionAbsoluta(2, "Pack Degustación", atracciones, 36);
		Double duracionEsperada = 7.5;
		Double calculoDuracion = promocionAbs.getDuracion();

		assertEquals(duracionEsperada, calculoDuracion);
	}

}
