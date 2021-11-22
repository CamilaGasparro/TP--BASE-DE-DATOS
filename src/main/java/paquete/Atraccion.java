package paquete;

import java.sql.SQLException;

public class Atraccion extends Producto implements Comparable<Producto> {

	protected double costo;
	protected double duracionHoras;
	protected int cupoDisponible;
	protected int cupoMaximo;
	protected int atraccion_id;

	public int getAtraccion_id() {
		return atraccion_id;
	}

	public void setAtraccion_id(int atraccion_id) {
		this.atraccion_id = atraccion_id;
	}

	public Atraccion(int atraccion_id, String nombre, double costo, double duracionHoras, int cupoMaximo) {
		super(nombre);
		this.costo = verificarPositivo(costo);
		this.duracionHoras = verificarPositivo(duracionHoras);
		this.cupoMaximo = cupoMaximo;
		this.cupoDisponible = cupoMaximo;
		this.atraccion_id = atraccion_id;
	}

	public int getCupoDisponible() {
		return this.cupoDisponible;
	}

	public double getCosto() {
		return this.costo;
	}

	public double getDuracion() {
		return this.duracionHoras;
	}

	public void setCupoDisponible() {
		this.cupoDisponible = this.cupoMaximo;
	}

	public void reservar() throws SQLException {
		this.cupoDisponible--;
	}

	private double verificarPositivo(double numero) {
		if (numero < 0) {
			throw new RuntimeException("El n�mero es negativo");
		}
		return numero;
	}

	@Override
	public String toString() {
		return this.getNombre();
	}

	public String mostrarComoAtraccion() {
		return " - Nombre: " + nombre + "\n - Precio: $" + costo + "\n - Duracion: " + duracionHoras + "hs.";
	}
}
