package web.serviceImpl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import web.dao.DaoNacionalidad;
import web.dao.DaoLibro;
import web.dao.DaoBiblioteca;
import web.dao.DaoCliente;
import web.model.Biblioteca;
import web.model.Cliente;
import web.model.Libro;
import web.model.Nacionalidad;
import web.service.FuncionesSeparadasService;

@Service("FuncionesService")
public class FuncionesSeparadasServiceImpl implements FuncionesSeparadasService {
	
	private DaoNacionalidad daoNacionalidad;
	private DaoLibro daoLibro;
	private DaoBiblioteca daoBiblioteca;
	private DaoCliente daoCliente;
	
	@Override
	public ArrayList<Nacionalidad> ListarNacionalidades() {
		return (ArrayList<Nacionalidad>)daoNacionalidad.listarNacionalidades();
	}
	
	@Override
	public Nacionalidad obtenerNacionalidad(int n) {
		return daoNacionalidad.obtenerNacionalidad(n);
	}

	@Override
	public ArrayList<Libro> ListarLibros() {
		return (ArrayList<Libro>)daoLibro.listarLibros();
	}

	@Override
	public Libro obtenerLibro(int n) {
		return daoLibro.obtenerLibro(n);
	}
	
	@Override
	public Biblioteca obtenerBiblioteca(int n) {
		return daoBiblioteca.obtenerBibliotecaByID(n);
	}

	@Override
	public Cliente obtenerCliente(int n) {
		return daoCliente.obtenerClienteByID(n);
	}
	
}
