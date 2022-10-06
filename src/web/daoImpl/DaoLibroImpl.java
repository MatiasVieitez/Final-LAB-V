package web.daoImpl;

import java.util.List;

import web.dao.DaoLibro;
import web.model.Libro;
import web.model.Nacionalidad;

public class DaoLibroImpl implements DaoLibro{

	private Conexion conexion;
	
	@Override
	public List<Libro> listarLibros() {
		conexion.abrirConexion();
		@SuppressWarnings("unchecked")
		List<Libro> listaLibro = (List<Libro>)conexion.getSession().createQuery("FROM Libro n ORDER BY id_libro").list();
		conexion.cerrarSession();

		return listaLibro;
	}

	@Override
	public boolean agregarLibro(Libro libro) {
		conexion.abrirConexion();
		boolean exito = true;
		try {
			conexion.IniciarTransaccion();
			conexion.GuardarObjeto(libro);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			exito = false;
		}
		conexion.cerrarSession();
		return exito;
	}

	@Override
	public boolean modificarLibro(Libro libro) {
		conexion.abrirConexion();
		boolean exito = true;
		try {
			conexion.IniciarTransaccion();
			conexion.ActualizarObjeto(libro);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			exito = false;
		}
		conexion.cerrarSession();
		return exito;
	}

	@Override
	public boolean eliminarLibro(Libro libro) {
		conexion.abrirConexion();
		boolean exito = true;
		try {
			conexion.IniciarTransaccion();
			conexion.BorrarObjeto(libro);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			exito = false;
		}
		conexion.cerrarSession();
		return exito;
	}

	@Override
	public Libro obtenerLibro(int idLibro) {
		conexion.abrirConexion();
		Libro n = new Libro();
		try {
			n = (Libro)conexion.ObtenerObjeto(Libro.class, idLibro);
		} catch (Exception e) {
			n = null;
		}
		conexion.cerrarSession();
		return n;
	}

}
