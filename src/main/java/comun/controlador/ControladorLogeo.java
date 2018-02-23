package comun.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import comun.Constantes;
import comun.modelo.formulario.logeo.FormularioLogeo;

@Controller
public class ControladorLogeo {
	
	@GetMapping({"/",Constantes.DIRECCION_LOGEO})
	public ModelAndView muestraLogeo(@RequestParam(required=false) String error, @RequestParam(required=false) String sesion_cerrada) {
		String mensaje = "Esta es la pagina de logeo";
		if(error!=null && error.equalsIgnoreCase("1")) {
			mensaje = "contrasenia erronea";
		}
		if(sesion_cerrada!=null && sesion_cerrada.equalsIgnoreCase("1")) {
			mensaje = "sesion cerrada con exito";
		}
		System.out.println("atendiendo peticion get /logeo que es la pagina de login");
		FormularioLogeo formularioLogin = new FormularioLogeo();
		ModelAndView modelo = new ModelAndView();
		modelo.addObject("titulo", "Spring Security Hola Mundo");
		modelo.addObject("mensaje", mensaje);
		modelo.addObject("formularioLogin",formularioLogin);
		modelo.setViewName(Constantes.NOMBRE_LOGEO_JSP);
		return modelo;
	}

	@GetMapping(Constantes.DIRECCION_PROCESO_LOGEO)
	public String procesaLogeo() {
		System.out.println("atendiendo peticion get /procesaLogeo que es la autenticacion");
		return "redirect:"+Constantes.DIRECCION_EDITAR_USUARIO;
	}
}
