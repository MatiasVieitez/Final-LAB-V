package web.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.dao.DaoNacionalidad;
import web.model.Nacionalidad;

@Repository("DaoNacionalidadImpl")
public class DaoNacionalidadImpl implements DaoNacionalidad {

	@Autowired
	private Conexion conexion;
	private Nacionalidad nacionalidad;

	@Override
	public List<Nacionalidad> listarNacionalidades() {
		conexion.abrirConexion();
		@SuppressWarnings("unchecked")
		List<Nacionalidad> listaNacionalidades= (List<Nacionalidad>)conexion.getSession().createQuery("FROM Nacionalidad").list();
		System.out.println("LISTA DE NACIONALIDADES cantiadad de items: " + listaNacionalidades.size());
		conexion.cerrarSession();

		return listaNacionalidades;
	}

	@Override
	public boolean agregarNacionalidad(Nacionalidad nacionalidad) {
		conexion.abrirConexion();
		boolean exito = true;
		try {
			conexion.IniciarTransaccion();
			conexion.GuardarObjeto(nacionalidad);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			exito = false;
		}
		conexion.cerrarSession();
		return exito;
	}

	@Override
	public boolean modificarNacionalidad(Nacionalidad nacionalidad) {
		conexion.abrirConexion();
		boolean exito = true;
		try {
			conexion.IniciarTransaccion();
			conexion.ActualizarObjeto(nacionalidad);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			exito = false;
		}
		conexion.cerrarSession();
		return exito;
	}

	@Override
	public boolean eliminarNacionalidad(Nacionalidad nacionalidad) {
		conexion.abrirConexion();
		boolean exito = true;
		try {
			conexion.IniciarTransaccion();
			conexion.BorrarObjeto(nacionalidad);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			exito = false;
		}
		conexion.cerrarSession();
		return exito;
	}

	@Override
	public Nacionalidad obtenerNacionalidad(int idNacionalidad) {
		conexion.abrirConexion();
		Nacionalidad n = new Nacionalidad();
		try {
			n = (Nacionalidad)conexion.ObtenerObjeto(Nacionalidad.class, idNacionalidad);
		} catch (Exception e) {
			n = null;
		}
		conexion.cerrarSession();
		return n;
	}

}
