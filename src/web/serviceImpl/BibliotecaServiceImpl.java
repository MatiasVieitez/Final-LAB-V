package web.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import web.dao.DaoBiblioteca;
import web.model.Biblioteca;
import web.service.BibliotecaService;
import web.service.FuncionesSeparadasService;

@Service("BibliotecaServiceImpl")
public class BibliotecaServiceImpl implements BibliotecaService{
	
	@Autowired
	private DaoBiblioteca daoBiblioteca;
	@Autowired
	private Biblioteca biblioteca;
	@Autowired
	@Qualifier("FuncionesService")
	private FuncionesSeparadasService funciones;
	
	@Override
	public List<Biblioteca> listarBibliotecas() {
		List<Biblioteca> biblioteca = daoBiblioteca.listarBibliotecas();
		return biblioteca;
	}
	
	@Override
    public List<Biblioteca> listarBibliotecasEstado() {
        List<Biblioteca> biblioteca = daoBiblioteca.listarBibliotecasEstado();
        return biblioteca;
    }
	
	@Override
	public boolean agregarBiblioteca(String libro, String fechaAlta, String estado) {
		try {

			int libroInteger = Integer.parseInt(libro);
			
			biblioteca.setLibro(funciones.obtenerLibro(libroInteger));
			biblioteca.setFechaAlta((fechaAlta));
			biblioteca.setEstado(estado);

			return daoBiblioteca.agregarBiblioteca(biblioteca);

		} catch (Exception e) {

			e.getCause();
			return false;
		}
	}
	
	@Override
	public boolean modificarBiblioteca(int id, String fechaAlta, String estado) {
		try {
			Biblioteca biblioteca = daoBiblioteca.obtenerBibliotecaByID(id);
				
			biblioteca.setId(id);
			biblioteca.setFechaAlta((fechaAlta));
			biblioteca.setEstado(estado);
	
			boolean status = daoBiblioteca.modificarBiblioteca(biblioteca);
			return status;
		} catch (Exception e) {
			e.getCause();
			return false;
			}
	}

	@Override
    public boolean modificarBiblioteca(Biblioteca b) {
        return daoBiblioteca.modificarBiblioteca(b);
    }
	
	@Override
	public boolean eliminarBiblioteca(Biblioteca biblioteca) {
		return daoBiblioteca.eliminarBiblioteca(biblioteca);
	}
	
	@Override
	public Biblioteca obtenerBiblioteca(int id) {
		return daoBiblioteca.obtenerBibliotecaByID(id);
	}

	@Override
	public List<Object[]> listarBibliotecaTabla(String libro, String estado) {
		return daoBiblioteca.listarBibliotecaTabla( libro, estado);
	}
	
	
}
