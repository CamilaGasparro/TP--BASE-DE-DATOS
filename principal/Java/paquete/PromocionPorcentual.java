package paquete;

import java.util.LinkedList;

public class PromocionPorcentual extends Promocion {
	protected double porcentajeDescuento;
	

	public PromocionPorcentual(int promocionId, String nombre, LinkedList<Atraccion> atraccionesIncluidas, double porcentajeDescuento) {
		super(promocionId, nombre, atraccionesIncluidas);
		this.porcentajeDescuento=porcentajeDescuento;
	}

	@Override
	public String toString() {
		return " - Tipo: Porcentual \n - Atracciones Incluidas: " + atraccionesIncluidas + "\n - Precio Descuento: $"
				+ this.costo + "\n - Precio Original: $" + this.getCostoSinDescuento()+ "\n - Duracion: " + this.getDuracion() + "hs.";
	}

	@Override
	public void agregarAtraccionGratis(Atraccion atraccion) {
	}
	
	protected void agregarAtraccionPaga(Atraccion atraccion) {		
	}

	@Override
	protected LinkedList<Atraccion> getAtraccionesIncluidas() {
		return atraccionesIncluidas;	
	}
	
	@Override
	public double getCosto() {
		Double costo= (double) Math.round(this.getCostoSinDescuento() * (1 - porcentajeDescuento));
		return this.costo =costo;
	}
}

