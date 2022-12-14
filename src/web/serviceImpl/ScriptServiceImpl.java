package web.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.DaoNacionalidad;
import web.dao.DaoUsuario;
import web.model.Nacionalidad;
import web.model.UsuarioModel;
import web.service.NacionalidadService;

@Service("Script")
public class ScriptServiceImpl {

	@Autowired
	DaoUsuario daoUsuario;
	
	@Autowired
	UsuarioModel usuario;
	
	@Autowired
	Nacionalidad nacionalidad;
	
	@Autowired
	NacionalidadServiceImpl nacionalidadService;
	
	@Autowired
	DaoNacionalidad daoNacionalidad;
	
	//private boolean existingData = false;
	
	
	public void script() throws Exception {
		
	  GenerarDatos();
	}
	
	
	private void GenerarDatos() {
		
		cargarUsuarios();
		GenerarNacionalidades();
		
	}
	
	private void cargarUsuarios() {
		usuario = new UsuarioModel("admin","admin123");
		
		daoUsuario.agregarUsuario(usuario);
	}
	
	private void GenerarNacionalidades(){
		
		try {
			nacionalidad = new Nacionalidad("Argentina");
			daoNacionalidad.agregarNacionalidad(nacionalidad);
			
			nacionalidad = new Nacionalidad("Uruguay");
			daoNacionalidad.agregarNacionalidad(nacionalidad);
			
			nacionalidad = new Nacionalidad("Brasil");
			daoNacionalidad.agregarNacionalidad(nacionalidad);
			
			nacionalidad = new Nacionalidad("Paraguay");
			daoNacionalidad.agregarNacionalidad(nacionalidad);
			
			nacionalidad = new Nacionalidad("Chile");
			daoNacionalidad.agregarNacionalidad(nacionalidad);
			
			nacionalidad = new Nacionalidad("Peru");
			daoNacionalidad.agregarNacionalidad(nacionalidad);
			
			nacionalidad = new Nacionalidad("Venezuela");
			daoNacionalidad.agregarNacionalidad(nacionalidad);
			
			nacionalidad = new Nacionalidad("Colombia");
			daoNacionalidad.agregarNacionalidad(nacionalidad);
			
			nacionalidad = new Nacionalidad("Ecuador");
			daoNacionalidad.agregarNacionalidad(nacionalidad);
			
			nacionalidad = new Nacionalidad("Bolivia");
			daoNacionalidad.agregarNacionalidad(nacionalidad);
			
		}
		catch(Exception e) {
			e.getCause();
			e.printStackTrace();
		}
		
		
	}
}
