package web.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.List;

import web.dao.DaoBiblioteca;
import web.model.Biblioteca;
import web.service.BibliotecaService;
import web.service.FuncionesSeparadasService;

public class BibliotecaServiceImpl implements BibliotecaService{
	
	private DaoBiblioteca daoBiblioteca;
	private Biblioteca biblioteca;
	private FuncionesSeparadasService funciones;
	
	@Override
	public List<Biblioteca> listarBibliotecas() {
		List<Biblioteca> biblioteca = daoBiblioteca.listarBibliotecas();
		return biblioteca;
	}
	
	@Override
	public boolean agregarBiblioteca(String libro, String fechaAlta, String estado) {
		try {

			int libroInteger = Integer.parseInt(libro);
			
			biblioteca.setLibro(funciones.obtenerLibro(libroInteger));
			biblioteca.setFechaAlta(new SimpleDateFormat("yyyy-MM-dd").parse(fechaAlta));
			biblioteca.setEstado(estado);

			return daoBiblioteca.agregarBiblioteca(biblioteca);

		} catch (Exception e) {

			e.getCause();
			return false;
		}
	}
	
	@Override
	public boolean modificarBiblioteca(int id, String libro, String fechaAlta, String estado) {
		try {
			Biblioteca biblioteca = daoBiblioteca.obtenerBibliotecaByID(id);
			int libroInteger = Integer.parseInt(libro);
			
			biblioteca.setId(id);
			biblioteca.setLibro(funciones.obtenerLibro(libroInteger));
			biblioteca.setFechaAlta(new SimpleDateFormat("yyyy-MM-dd").parse(fechaAlta));
			biblioteca.setEstado(estado);
	
			boolean status = daoBiblioteca.modificarBiblioteca(biblioteca);
			return status;
		} catch (Exception e) {
			e.getCause();
			return false;
			}
	}

	
	@Override
	public boolean eliminarBiblioteca(Biblioteca biblioteca) {
		return daoBiblioteca.eliminarBiblioteca(biblioteca);
	}
	
	@Override
	public Biblioteca obtenerBiblioteca(int id) {
		return daoBiblioteca.obtenerBibliotecaByID(id);
	}
	
	
}
