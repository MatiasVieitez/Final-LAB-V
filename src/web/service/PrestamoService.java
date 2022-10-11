package web.service;

import java.util.List;

import web.model.Biblioteca;
import web.model.Cliente;
import web.model.Prestamo;

public interface PrestamoService {
	
	public List<Prestamo> listarPrestamos();
	public boolean modificarPrestamo(int id, String biblioteca, String cliente, String fechaAlta,int cantDias);
	public Prestamo obtenerPrestamo(int id);
    boolean agregarPrestamo(Biblioteca b, Cliente c, int cantidadDias, String fecha);
    boolean eliminarPrestamo(Prestamo p);
	
}
