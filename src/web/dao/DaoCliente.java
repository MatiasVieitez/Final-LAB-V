package web.dao;

import java.util.List;

import web.model.Cliente;

public interface DaoCliente {
	
	public List<Cliente> listarClientes();
	public List<Object[]> listarClienteTabla(String nacionalidad, String nombre, String apellido);
	public boolean agregarCliente(Cliente cliente);
	public boolean modificarCliente(Cliente cliente);
	public boolean eliminarCliente(Cliente cliente);
	public Cliente obtenerClienteByID(int idCliente);
    boolean chequearDuplicado(String dni, String email);
	
}
