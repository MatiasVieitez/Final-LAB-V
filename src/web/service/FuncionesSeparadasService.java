package web.service;

import java.util.ArrayList;

import web.model.Nacionalidad;

public interface FuncionesSeparadasService {

  ArrayList<Nacionalidad> ListarNacionalidades();
  Nacionalidad obtenerNacionalidad(int n); 
}
