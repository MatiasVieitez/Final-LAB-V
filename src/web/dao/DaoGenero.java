package web.dao;

import java.util.List;

import web.model.Genero;

public interface DaoGenero {
    public List<Genero> listarGeneros();
    public boolean agregarGenero(Genero g);
    public boolean modificarGenero(Genero g);
    public boolean eliminarGenero(Genero g);
    public Genero obtenerGenero(int idGenero);
}
