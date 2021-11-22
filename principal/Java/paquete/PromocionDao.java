package paquete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class PromocionDao {

	public LinkedList<Promocion> findAll() throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "SELECT * FROM promociones,atracciones,promociones_atracciones where fk_promo=promocionId and fk_atraccion=atraccion_id";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();
		LinkedList<Promocion> listadoPromociones = new LinkedList<Promocion>();
		LinkedList<Atraccion> atraccionIncluidas;
		LinkedList<Atraccion> atraccionIncluidasGratis = new LinkedList<Atraccion>();
		int idPromocion = 0;

		while (result.next()) {
			if (idPromocion != result.getInt("promocionId")) {
				atraccionIncluidas = new LinkedList<Atraccion>();
				atraccionIncluidasGratis = new LinkedList<Atraccion>();
				atraccionIncluidas.add(toAtraccion(result));
				listadoPromociones.add(toPromocion(result, atraccionIncluidas, atraccionIncluidasGratis));
				idPromocion = result.getInt("promocionId");

			} else if (idPromocion == result.getInt("promocionId")) {
				String tipoPromocion = result.getString("tipoPromocion");
				String caracteristica = result.getString("caracteristica");
				if (tipoPromocion.equals("AxB") && caracteristica.equals("G")) {
					listadoPromociones.get(idPromocion - 1).agregarAtraccionGratis(toAtraccion(result));
					idPromocion = result.getInt("promocionId");
				} else {
					listadoPromociones.get(idPromocion - 1).agregarAtraccion(toAtraccion(result));
					idPromocion = result.getInt("promocionId");
				}
			}
		}
		return listadoPromociones;
	}

	private Promocion toPromocion(ResultSet result, LinkedList<Atraccion> atraccionIncluidas,
			LinkedList<Atraccion> atraccionIncluidasGratis) throws SQLException {

		int promocionId = result.getInt("promocionId");
		String nombre_promo = result.getString("nombre_promo");
		String tipoPromocion = result.getString("tipoPromocion");
		Promocion unaPromocionAbsolutaVacia = new PromocionAbsoluta(0, "", atraccionIncluidas, 0);

		if (tipoPromocion.equals("Absoluta")) {
			double precioDescuento = result.getDouble("detalle");
			Promocion unaPromocionAbsoluta = new PromocionAbsoluta(promocionId, nombre_promo, atraccionIncluidas,
					precioDescuento);
			return unaPromocionAbsoluta;

		} else if (tipoPromocion.equals("Porcentual")) {
			double porcentajeDescuento = result.getDouble("detalle");
			Promocion unaPromocionPorcentual = new PromocionPorcentual(promocionId, nombre_promo, atraccionIncluidas,
					porcentajeDescuento);
			return unaPromocionPorcentual;
		} else if (tipoPromocion.equals("AxB")) {
			Promocion unaPromocionAxB = new PromocionAxB(promocionId, nombre_promo, atraccionIncluidas,
					atraccionIncluidasGratis);
			return unaPromocionAxB;
		}
		return unaPromocionAbsolutaVacia;
	}

	public Atraccion toAtraccion(ResultSet result) throws SQLException {
		int atraccion_id = result.getInt("atraccion_id");
		String nombre = result.getString("nombre_atraccion");
		Double costo = result.getDouble("costo");
		Double duracionHoras = result.getDouble("duracionHoras");
		int cupoMaximo = result.getInt("cupoMaximo");
		return new Atraccion(atraccion_id, nombre, costo, duracionHoras, cupoMaximo);
	}
}
