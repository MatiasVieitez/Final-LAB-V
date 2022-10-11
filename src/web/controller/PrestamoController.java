package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import web.model.Biblioteca;
import web.model.Cliente;
import web.model.Prestamo;
import web.service.BibliotecaService;
import web.service.ClienteService;
import web.service.PrestamoService;

@Controller
public class PrestamoController {
    
    @Autowired
    @Qualifier("BibliotecaServiceImpl")
    private BibliotecaService bibliotecaService;
    
    @Autowired
    @Qualifier("ClienteServiceImpl")
    private ClienteService clienteService;
    
    @Autowired
    @Qualifier("PrestamoServiceImpl")
    private PrestamoService prestamoService;

		@RequestMapping("addPrestamo.html")
		public String agregarPrestamo(String Cliente, String Biblioteca, String fechaAlta, int CantDias) {
		    ModelAndView mv = new ModelAndView();
		    try {
	            Cliente cliente = clienteService.obtenerCliente(Integer.parseInt(Cliente));
	            Biblioteca biblioteca = bibliotecaService.obtenerBiblioteca(Integer.parseInt(Biblioteca));
	            boolean estado = prestamoService.agregarPrestamo(biblioteca,cliente,CantDias,fechaAlta);
	            
	            
	            if(estado) {
                    mv.addObject("msg","prestamo agregado con exito");
                    return "redirect:/prestamos.html";
                }
                    
                else
                    return "Algo salio mal...";
            } catch (Exception e) {
                e.getCause();
                return "Exception";
            }
	        
	
		}
		
		@RequestMapping("closePrestamo.html")
	    public String FinalizarPrestamo(int idPrestamo) {
	        try {           
	            Prestamo p = prestamoService.obtenerPrestamo(idPrestamo);
	            prestamoService.eliminarPrestamo(p);
	            Biblioteca b = bibliotecaService.obtenerBiblioteca(p.getBiblioteca().getId());
	            b.setEstado("En Biblioteca");
	            bibliotecaService.modificarBiblioteca(b);
	            return "redirect:/prestamos.html";
	        } catch (Exception e) {
	            return "algo salio mal";
	            
	        }       
	    }
		
}
