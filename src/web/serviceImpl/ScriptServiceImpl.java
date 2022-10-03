package web.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.DaoNacionalidad;
import web.dao.DaoUsuario;
import web.model.Nacionalidad;
import web.model.UsuarioModel;

@Service("Script")
public class ScriptServiceImpl {

	@Autowired
	DaoUsuario daoUsuario;
	UsuarioModel usuario;
	DaoNacionalidad daoNacionalidad;
	
	
	public void script() throws Exception {
		
			GenerarDatos();
	}
	
	
	private void GenerarDatos() {
		
		//cargarUsuarios();
		//GenerarNacionalidades();
		
	}
	
	private void cargarUsuarios() {
		usuario = new UsuarioModel("admin","admin123");
		
		daoUsuario.agregarUsuario(usuario);
	}
	
	List<Nacionalidad> GenerarNacionalidades(){
		ArrayList<Nacionalidad> aux = new ArrayList<Nacionalidad>();
		Nacionalidad nacionalidad = new Nacionalidad("Argentina");
		aux.add(nacionalidad);
		daoNacionalidad.agregarNacionalidad(nacionalidad);

//		nacionalidad = new Nacionalidad("Venezuela");
//		aux.add(nacionalidad);
//
//		nacionalidad = new Nacionalidad("Bolivia");
//		aux.add(nacionalidad);
//
//		nacionalidad = new Nacionalidad("Chile");
//		aux.add(nacionalidad);
//
//		nacionalidad = new Nacionalidad("Uruguay");
//		aux.add(nacionalidad);
//
//		nacionalidad = new Nacionalidad("Brasil");
//		aux.add(nacionalidad);

		
//         System.out.println("antes del for: " + nacionalidad);
//		for (Nacionalidad n : aux) {
//			System.out.println("dentro del for antes de guardar: " + n);
//			daoNacionalidad.agregarNacionalidad(n);
//			System.out.println("dentro del for luego de guardar: " + n);
//			
//		}
			

		return aux;
	}
}
