package web.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import web.dao.DaoCliente;
import web.model.Cliente;

public class DaoClienteImpl implements DaoCliente {

	@Autowired
	private Conexion conexion;

	@Override
	public List<Cliente> listarClientes() {

		conexion.abrirConexion();

		@SuppressWarnings("unchecked")
		List<Cliente> clients = (List<Cliente>) conexion.getSession()
				.createQuery("FROM clientes a ORDER BY id_cliente asc").list();

		conexion.cerrarSession();

		return clients;
	}

	@Override
	public List<Object[]> listarClienteTabla(String nacionalidad, String nombre, String apellido) {

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

	@Override
	public boolean agregarCliente(Cliente cliente) {
		conexion.abrirConexion();

		Boolean status = true;

		try {
			conexion.IniciarTransaccion();
			conexion.GuardarObjeto(cliente);
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
	public boolean modificarCliente(Cliente cliente) {
		conexion.abrirConexion();
		boolean status = true;
		try {
			conexion.IniciarTransaccion();
			conexion.ActualizarObjeto(cliente);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			status = false;
		}
		conexion.cerrarSession();
		return status;
	}

	@Override
	public boolean eliminarCliente(Cliente cliente) {
		conexion.abrirConexion();
		Boolean status = true;

		try {
			conexion.IniciarTransaccion();
			conexion.BorrarObjeto(cliente);
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
	public Cliente obtenerClienteByID(int idCliente) {
		conexion.abrirConexion();
		
		Cliente cliente;
		
		try {
			cliente = (Cliente)conexion.ObtenerObjeto(Cliente.class, idCliente);
		}
		catch(Exception e){
			e.getCause();
			cliente = null;
		}
		conexion.cerrarSession();
		return cliente;
		
	}

}
