package test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import paquete.Atraccion;
import paquete.PromocionAxB;

public class PromocionAxBTest {

	@Test
	public void consultarDuracionTotal() {
		LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
		atracciones.add(new Atraccion(2, "Minas Tirith", 5, 2.5, 6));
		atracciones.add(new Atraccion(5, "Abismo de Helm", 5, 2, 15));

		LinkedList<Atraccion> atraccionesGratis = new LinkedList<Atraccion>();
		atraccionesGratis.add(new Atraccion(7, "Erebor", 12, 3, 32));

		PromocionAxB promocionAB = new PromocionAxB(1, "Pack Aventura AxB", atracciones, atraccionesGratis);
		Double duracionEsperada = 7.5;
		Double calculoDuracion = promocionAB.getDuracionHorasTotal();

		assertEquals(duracionEsperada, calculoDuracion);
	}

	@Test
	public void consultarCostoTotal() {
		LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
		atracciones.add(new Atraccion(2, "Minas Tirith", 5, 2.5, 6));
		atracciones.add(new Atraccion(5, "Abismo de Helm", 5, 2, 15));

		LinkedList<Atraccion> atraccionesGratis = new LinkedList<Atraccion>();
		atraccionesGratis.add(new Atraccion(7, "Erebor", 12, 3, 32));

		PromocionAxB promocionAB = new PromocionAxB(1, "Pack Aventura AxB", atracciones, atraccionesGratis);
		Double costoEsperado = 10.0;
		Double calculoCosto = promocionAB.getCosto();

		assertEquals(costoEsperado, calculoCosto);
	}

	@Test
	public void consultarCostoSinDescuento() {
		LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
		atracciones.add(new Atraccion(2, "Minas Tirith", 5, 2.5, 6));
		atracciones.add(new Atraccion(5, "Abismo de Helm", 5, 2, 15));

		LinkedList<Atraccion> atraccionesGratis = new LinkedList<Atraccion>();
		atraccionesGratis.add(new Atraccion(7, "Erebor", 12, 3, 32));

		PromocionAxB promocionAB = new PromocionAxB(1, "Pack Aventura AxB", atracciones, atraccionesGratis);
		Double costoEsperado = 17.0;
		Double calculoCosto = promocionAB.obtenerCostoSinDescuento();

		assertEquals(costoEsperado, calculoCosto);
	}
}
