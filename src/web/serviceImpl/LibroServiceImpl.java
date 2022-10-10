package web.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.daoImpl.DaoLibroImpl;
import web.model.Libro;
import web.service.LibroService;

@Service("LibroServiceImpl")
public class LibroServiceImpl implements LibroService{

	@Autowired
	private DaoLibroImpl daoLibroImpl;
	
	@Override
	public boolean AgregarLibro(Libro libro) {
		return daoLibroImpl.agregarLibro(libro);
	}

	@Override
	public List<Libro> listarLibros() {
		return daoLibroImpl.listarLibros();
	}

	@Override
	public Libro obtenerLibro(int id) {
		return daoLibroImpl.obtenerLibro(id);
	}

}
