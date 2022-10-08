package web.serviceImpl;

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
	
	
	
}
