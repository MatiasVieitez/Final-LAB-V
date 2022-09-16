package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import web.model.UsuarioModel;
import web.serviceImpl.ScriptServiceImpl;
import web.serviceImpl.UsuarioServiceImpl;

@Controller
@SessionAttributes({"usuario"})
public class PaginaController {

	@Autowired
	@Qualifier("servicioUsuario")
	private UsuarioServiceImpl userServiceImpl;
	
	@Autowired
	@Qualifier("Script")
	private ScriptServiceImpl scriptServiceImpl;
	
	@ModelAttribute("usuario")
	public UsuarioModel getUsername() {
		return new UsuarioModel();
	}
	
	@RequestMapping("index.html")
	public String Login(SessionStatus status, ModelMap map, @ModelAttribute("usuario") UsuarioModel u,String username, String password)	{		
		String redirect = "";
		try {
			scriptServiceImpl.script();
			UsuarioModel usuario = userServiceImpl.usuarioCredenciales(username, password);
		
			if (usuario.getId() != 0)
			{
			    System.out.println("antes de redireccionar");
				redirect = "redirect:/biblioteca.html";
				u = usuario;
				map.put("usuario", u);
			}	
		} catch (Exception e) {
			e.getCause();
			e.printStackTrace();
			redirect = "redirect:/loginFailed.html";	
		}
		return redirect;
	}
	
	@RequestMapping("loginFailed.html")
	public ModelAndView LoginFailed()	{		
		ModelAndView mv = new ModelAndView();
		mv.addObject("loginFailed","Usuario o contrasenia invalida");
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/biblioteca.html")
	public ModelAndView ListadoBiblioteca() {		
		ModelAndView mv = new ModelAndView();
		
//		try {
			//mv.addObject("bibliotecas",iNegBiblioteca.listarBibliotecasTabla("","","",""));
			mv.setViewName("biblioteca");
//		} catch (Exception e) {
//			mv = AvisoController.SeteoDeAviso(mv, "Listado Biblioteca", "Carga de Listado Biblioteca", e.toString(), 
//					"Volver al Login", "cerrarSesion.html", AvisoController.TipoAviso.Error);
//		}

		return mv;
	}
	
	@RequestMapping("/clientes.html")
	public ModelAndView listadoClientes() {		
		ModelAndView mv = new ModelAndView();
		
			mv.setViewName("clientes");

		return mv;
	}
	
	
	@RequestMapping("/altaCliente.html")
	public ModelAndView altaCliente() {		
		ModelAndView mv = new ModelAndView();
		
			mv.setViewName("altaCliente");

		return mv;
	}
	
	@RequestMapping("cerrarSesion.html")
	public ModelAndView CerrarSesion(SessionStatus status) {
		status.setComplete();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
}
