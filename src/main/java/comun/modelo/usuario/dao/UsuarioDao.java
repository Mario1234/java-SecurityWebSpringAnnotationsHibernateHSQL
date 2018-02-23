package comun.modelo.usuario.dao;

import java.util.List;

import comun.modelo.usuario.entidad.Usuario;

public interface UsuarioDao {
	
	public void guarda(Usuario usuario);
	
	public void actualiza(Usuario usuario);
	
	public void elimina(Usuario usuario);

	public List<Usuario> dameUsuarios();
}
