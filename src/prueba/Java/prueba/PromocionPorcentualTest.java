package test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import paquete.Atraccion;
import paquete.PromocionPorcentual;

public class PromocionPorcentualTest {

	@Test
	public void consultarPrecioConDescuento() {
		LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
		atracciones.add(new Atraccion(4, "Mordor", 25, 3, 4));
		atracciones.add(new Atraccion(8, "Bosque Negro", 3, 4, 12));

		PromocionPorcentual promocionPorc = new PromocionPorcentual(1, "Pack Aventura", atracciones, 0.20);
		Double costoEsperado = 22.0;
		Double calculoCosto = promocionPorc.getCosto();

		assertEquals(costoEsperado, calculoCosto);
	}

	@Test
	public void consultarDuracionTotal() {
		LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
		atracciones.add(new Atraccion(4, "Mordor", 25, 3, 4));
		atracciones.add(new Atraccion(8, "Bosque Negro", 3, 4, 12));

		PromocionPorcentual promocionPorc = new PromocionPorcentual(1, "Pack Aventura", atracciones, 0.20);
		Double duracionEsperada = 7.00;
		Double calculoDuracion = promocionPorc.getDuracion();

		assertEquals(duracionEsperada, calculoDuracion);
	}

}
