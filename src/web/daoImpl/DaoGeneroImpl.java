package web.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.dao.DaoGenero;
import web.model.Genero;


@Repository("DaoGeneroImpl")
public class DaoGeneroImpl implements DaoGenero {

    @Autowired
    private Conexion conexion;
    
    @Override
    public List<Genero> listarGeneros() {
        conexion.abrirConexion();
        List<Genero> listaGeneros= (List<Genero>)conexion.getSession().createQuery("FROM Genero g ORDER BY id_genero asc").list();
        conexion.cerrarSession();

        return listaGeneros;
    }

    @Override
    public boolean agregarGenero(Genero g) {
        conexion.abrirConexion();
        boolean exito = true;
        try {
            conexion.IniciarTransaccion();
            conexion.GuardarObjeto(g);
            conexion.CommitTransaccion();
        } catch (Exception e) {
            conexion.RollbackearTransaccion();
            exito = false;
        }
        conexion.cerrarSession();
        return exito;
    }

    @Override
    public boolean modificarGenero(Genero g) {
        conexion.abrirConexion();
        boolean exito = true;
        try {
            conexion.IniciarTransaccion();
            conexion.ActualizarObjeto(g);
            conexion.CommitTransaccion();
        } catch (Exception e) {
            conexion.RollbackearTransaccion();
            exito = false;
        }
        conexion.cerrarSession();
        return exito;
    }

    @Override
    public boolean eliminarGenero(Genero g) {
        conexion.abrirConexion();
        boolean exito = true;
        try {
            conexion.IniciarTransaccion();
            conexion.BorrarObjeto(g);
            conexion.CommitTransaccion();
        } catch (Exception e) {
            conexion.RollbackearTransaccion();
            exito = false;
        }
        conexion.cerrarSession();
        return exito;
    }

    @Override
    public Genero obtenerGenero(int idGenero) {
        conexion.abrirConexion();
        Genero g = new Genero();
        try {
            g = (Genero)conexion.ObtenerObjeto(Genero.class, idGenero);
        } catch (Exception e) {
            g = null;
        }
        conexion.cerrarSession();
        return g;
    }

}
