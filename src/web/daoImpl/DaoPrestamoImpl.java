package web.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.dao.DaoPrestamo;
import web.model.Prestamo;

@Repository("DaoPrestamoImpl")
public class DaoPrestamoImpl implements DaoPrestamo{

	@Autowired
	private Conexion conexion;

	@Override
	public List<Prestamo> listarPrestamos() {

		conexion.abrirConexion();

		@SuppressWarnings("unchecked")
		List<Prestamo> prests = (List<Prestamo>) conexion.getSession()
				.createQuery("FROM Prestamo a ORDER BY id_cliente asc").list();

		conexion.cerrarSession();

		return prests;
	}

	@Override
	public boolean agregarPrestamo(Prestamo prestamo) {
		conexion.abrirConexion();

		Boolean status = true;

		try {
			conexion.IniciarTransaccion();
			conexion.GuardarObjeto(prestamo);
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
	public boolean modificarPrestamo(Prestamo prestamo) {
		conexion.abrirConexion();
		boolean status = true;
		try {
			conexion.IniciarTransaccion();
			conexion.ActualizarObjeto(prestamo);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			status = false;
		}
		conexion.cerrarSession();
		return status;
	}

	@Override
	public Prestamo obtenerPrestamoByID(int idPrestamo) {
		conexion.abrirConexion();
		
		Prestamo prestamo;
		
		try {
			prestamo = (Prestamo)conexion.ObtenerObjeto(Prestamo.class, idPrestamo);
		}
		catch(Exception e){
			e.getCause();
			prestamo = null;
		}
		conexion.cerrarSession();
		return prestamo;
		
	}
	
	@Override
    public boolean eliminarPrestamo(Prestamo p){
        conexion.abrirConexion();
        boolean exito = true;
        try {
            conexion.IniciarTransaccion();
            conexion.BorrarObjeto(p);
            conexion.CommitTransaccion();
        } catch (Exception e) {
            conexion.RollbackearTransaccion();
            exito = false;
        }
        conexion.cerrarSession();
        return exito;
    }
	
}
