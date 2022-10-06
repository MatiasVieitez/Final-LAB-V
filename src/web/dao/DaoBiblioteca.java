package web.dao;

import java.util.List;

import web.model.Biblioteca;

public interface DaoBiblioteca {

	public List<Biblioteca> listarBibliotecas();
	public boolean agregarBiblioteca(Biblioteca biblioteca);
	public boolean modificarBiblioteca(Biblioteca biblioteca);
	public boolean eliminarBiblioteca(Biblioteca biblioteca);
	public Biblioteca obtenerBibliotecaByID(int idBiblioteca);
	//public List<Object[]> listarClienteTabla(String nacionalidad, String nombre, String apellido);
}
