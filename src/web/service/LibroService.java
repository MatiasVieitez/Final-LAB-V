package web.service;

import java.util.List;

import web.model.Libro;

public interface LibroService {
	
	public boolean AgregarLibro(Libro libro);

	List<Libro> listarLibros();

	Libro obtenerLibro(int id);
	
}
