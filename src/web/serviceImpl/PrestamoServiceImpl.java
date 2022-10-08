package web.serviceImpl;

import java.util.List;
import java.text.SimpleDateFormat;

import web.dao.DaoPrestamo;
import web.model.Prestamo;
import web.service.FuncionesSeparadasService;
import web.service.PrestamoService;

public class PrestamoServiceImpl implements PrestamoService {

	private DaoPrestamo daoPrestamo;
	private Prestamo prestamo;
	private FuncionesSeparadasService funciones;
	
	@Override
	public List<Prestamo> listarPrestamos() {

		List<Prestamo> clientes = daoPrestamo.listarPrestamos();
		return clientes;
	}

	@Override
	public boolean agregarPrestamo(String biblioteca, String cliente, String fechaAlta, int cantDias) {
			try {
				
				int bibliotecaInteger = Integer.parseInt(biblioteca);
				int clienteInteger = Integer.parseInt(cliente);
				
				prestamo.setBiblioteca(funciones.obtenerBiblioteca(bibliotecaInteger));
				prestamo.setCliente(funciones.obtenerCliente(clienteInteger));
				prestamo.setFechaPrestamo(new SimpleDateFormat("yyyy-MM-dd").parse(fechaAlta));
				prestamo.setCantDias(cantDias);

				return daoPrestamo.agregarPrestamo(prestamo);

			} catch (Exception e) {

				e.getCause();
				return false;
			}
	}

	@Override
	public boolean modificarPrestamo(int id, String biblioteca, String cliente, String fechaAlta, int cantDias) {
		try {
			Prestamo prestamo = daoPrestamo.obtenerPrestamoByID(id);
				
			int bibliotecaInteger = Integer.parseInt(biblioteca);
			int clienteInteger = Integer.parseInt(cliente);
			
			prestamo.setBiblioteca(funciones.obtenerBiblioteca(bibliotecaInteger));
			prestamo.setCliente(funciones.obtenerCliente(clienteInteger));
			prestamo.setFechaPrestamo(new SimpleDateFormat("yyyy-MM-dd").parse(fechaAlta));
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

}
