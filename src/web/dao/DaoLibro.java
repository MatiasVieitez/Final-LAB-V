package web.dao;

import java.util.List;

import web.model.Libro;

public interface DaoLibro {
	
	public List<Libro> listarLibros();
	public List<Object[]> listarLibroTabla(String autor, String titulo, String descripcion);
	public boolean agregarLibro(Libro libro);
	public boolean modificarLibro(Libro libro);
	public boolean eliminarLibro(Libro libro);
	public Libro obtenerLibro(int idLibro);
}
