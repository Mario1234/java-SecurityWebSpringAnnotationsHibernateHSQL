package comun.modelo.usuario.bo;

import java.util.List;

import comun.modelo.usuario.entidad.Usuario;

public interface UsuarioBo {
	
	public void guarda(Usuario usuario);
	
	public void actualiza(Usuario usuario);
	
	public void elimina(Usuario usuario);

	public List<Usuario> dameUsuarios();
}
