package web.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import web.dao.DaoPrestamo;
import web.model.Biblioteca;
import web.model.Cliente;
import web.model.Prestamo;
import web.service.BibliotecaService;
import web.service.FuncionesSeparadasService;
import web.service.PrestamoService;

@Service("PrestamoServiceImpl")
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
	private DaoPrestamo daoPrestamo;
    @Autowired
	private Prestamo prestamo;
    @Autowired
    @Qualifier("FuncionesService")
	private FuncionesSeparadasService funciones;
    
    @Autowired
    @Qualifier("BibliotecaServiceImpl")
    private BibliotecaService bibliotecaService;
	
	@Override
	public List<Prestamo> listarPrestamos() {

		List<Prestamo> clientes = daoPrestamo.listarPrestamos();
		return clientes;
	}

	@Override
    public boolean agregarPrestamo(Biblioteca b, Cliente c, int cantidadDias, String fecha) {   
        try {
            b.setEstado("Prestado");
            
            prestamo.setBiblioteca(b);
            prestamo.setCliente(c);
            prestamo.setCantDias(cantidadDias);
            prestamo.setFechaPrestamo(fecha);

            if (daoPrestamo.agregarPrestamo(prestamo))
                    bibliotecaService.modificarBiblioteca(b);      
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }

	@Override
	public boolean modificarPrestamo(int id, String biblioteca, String cliente, String fechaAlta, int cantDias) {
		try {
			Prestamo prestamo = daoPrestamo.obtenerPrestamoByID(id);
				
			int bibliotecaInteger = Integer.parseInt(biblioteca);
			int clienteInteger = Integer.parseInt(cliente);
			
			prestamo.setBiblioteca(funciones.obtenerBiblioteca(bibliotecaInteger));
			prestamo.setCliente(funciones.obtenerCliente(clienteInteger));
			prestamo.setFechaPrestamo(fechaAlta);
			prestamo.setCantDias(cantDias);

			boolean status = daoPrestamo.modificarPrestamo(prestamo);
			return status;
		} catch (Exception e) {
			e.getCause();
			return false;
		}
	}

	@Override
	public Prestamo obtenerPrestamo(int id) {
		return daoPrestamo.obtenerPrestamoByID(id);
	}

	@Override
    public boolean eliminarPrestamo(Prestamo p) {
        return daoPrestamo.eliminarPrestamo(p);
    }   

}
