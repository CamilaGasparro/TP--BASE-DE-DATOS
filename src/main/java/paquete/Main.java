package paquete;

import java.sql.SQLException;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws SQLException {	
		
		AtraccionDao atraccionDao = new AtraccionDao();
		LinkedList <Atraccion> listadoAtracciones = atraccionDao.findAll();
		
		UsuarioDao usuarioDao = new UsuarioDao();
		LinkedList <Usuario> listadoUsuarios = usuarioDao.findAll();
	
		PromocionDao promocionDao = new PromocionDao();
		LinkedList <Promocion> listadoPromociones = promocionDao.findAll();
	
		Ofertador o1 = new Ofertador();
		for (Usuario usuario : listadoUsuarios) {
			o1.ofertar(listadoPromociones, listadoAtracciones, usuario);
			usuario.mostrarResumenTotal();
			usuario.crearArchivoDeAtracciones();
			usuario.actualizarBaseDatos();
		}
	}
}