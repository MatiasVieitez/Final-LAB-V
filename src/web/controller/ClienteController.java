package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClienteController {

	
	@RequestMapping("agregarCliente.html")
	public String agregarCliente(String dni, String nombre, String apellido, String sexo, String nacionalidad,
	String fNacimiento, String localidad, String direccion, String correo, String telefono) {
		
		String redirect = "";
		System.out.println("antes de ir a alta cliente");
		return redirect;
		
//		try {
//			boolean estado = iNegCliente.agregarCliente(dni, nombre, apellido, sexo, Integer.parseInt(nacionalidad), fNacimiento, localidad, direccion, correo,telefono);
//			
//			if(estado)
//				return "redirect:/listadoClientes.html";
//			else
//				return "redirect:/avisoError.html?tituloPagina="+"Agregar Cliente"+"&tituloMensaje="+"Agregar Cliente"+"&mensaje=Error al Agregar Cliente"
//				+"&mensajeBoton="+"Volver a Listado Clientes"+"&paginaARedireccionar="+"listadoClientes.html";
//		} catch (Exception e) {
//			return "redirect:/avisoError.html?tituloPagina="+"Agregar Cliente"+"&tituloMensaje="+"Agregar Cliente"+"&mensaje="+e.toString()
//					+"&mensajeBoton="+"Volver a Listado Clientes"+"&paginaARedireccionar="+"listadoClientes.html";
//		}
	}
	
}
