package paquete;

import java.util.LinkedList;

public class PromocionAxB extends Promocion {
	LinkedList<Atraccion> atraccionesGratuitas = new LinkedList<Atraccion>();
	LinkedList<Atraccion> atraccionesPagas = new LinkedList<Atraccion>();
	LinkedList<Atraccion> atraccionesIncluidasToString = new LinkedList<Atraccion>();
	protected double duracionHorasTotal;
	
	public PromocionAxB(int promocionId, String nombre, LinkedList<Atraccion> atraccionesIncluidas,
			LinkedList<Atraccion> atraccionesGratis) {
		super(promocionId, nombre, atraccionesIncluidas);
		atraccionesGratuitas = atraccionesGratis;		
	}

	@Override
	public String toString() {
		return " - Tipo: AxB \n - Atracciones Incluidas: " + this.atraccionesIncluidasToString + "\n - Precio Descuento: $"
				+ this.costo + "\n - Precio Original: $" + this.obtenerCostoSinDescuento()+ "\n - Duracion: " + this.getDuracion() + "hs.";
	}

	protected double setCosto() {
		double costoAtraccionesGratis = 0;
		for (Atraccion atraccion :atraccionesGratuitas) {
			costoAtraccionesGratis += atraccion.getCosto();
		}
		return this.costo =obtenerCostoSinDescuento()-costoAtraccionesGratis;
	}
	
	public double getDuracionHorasTotal() {
		double DuracionHorasTotal = 0;
		for (Atraccion atraccion : this.atraccionesIncluidas) {
			DuracionHorasTotal += atraccion.getDuracion();
		}
		return this.duracionHorasTotal=DuracionHorasTotal;
	}

	public LinkedList<Atraccion> getAtraccionesIncluidas() {
		for (Atraccion atraccion : atraccionesGratuitas) {
				atraccionesIncluidas.add(atraccion);							
			}
		atraccionesIncluidasToString=atraccionesIncluidas;
		return atraccionesIncluidas;
	}

	public double obtenerCostoSinDescuento() {
		double costoSinDescuento = 0;
		for (Atraccion atraccion : atraccionesIncluidas) {
			costoSinDescuento += atraccion.getCosto();
		}
		return costoSinDescuento;
	}
	
	public void agregarAtraccionGratis(Atraccion atraccion) {
		this.atraccionesGratuitas.add(atraccion);
	}
	
	@Override
	public double getCosto() {
		return setCosto();
	}
}