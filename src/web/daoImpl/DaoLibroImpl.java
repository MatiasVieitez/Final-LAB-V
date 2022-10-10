package web.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import web.dao.DaoLibro;
import web.model.Libro;
import web.model.Nacionalidad;

@Repository("DaoLibroImpl")
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

	@Override
	public List<Object[]> listarLibroTabla(String autor, String titulo, String descripcion) {
		String query = "";
		int cantCondiciones = 0;

		if (autor.length() > 0) {
			query = " WHERE n.id_autor = '" + autor + "'";
			cantCondiciones++;
		}

		if (titulo.length() > 0) {
			if (cantCondiciones == 0) {
				query = " WHERE c.titulo = '" + titulo + "'";
				cantCondiciones++;
			} else
				query += " AND c.titulo = '" + titulo + "'";
		}

		if (descripcion.length() > 0) {
			if (cantCondiciones == 0) {
				query = " WHERE c.descripcion = '" + descripcion + "'";
				cantCondiciones++;
			} else
				query += " AND c.descripcion = '" + descripcion + "'";
		}

		conexion.abrirConexion();
		List<Object[]> libroList = conexion.ObtenerListaPorQuery(
				"SELECT id_libro as idLibro, l.titulo as Titulo, l.fecha_lanzamiento as 'Fecha Nacimiento', l.idioma as Idioma, l.cant_paginas as CantPag, l.id_autor as id_autor"
						+ " FROM Libro as l INNER JOIN Autor as a ON l.id_autor = a.id_autor"
						+ query + " order by id_libro;");
		conexion.cerrarSession();
		
		return libroList;
	}

}
