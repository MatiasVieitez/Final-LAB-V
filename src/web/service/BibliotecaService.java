package web.service;

import java.util.List;

import web.model.Biblioteca;

public interface BibliotecaService {
	
	public List<Biblioteca> listarBibliotecas();
	public boolean agregarBiblioteca(String libro, String fechaAlta, String estado);
	public boolean modificarBiblioteca(int id, String libro, String fechaAlta, String estado);
	public boolean eliminarBiblioteca(Biblioteca biblioteca);
	public Biblioteca obtenerBiblioteca(int id);
	//public List<Object[]> listarClienteTabla(String nacionalidad, String nombre, String apellido);
}
