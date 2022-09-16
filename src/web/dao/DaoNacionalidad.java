package web.dao;

import java.util.List;

import web.model.Nacionalidad;

public interface DaoNacionalidad {
	
	public List<Nacionalidad> listarNacionalidades();
	public boolean agregarNacionalidad(Nacionalidad n);
	public boolean modificarNacionalidad(Nacionalidad n);
	public boolean eliminarNacionalidad(Nacionalidad n);
	public Nacionalidad obtenerNacionalidad(int idNacionalidad);
	
}
