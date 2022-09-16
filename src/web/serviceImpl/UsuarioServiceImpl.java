package web.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.DaoUsuario;
import web.model.UsuarioModel;
import web.service.UsuarioService;

@Service("servicioUsuario")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private DaoUsuario daoUsuario;
	
	@Override
	public UsuarioModel obtenerUsuario(int id) {
		return daoUsuario.obtenerUsuario(id);
	}

	@Override
	public Boolean agregarUsuario(UsuarioModel user) {
		return daoUsuario.agregarUsuario(user);
	}

	@Override
	public UsuarioModel usuarioCredenciales(String username, String password) {
		return daoUsuario.UsuarioConCredenciales(username, password);
	}

}
