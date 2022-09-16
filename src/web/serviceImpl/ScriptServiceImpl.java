package web.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.DaoUsuario;
import web.model.UsuarioModel;

@Service("Script")
public class ScriptServiceImpl {

	@Autowired
	DaoUsuario daoUsuario;
	UsuarioModel usuario;
	
	
	public void script() throws Exception {
		
			GenerarDatos();
	}
	
	
	private void GenerarDatos() {
		
		//cargarUsuarios();
		
	}
	
	private void cargarUsuarios() {
		usuario = new UsuarioModel("admin","admin123");
		
		daoUsuario.agregarUsuario(usuario);
	}
	
	
}
