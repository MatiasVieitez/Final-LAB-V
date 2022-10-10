package web.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.daoImpl.DaoNacionalidadImpl;
import web.model.Nacionalidad;
import web.service.NacionalidadService;

@Service("NacionalidadServiceImpl")
public class NacionalidadServiceImpl implements NacionalidadService{

	@Autowired
	private DaoNacionalidadImpl daoNacionalidadImpl;

	@Override
	public boolean AgregarNacionalidad(Nacionalidad nacionalidad) {
		return daoNacionalidadImpl.agregarNacionalidad(nacionalidad);
	}
	
	@Override
	public List<Nacionalidad> listarNacionalidades() {
		return daoNacionalidadImpl.listarNacionalidades();
	}
	
	@Override
	public Nacionalidad obtenerNacionalidad(int id) {
		return daoNacionalidadImpl.obtenerNacionalidad(id);
	}
	
}
