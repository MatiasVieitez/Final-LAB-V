package web.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.dao.DaoPrestamo;
import web.model.Prestamo;

@Repository("DaoPrestamoImpl")
public class DaoPrestamoImpl implements DaoPrestamo{

	@Autowired
	private Conexion conexion;

	@Override
	public List<Prestamo> listarPrestamos() {

		conexion.abrirConexion();

		@SuppressWarnings("unchecked")
		List<Prestamo> prests = (List<Prestamo>) conexion.getSession()
				.createQuery("FROM prestamo a ORDER BY id_cliente asc").list();

		conexion.cerrarSession();

		return prests;
	}

	@Override
	public boolean agregarPrestamo(Prestamo prestamo) {
		conexion.abrirConexion();

		Boolean status = true;

		try {
			conexion.IniciarTransaccion();
			conexion.GuardarObjeto(prestamo);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			e.getCause();
			conexion.RollbackearTransaccion();
			status = false;
		}

		conexion.cerrarSession();
		return status;
	}

	@Override
	public boolean modificarPrestamo(Prestamo prestamo) {
		conexion.abrirConexion();
		boolean status = true;
		try {
			conexion.IniciarTransaccion();
			conexion.ActualizarObjeto(prestamo);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			status = false;
		}
		conexion.cerrarSession();
		return status;
	}

	@Override
	public Prestamo obtenerPrestamoByID(int idPrestamo) {
		conexion.abrirConexion();
		
		Prestamo prestamo;
		
		try {
			prestamo = (Prestamo)conexion.ObtenerObjeto(Prestamo.class, idPrestamo);
		}
		catch(Exception e){
			e.getCause();
			prestamo = null;
		}
		conexion.cerrarSession();
		return prestamo;
		
	}

	//ACcion cuando precionas el boton para Eliminar o Modificar
		/*
		@Override
		public List<Object[]> listarPrestamoTabla(String nacionalidad, String nombre, String apellido) {

			String query = "";
			int cantCondiciones = 0;

			if (nacionalidad.length() > 0) {
				query = " WHERE n.descripcion = '" + nacionalidad + "'";
				cantCondiciones++;
			}

			if (nombre.length() > 0) {
				if (cantCondiciones == 0) {
					query = " WHERE c.Nombre = '" + nombre + "'";
					cantCondiciones++;
				} else
					query += " AND c.Nombre = '" + nombre + "'";
			}

			if (apellido.length() > 0) {
				if (cantCondiciones == 0) {
					query = " WHERE c.Apellido = '" + apellido + "'";
					cantCondiciones++;
				} else
					query += " AND c.Apellido = '" + apellido + "'";
			}

			conexion.abrirConexion();
			List<Object[]> clientList = conexion.ObtenerListaPorQuery(
					"SELECT c.id_cliente as idCliente, c.Dni as DNI, c.Nombre as Nombre, c.Apellido as Apellido, c.sexo as Sexo, n.descripcion as Nacionalidad, c.Email as Email, c.Direccion as Direccion, c.Localidad as Localidad, c.Telefono as Telefono, DATE_FORMAT(c.FechaNacimiento,'%d/%m/%Y') as 'Fecha Nacimiento'"
							+ " FROM Cliente as c INNER JOIN Nacionalidad as n ON c.id_nacionalidad = n.id_nacionalidad"
							+ query + " order by c.idCliente;");
			conexion.cerrarSession();

			return clientList;

		}
		*/
	
}
