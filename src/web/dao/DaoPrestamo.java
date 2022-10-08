package web.dao;

import java.util.List;

import web.model.Prestamo;

public interface DaoPrestamo {
		
		public List<Prestamo> listarPrestamos();
		public boolean agregarPrestamo(Prestamo prestamo);
		public boolean modificarPrestamo(Prestamo prestamo);
		public Prestamo obtenerPrestamoByID(int idPrestamo);
		//public List<Object[]> listarPrestamo(String nacionalidad, String nombre, String apellido);
	
}
