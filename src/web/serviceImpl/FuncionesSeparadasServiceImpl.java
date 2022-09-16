package web.serviceImpl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import web.dao.DaoNacionalidad;
import web.model.Nacionalidad;
import web.service.FuncionesSeparadasService;

@Service("FuncionesService")
public class FuncionesSeparadasServiceImpl implements FuncionesSeparadasService {
	
	private DaoNacionalidad daoNacionalidad;
	
	@Override
	public ArrayList<Nacionalidad> ListarNacionalidades() {
		return (ArrayList<Nacionalidad>)daoNacionalidad.listarNacionalidades();
	}
	
	@Override
	public Nacionalidad obtenerNacionalidad(int n) {
		return daoNacionalidad.obtenerNacionalidad(n);
	}

	
}
