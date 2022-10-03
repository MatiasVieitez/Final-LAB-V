package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import web.serviceImpl.ClienteServiceImpl;

@Controller
public class ClienteController {
	
	ClienteServiceImpl clienteService;

	
	@RequestMapping("addClient.html")
	public String agregarCliente(String dni, String nombre, String apellido, String sexo, String nacionalidad,
	String fNacimiento, String localidad, String direccion, String correo, String telefono) {
		
		try {
			boolean estado = clienteService.agregarCliente(dni, nombre, apellido, sexo, Integer.parseInt(nacionalidad), fNacimiento, localidad, direccion, correo,telefono);
			
			if(estado)
				return "redirect:/clientes.html";
			else
				return "Algo salio mal...";
		} catch (Exception e) {
			e.getCause();
			return "Exception";
		}
		
	}
//	
}
