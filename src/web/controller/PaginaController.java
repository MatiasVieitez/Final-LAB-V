package web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import web.model.Cliente;
import web.model.Nacionalidad;
import web.model.UsuarioModel;
import web.service.ClienteService;
import web.service.NacionalidadService;
import web.serviceImpl.FuncionesSeparadasServiceImpl;
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
	
	@Autowired
	@Qualifier("FuncionesService")
	private FuncionesSeparadasServiceImpl funciones;
	
	
	@Autowired
	@Qualifier("NacionalidadServiceImpl")
	private NacionalidadService nacionalidadService;
	
	@Autowired
	@Qualifier("ClienteServiceImpl")
	private ClienteService clienteService;
	
	@ModelAttribute("usuario")
	public UsuarioModel getUsername() {
		return new UsuarioModel();
	}
	
	// ---------------------------------------- DISPATCHERS DE LOGIN Y ERRORES ------------------------------------------------
	
	@RequestMapping("index.html")
	public String Login(SessionStatus status, ModelMap map, @ModelAttribute("usuario") UsuarioModel u,String username, String password) throws Exception	{	
		scriptServiceImpl.script();
		String redirect = "";
		try {
			
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
	
	@RequestMapping("cerrarSesion.html")
	public ModelAndView CerrarSesion(SessionStatus status) {
		status.setComplete();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	// ----------------------------- FIN DISPATCHERS DE LOGIN Y ERRORES -------------------------------
	
	// ----------------------------- DISPATCHERS BIBLIOTECA -------------------------------------------
	
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
	
	@RequestMapping("/altaBiblioteca.html")
	public ModelAndView altaBiblioteca() {		
		ModelAndView mv = new ModelAndView();
		
			mv.setViewName("altaBiblioteca");

		return mv;
	}
	
	
	// ----------------------------- FIN DISPATCHERS BIBLIOTECA -------------------------------------------
	
	
	
	// ----------------------------- DISPATCHERS CLIENTE -------------------------------------------
	
	@RequestMapping("/clientes.html")
	public ModelAndView listadoClientes() {		
		ModelAndView mv = new ModelAndView();
		
			//mv.addObject("clientesList", clienteService.listarClienteTabla("","", ""));
		    List<Cliente> list = clienteService.listarClientes();
		    mv.addObject("clientesList",list);
			mv.setViewName("clientes");

		return mv;
	}
	
	@RequestMapping("/altaCliente.html")
	public ModelAndView altaCliente() {		
		ModelAndView mv = new ModelAndView();
		
		try {
			List<Nacionalidad> listNacionalidades = nacionalidadService.listarNacionalidades();
			if (listNacionalidades.size() > 0)
				mv.addObject("nacionalidadesList", listNacionalidades);
			mv.setViewName("altaCliente");
		}
		catch(Exception e) {
			e.getCause();
		}
			
		

		return mv;
	}
	
	
	@RequestMapping("viewEliminarCliente.html")
	public ModelAndView eliminarCliente() {		
		ModelAndView mv = new ModelAndView();
		
			mv.setViewName("viewEliminarCliente");

		return mv;
	}
	
 
	
	// ----------------------------- FIN DISPATCHERS CLIENTE -------------------------------------------
	
	// ----------------------------- DISPATCHERS Prestamos -------------------------------------------
	
		@RequestMapping("/prestamos.html")
		public ModelAndView listadoPrestamos() {		
			ModelAndView mv = new ModelAndView();
			
				mv.setViewName("prestamos");

			return mv;
		}
		
		@RequestMapping("/altaPrestamo.html")
		public ModelAndView altaPrestamo() {		
			ModelAndView mv = new ModelAndView();
			
				mv.setViewName("altaPrestamo");

			return mv;
		}
		
		// ----------------------------- FIN DISPATCHERS Prestamos -------------------------------------------
	
	
}
