package web.service;

import web.model.UsuarioModel;

public interface UsuarioService {

	public UsuarioModel obtenerUsuario(int id);
	public Boolean agregarUsuario(UsuarioModel user);
	public UsuarioModel usuarioCredenciales(String username, String password);
	
}
