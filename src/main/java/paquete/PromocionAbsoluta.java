package paquete;

import java.util.LinkedList;

public class PromocionAbsoluta extends Promocion {

	public PromocionAbsoluta(int promocionId,String nombre, LinkedList<Atraccion> atraccionesIncluidas, double precioDescuento) {
		super(promocionId, nombre, atraccionesIncluidas);
		this.costo = precioDescuento;
	}

	@Override
	public String toString() {
		return " - Tipo: Absoluta \n - Atracciones Incluidas: " + atraccionesIncluidas + "\n - Precio Descuento: $"
				+ this.costo + "\n - Precio Original: $" + this.getCostoSinDescuento() + "\n - Duracion: " + this.getDuracion() + "hs.";
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

}
