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
	
	@RequestMapping("addBiblioteca.html")
	public String agregarBiblioteca(String id, String libro, String fechaAlta, String esta) {
		 ModelAndView mv = new ModelAndView();
		 
		 if(esta.equals("1")) {
			 esta = "Biblioteca";
		 }else{
			 esta = "Prestado";
		 }
		 
		try {
			boolean estado = bibliotecaService.agregarBiblioteca( libro, fechaAlta, esta);
			
			if(estado) {
				mv.addObject("msg","Biblioteca agregada con exito");
				return "redirect:/Biblioteca.html";
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
	public ModelAndView eliminarBiblioteca(@RequestParam(value = "id", required = false) int idBiblioteca){
		ModelAndView mv = new ModelAndView();
		
		try {
			Biblioteca biblioteca = bibliotecaService.obtenerBiblioteca(idBiblioteca);
			
			if(bibliotecaService.eliminarBiblioteca(biblioteca)) {
				mv.addObject("msg","biblioteca eliminado con exito");
				mv.setViewName("eliminarBiblioteca");
			}
				
			  	
			else
				mv.addObject("msg","La biblioteca no se pudo eliminar");
		}
		catch(Exception e) {
			mv.addObject("msg","exception");
		}
		
		return mv;
	}
	
	@RequestMapping("modificarBiblioteca.html")
	public String modificarBiblioteca(@ModelAttribute("biblioteca") Biblioteca biblioteca, String id, String libro, String fechaAlta, String esta) {
		
		ModelAndView mv = new ModelAndView();
		
		try {
			// Revisar-------------------------------
			boolean estado = bibliotecaService.modificarBiblioteca(Integer.parseInt(id), libro, fechaAlta, esta);
			if(estado) {

				mv.addObject("msg","Biblioteca actualizada con exito");
				
			} 
			else
				mv.addObject("msg","a ocurrido un error");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Biblioteca> list = bibliotecaService.listarBibliotecas();
		if (list.size() > 0)
			mv.addObject("bibliotecaList", list);
		
		List<Libro> listLibro = libroService.listarLibros();
		if (listLibro.size() > 0)
			mv.addObject("libroList", listLibro);
		//REvisar-------------------------
		return "bibliotecas";
	}
	
	
}
