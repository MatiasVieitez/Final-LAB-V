package web.service;

import java.util.List;

import web.model.Cliente;

public interface ClienteService {

	public List<Cliente> listarClientes();
	public List<Object[]> listarClienteTabla(String nacionalidad, String nombre, String apellido);
	public boolean agregarCliente(String dni,String nombre,String apellido,String sexo, int nacionalidad,String fechaNacimiento,String localidad,String direccion,String email,String telefono);
	public boolean modificarCliente(int id, int dni, String nombre, String apellido, String sexo, int nacionalidad, String fechaNacimiento, String localidad, String direccion, String email, String telefono);
	public boolean eliminarCliente(Cliente cliente);
	public Cliente obtenerCliente(int dni);
}
