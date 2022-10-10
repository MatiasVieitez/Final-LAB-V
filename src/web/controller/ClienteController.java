package web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import web.model.Cliente;
import web.model.Nacionalidad;
import web.service.ClienteService;
import web.service.NacionalidadService;
import web.serviceImpl.ClienteServiceImpl;

@Controller
public class ClienteController {
	
	
	@Autowired
	@Qualifier("ClienteServiceImpl")
	ClienteService clienteService;

	@Autowired
	@Qualifier("NacionalidadServiceImpl")
	private NacionalidadService nacionalidadService;
	
	@RequestMapping("addCliente.html")
	public String agregarCliente(String dni, String nombre, String apellido, String sexo, String nacionalidad,
	String fNacimiento, String localidad, String direccion, String correo, String telefono) {
		 ModelAndView mv = new ModelAndView();
		try {
			boolean estado = clienteService.agregarCliente(dni, nombre, apellido, sexo, Integer.parseInt(nacionalidad), fNacimiento, localidad, direccion, correo,telefono);
			
			if(estado) {
				mv.addObject("msg","cliente agregado con exito");
				return "redirect:/clientes.html";
			}
				
		
			else
				return "Algo salio mal...";
		} catch (Exception e) {
			e.getCause();
			return "Exception";
		}
		
	}
	
	@RequestMapping("listarClienteFiltro.html")
	@ResponseBody
	public ModelAndView ListarTodosClientesFiltro(String nacionalidad,String nombre, String apellido) {
		ModelAndView mv = new ModelAndView();
		
		try {
			mv.addObject("clientesList",clienteService.listarClienteTabla(nacionalidad, nombre, apellido));
			mv.setViewName("clientes");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mv;
	}
	
	@RequestMapping("eliminarCliente.html")
	public ModelAndView eliminarCliente(@RequestParam(value = "id", required = false) int idCliente){
		ModelAndView mv = new ModelAndView();
		
		try {
			Cliente cliente = clienteService.obtenerCliente(idCliente);
			
			if(clienteService.eliminarCliente(cliente)) {
				mv.addObject("msg","cliente eliminado con exito");
				mv.setViewName("eliminarCliente");
			}
				
			  	
			else
				mv.addObject("msg","El cliente no a podido ser eliminado");
		}
		catch(Exception e) {
			mv.addObject("msg","exception");
		}
		
		return mv;
	}
	
	@RequestMapping("modificarCliente.html")
	public String modificarCliente(@ModelAttribute("cliente") Cliente cliente, String id, String dni, String nombre, String apellido, String sexo, String nacionalidad,
			String fNacimiento, String localidad, String direccion, String correo, String telefono) {
		
		ModelAndView mv = new ModelAndView();
		
		try {
			boolean estado = clienteService.modificarCliente(Integer.parseInt(id), Integer.parseInt(dni), nombre, apellido, sexo, Integer.parseInt(nacionalidad), fNacimiento, localidad, direccion, correo, telefono);
			if(estado) {

				mv.addObject("msg","usuario actualizado con exito");
				
			} 
			else
				mv.addObject("msg","a ocurrido un error");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Cliente> list = clienteService.listarClientes();
		if (list.size() > 0)
			mv.addObject("clientesList", list);
		
		List<Nacionalidad> listNacionalidades = nacionalidadService.listarNacionalidades();
		if (listNacionalidades.size() > 0)
			mv.addObject("nacionalidadesList", listNacionalidades);
		
		return "clientes";
	}
	
	
}
