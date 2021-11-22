package paquete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class AtraccionDao {
	static LinkedList<Atraccion> atracciones;

	public LinkedList<Atraccion> findAll() throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "SELECT * FROM ATRACCIONES";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();
		LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
		while (result.next()) {
			atracciones.add(toAtraccion(result));
		}
		return atracciones;
	}
	
	public int updateCupo(Atraccion atraccion) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "UPDATE ATRACCIONES SET cupoMaximo =? WHERE atraccion_id =?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setDouble(1, atraccion.getCupoDisponible());
		statement.setDouble(2, atraccion.getAtraccion_id());
		int rows = statement.executeUpdate();
		return rows;
	}

	public int updateAll(LinkedList<Atraccion> listadoAtracciones) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		PreparedStatement statement = null;
		int rows=0;
		for (Atraccion atraccion : listadoAtracciones) {
			String sql = "UPDATE ATRACCIONES SET cupoMaximo =? WHERE atraccion_id =?";
			statement = connection.prepareStatement(sql);
			statement.setDouble(1, atraccion.getCupoDisponible());
			statement.setDouble(2, atraccion.getAtraccion_id());
			rows = statement.executeUpdate();
		}
		return rows;
	}

	private Atraccion toAtraccion(ResultSet result) throws SQLException {
		int atraccion_id = result.getInt("atraccion_id");
		String nombre = result.getString("nombre_atraccion");
		Double costo = result.getDouble("costo");
		Double duracionHoras = result.getDouble("duracionHoras");
		int cupoMaximo = result.getInt("cupoMaximo");
		return new Atraccion(atraccion_id, nombre, costo, duracionHoras, cupoMaximo);
	}

}
