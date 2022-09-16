package web.dao;

import web.model.UsuarioModel;

public interface DaoUsuario {
	
	public UsuarioModel obtenerUsuario(int id);
	public Boolean agregarUsuario(UsuarioModel u);
	public UsuarioModel UsuarioConCredenciales(String username, String password);
}
 