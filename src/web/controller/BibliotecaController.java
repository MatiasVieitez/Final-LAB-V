package web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import web.model.Biblioteca;
import web.model.Cliente;
import web.model.Libro;
import web.service.BibliotecaService;
import web.service.LibroService;

@Controller
public class BibliotecaController {
	@Autowired
	@Qualifier("BibliotecaServiceImpl")
	BibliotecaService bibliotecaService;

	@Autowired
	@Qualifier("LibroServiceImpl")
	private LibroService libroService;
	
	@ModelAttribute("biblioteca")
    public Biblioteca getBiblioteca() {
        return new Biblioteca();
    }
	
	@RequestMapping("addBiblioteca.html")
	public String agregarBiblioteca(String libro, String fechaAlta, String esta) {
		 ModelAndView mv = new ModelAndView();
		 
		try {
			boolean estado = bibliotecaService.agregarBiblioteca( libro, fechaAlta, esta);
			
			if(estado) {
				mv.addObject("msg","Biblioteca agregada con exito");
				return "redirect:/biblioteca.html";
			}
				
		
			else
				return "Algo salio mal...";
		} catch (Exception e) {
			e.getCause();
			return "Exception";
		}
		
	}
	
	@RequestMapping("listarBibliotecaFiltro.html")
	@ResponseBody
	public ModelAndView ListarTodasBibliotecaFiltro(String id, String libro, String esta) {
		ModelAndView mv = new ModelAndView();
		
		try {
			mv.addObject("bibliotecaList",bibliotecaService.listarBibliotecaTabla( libro, esta));
			mv.setViewName("clientes");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mv;
	}
	
	@RequestMapping("eliminarBiblioteca.html")
	public String eliminarBiblioteca(@RequestParam(value = "id", required = false) int idBiblioteca){
		ModelAndView mv = new ModelAndView();
		
		try {
			Biblioteca biblioteca = bibliotecaService.obtenerBiblioteca(idBiblioteca);
			
			bibliotecaService.eliminarBiblioteca(biblioteca);			
			mv.addObject("msg","biblioteca eliminado con exito");
			return "redirect:/biblioteca.html";
				  			
		}
		catch(Exception e) {
			mv.addObject("msg","exception");
			return "exception";
		}
		
	}
	
	@RequestMapping("modificarBiblioteca.html")
    public String modificarBiblioteca(@ModelAttribute("biblioteca") Biblioteca biblioteca, int id, String esta, String fechaAlta) {
        ModelAndView mv = new ModelAndView();

        try {
            boolean est = bibliotecaService.modificarBiblioteca(id, fechaAlta, esta);
            if(est) {
                mv.addObject("msg","biblioteca actualizada con exito");
                return "redirect:/biblioteca.html";
            }
               
            else {
                mv.addObject("msg","ocurrio un error");
                return "algo salio mal";
            }
                
            
        }catch(Exception e) {
            e.printStackTrace();
            return "exception";
        }

    }
	
	
}
