package web.service;

import java.util.ArrayList;

import web.model.Nacionalidad;
import web.model.Libro;
import web.model.Biblioteca;
import web.model.Cliente;

public interface FuncionesSeparadasService {

  ArrayList<Nacionalidad> ListarNacionalidades();
  Nacionalidad obtenerNacionalidad(int n); 
  
  ArrayList<Libro> ListarLibros();
  Libro obtenerLibro(int n); 
  
  Biblioteca obtenerBiblioteca(int n);
  Cliente obtenerCliente(int n);
}
