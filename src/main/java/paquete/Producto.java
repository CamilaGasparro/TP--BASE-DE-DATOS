package paquete;

import java.util.Objects;

public abstract class Producto implements Comparable<Producto> {

	protected String nombre;
	protected double costo;
	protected double duracionHoras; // horas
	protected int cupoDisponible;
	protected int cupoMaximo;

	public Producto(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public double getCosto() {
		return this.costo;
	}

	public double getDuracion() {
		return this.duracionHoras;
	}

	public int getCupoMaximo() {
		return this.cupoMaximo;
	}

	public int getCupoDisponible() {
		return this.cupoDisponible;
	}

	@Override
	public String toString() {
		return this.nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(costo, duracionHoras);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Double.doubleToLongBits(costo) == Double.doubleToLongBits(other.costo)
				&& Double.doubleToLongBits(duracionHoras) == Double.doubleToLongBits(other.duracionHoras);
	}

	@Override
	public int compareTo(Producto otroProducto) {
		Double duracion1 = this.getDuracion();
		return duracion1.compareTo(otroProducto.getDuracion());
	}

}
