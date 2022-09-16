package web.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.dao.DaoUsuario;
import web.model.UsuarioModel;

@Repository("daoUsuario")
public class DaoUsuarioImpl implements DaoUsuario {

	@Autowired
	private Conexion conexion;
	private UsuarioModel usuario;

	@Override
	public UsuarioModel obtenerUsuario(int id) {
		conexion.abrirConexion();
		
		try {
			usuario = (UsuarioModel)conexion.ObtenerObjeto(UsuarioModel.class, id);
		} catch (Exception e) {
			usuario = null;
		}
		conexion.cerrarSession();
		return usuario;
	}

	@Override
	public Boolean agregarUsuario(UsuarioModel usuario) {
		conexion.abrirConexion();
		boolean exito = true;
		try {
			conexion.IniciarTransaccion();
			conexion.GuardarObjeto(usuario);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			exito = false;
		}
		conexion.cerrarSession();
		return exito;
	}

	@Override
	public UsuarioModel UsuarioConCredenciales(String username, String password) {
		conexion.abrirConexion();
		usuario = (UsuarioModel)conexion.getSession().createQuery("FROM UsuarioModel u WHERE username='" + username + "' AND password='" + password + "'").uniqueResult();
		conexion.cerrarSession();

		return usuario;
	}
}
