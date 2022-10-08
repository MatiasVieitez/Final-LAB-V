package web.service;

import java.util.List;
import web.model.Prestamo;

public interface PrestamoService {
	
	public List<Prestamo> listarPrestamos();
	public boolean agregarPrestamo( String biblioteca, String cliente, String fechaAlta,int cantDias);
	public boolean modificarPrestamo(int id, String biblioteca, String cliente, String fechaAlta,int cantDias);
	public Prestamo obtenerPrestamo(int id);
	//public List<Object[]> listarClienteTabla(String nacionalidad, String nombre, String apellido);
	
}
