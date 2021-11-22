package paquete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;

public class UsuarioDao {

	public LinkedList<Usuario> findAll() throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "SELECT * FROM USUARIO";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();
		LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
		while (result.next()) {
			usuarios.add(toUsuario(result));
		}
		//ConnectionProvider.close();
		return usuarios;
		
	}

	public int update(Usuario usuario) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "UPDATE USUARIO SET monedasDisponibles =?, tiempoDisponible =?, atraccionesVisitadas =? WHERE usuarioId =?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setDouble(1, usuario.getMonedasDisponibles());
		statement.setDouble(2, usuario.getTiempoDisponible());
		String cadenaNombresAtraccionesVisitadas = "";
		for (Atraccion unaAtraccion : usuario.getAtraccionesVisitadas()) {
			cadenaNombresAtraccionesVisitadas += unaAtraccion.getNombre() + ",";
		}
		if(cadenaNombresAtraccionesVisitadas.length()>0) {
			cadenaNombresAtraccionesVisitadas= cadenaNombresAtraccionesVisitadas.substring(0, cadenaNombresAtraccionesVisitadas.length()-1);
		}
		
		statement.setString(3, cadenaNombresAtraccionesVisitadas);
		statement.setDouble(4, usuario.getUsuarioId());
		int rows = statement.executeUpdate();
		return rows;
		
	}
	
	private Usuario toUsuario(ResultSet result) throws SQLException {
		int usuarioId = result.getInt("usuarioId");
		String nombre = result.getString("nombre");
		Double monedaDisponibles = result.getDouble("monedasDisponibles");
		Double tiempoDisponible = result.getDouble("tiempoDisponible");
		AtraccionDao atraccionDao = new AtraccionDao();
		LinkedList<Atraccion> listadoAtracciones = atraccionDao.findAll();
		LinkedList<Atraccion> atraccionesVisitadas = new LinkedList<Atraccion>();
		String atracciones_visitadas = result.getString("atraccionesVisitadas");
		if (atracciones_visitadas != null) {
			LinkedList<String> nombreAtracciones = new LinkedList<String>(
					Arrays.asList(atracciones_visitadas.split(",")));
			for (Atraccion unaAtraccion : listadoAtracciones) {
				for (String unNombre : nombreAtracciones) {
					if (unaAtraccion.nombre.equals(unNombre)) {
						atraccionesVisitadas.add(unaAtraccion);
					}
				}
			}
		}
		return new Usuario(usuarioId, nombre, monedaDisponibles, tiempoDisponible, atraccionesVisitadas);
	}

}
