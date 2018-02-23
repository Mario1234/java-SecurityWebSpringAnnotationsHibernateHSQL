package comun.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import comun.modelo.usuario.bo.UsuarioBo;
import comun.modelo.usuario.entidad.Usuario;
import comun.Constantes;

@Controller
public class ControladorUsuario {

	@Autowired
	private UsuarioBo usuarioBo;	
	
	@GetMapping(Constantes.DIRECCION_EDITAR_USUARIO)
	public String muestraEdicion(Locale locale, Model modelo) {
		List<Usuario> listaUsuarios = usuarioBo.dameUsuarios();
		modelo.addAttribute("jsp_usuarios", listaUsuarios);
		return Constantes.NOMBRE_EDITAR_USUARIO_JSP;
	}
	
	//objeto usuario para el formulario de edicion
	@ModelAttribute("jsp_usuario")
    public Usuario formBackingObject() {
        return new Usuario();
    }

	@PostMapping(Constantes.DIRECCION_ANIADE_USUARIO)
	public String guardaUsuario(@ModelAttribute("jsp_usuario") @Valid Usuario usuario, BindingResult resultado, Model modelo) {

		if (resultado.hasErrors()) {
			List<Usuario> listaVacia = new ArrayList<Usuario>();
			modelo.addAttribute("jsp_usuarios", listaVacia);
			return Constantes.NOMBRE_EDITAR_USUARIO_JSP;
		}

		usuarioBo.guarda(usuario);
		return "redirect:/";
	}
}
