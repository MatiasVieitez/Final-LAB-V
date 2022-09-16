package web.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.List;

import web.dao.DaoCliente;
import web.model.Cliente;
import web.service.ClienteService;
import web.service.FuncionesSeparadasService;

public class ClienteServiceImpl implements ClienteService {

	private DaoCliente daoCliente;
	private Cliente cliente;
	private FuncionesSeparadasService funciones;

	@Override
	public List<Cliente> listarClientes() {

		List<Cliente> clientes = daoCliente.listarClientes();
		return clientes;
	}

	@Override
	public List<Object[]> listarClienteTabla(String nacionalidad, String nombre, String apellido) {

		return daoCliente.listarClienteTabla(nacionalidad, nombre, apellido);
	}

	@Override
	public boolean agregarCliente(String dni, String nombre, String apellido, String sexo, int nacionalidad,
			String fechaNacimiento, String localidad, String direccion, String email, String telefono) {

		try {

			int dniInteger = Integer.parseInt(dni);
			cliente.setApellido(apellido);
			cliente.setDireccion(direccion);
			cliente.setDni(dniInteger);
			cliente.setEmail(email);
			cliente.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimiento));
			cliente.setLocalidad(localidad);
			cliente.setNacionalidad(funciones.obtenerNacionalidad(nacionalidad));
			cliente.setNombre(nombre);
			cliente.setSexo(sexo);
			cliente.setTelefono(telefono);

			return daoCliente.agregarCliente(cliente);

		} catch (Exception e) {

			e.getCause();
			return false;
		}

	}

	@Override
	public boolean modificarCliente(int id, int dni, String nombre, String apellido, String sexo, int nacionalidad,
			String fechaNacimiento, String localidad, String direccion, String email, String telefono) {
		try {
			Cliente cliente = daoCliente.obtenerClienteByID(id);

			cliente.setId(id);
			cliente.setApellido(apellido);
			cliente.setDireccion(direccion);
			cliente.setDni(dni);
			cliente.setEmail(email);
			cliente.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimiento));
			cliente.setLocalidad(localidad);
			cliente.setNombre(nombre);
			cliente.setSexo(sexo);
			cliente.setTelefono(telefono);
			cliente.setNacionalidad(funciones.obtenerNacionalidad(nacionalidad));

			boolean status = daoCliente.modificarCliente(cliente);
			return status;
		} catch (Exception e) {
			e.getCause();
			return false;
		}
	}

	@Override
	public boolean eliminarCliente(Cliente cliente) {
		return daoCliente.eliminarCliente(cliente);
	}

	@Override
	public Cliente obtenerCliente(int id) {
		return daoCliente.obtenerClienteByID(id);
	}

}
