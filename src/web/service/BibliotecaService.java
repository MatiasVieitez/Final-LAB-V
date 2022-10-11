package web.service;

import java.util.List;

import web.model.Biblioteca;

public interface BibliotecaService {
	
	public List<Biblioteca> listarBibliotecas();
	public List<Object[]> listarBibliotecaTabla( String libro, String estado);
	public boolean agregarBiblioteca(String libro, String fechaAlta, String estado);
	public boolean modificarBiblioteca(int id, String fechaAlta, String estado);
	public boolean eliminarBiblioteca(Biblioteca biblioteca);
	public Biblioteca obtenerBiblioteca(int id);
    boolean modificarBiblioteca(Biblioteca b);
    List<Biblioteca> listarBibliotecasEstado();
   
}
