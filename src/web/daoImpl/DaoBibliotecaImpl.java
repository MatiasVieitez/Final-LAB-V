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
				.createQuery("FROM Biblioteca a ORDER BY id_biblioteca asc").list();

		conexion.cerrarSession();

		return biblioteca;
	}
	
	@Override
    public List<Biblioteca> listarBibliotecasEstado() {
        conexion.abrirConexion();

        @SuppressWarnings("unchecked")
        List<Biblioteca> biblioteca = (List<Biblioteca>) conexion.getSession()
                .createQuery("FROM Biblioteca where estado = 'En Biblioteca'").list();

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
		
		Biblioteca biblioteca = new Biblioteca();
		
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

	@Override
	public List<Object[]> listarBibliotecaTabla(String Libro, String estado) {
		String query = "";
		int cantCondiciones = 0;


		if (Libro.length() > 0) {
			if (cantCondiciones == 0) {
				query = " WHERE b.id_libro = '" + Libro + "'";
				cantCondiciones++;
			} else
				query += " AND b.id_libro = '" + Libro + "'";
		}

		if (estado.length() > 0) {
			if (cantCondiciones == 0) {
				query = " WHERE b.estado = '" + estado + "'";
				cantCondiciones++;
			} else
				query += " AND b.estado = '" + estado + "'";
		}

		conexion.abrirConexion();
		List<Object[]> biliotecaList = conexion.ObtenerListaPorQuery(
				"SELECT id_biblioteca as idbiblioteca, b.id_libro as Libro, b.fecha_alta as 'Fecha Alta', b.estado as Estado "
						+ " FROM Biblioteca as b INNER JOIN Libro as l ON b.id_libro = l.id_libro"
						+ query + " order by id_biblioteca;");
		conexion.cerrarSession();

		return biliotecaList;
	}

}
