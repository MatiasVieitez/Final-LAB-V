package web.daoImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.dao.DaoBiblioteca;
import web.model.Biblioteca;

@Repository("DaoBibliotecaImpl")
public class DaoBibliotecaImpl implements DaoBiblioteca {

	@Autowired
	private Conexion conexion;
	
	@Override
	public List<Biblioteca> listarBibliotecas() {
		conexion.abrirConexion();

		@SuppressWarnings("unchecked")
		List<Biblioteca> biblioteca = (List<Biblioteca>) conexion.getSession()
				.createQuery("FROM Biblioteca a ORDER BY id_cliente asc").list();

		conexion.cerrarSession();

		return biblioteca;
	}

	@Override
	public boolean agregarBiblioteca(Biblioteca biblioteca) {
		conexion.abrirConexion();

		Boolean status = true;

		try {
			conexion.IniciarTransaccion();
			conexion.GuardarObjeto(biblioteca);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			e.getCause();
			conexion.RollbackearTransaccion();
			status = false;
		}

		conexion.cerrarSession();
		return status;
	}

	@Override
	public boolean modificarBiblioteca(Biblioteca biblioteca) {
		conexion.abrirConexion();
		boolean status = true;
		try {
			conexion.IniciarTransaccion();
			conexion.ActualizarObjeto(biblioteca);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			status = false;
		}
		conexion.cerrarSession();
		return status;
	}

	@Override
	public boolean eliminarBiblioteca(Biblioteca biblioteca) {
		conexion.abrirConexion();
		Boolean status = true;

		try {
			conexion.IniciarTransaccion();
			conexion.BorrarObjeto(biblioteca);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			e.getCause();
			conexion.RollbackearTransaccion();
			status = false;
		}

		conexion.cerrarSession();
		return status;
	}

	@Override
	public Biblioteca obtenerBibliotecaByID(int idBiblioteca) {
		conexion.abrirConexion();
		
		Biblioteca biblioteca;
		
		try {
			biblioteca = (Biblioteca)conexion.ObtenerObjeto(Biblioteca.class, idBiblioteca);
		}
		catch(Exception e){
			e.getCause();
			biblioteca = null;
		}
		conexion.cerrarSession();
		return biblioteca;
	}

}
