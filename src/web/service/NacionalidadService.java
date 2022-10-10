package web.service;

import java.util.ArrayList;
import java.util.List;

import web.model.Nacionalidad;

public interface NacionalidadService {
	
	public boolean AgregarNacionalidad(Nacionalidad nacionalidad);

	List<Nacionalidad> listarNacionalidades();

	Nacionalidad obtenerNacionalidad(int id);
	
}
