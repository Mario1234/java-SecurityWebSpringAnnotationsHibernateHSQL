package comun.modelo.usuario.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import comun.modelo.usuario.dao.UsuarioDao;
import comun.modelo.usuario.entidad.Usuario;

@Repository("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao{
	
	@PersistenceContext
	private EntityManager administradorEntidades;
	
	public void guarda(Usuario usuario){
		administradorEntidades.persist(usuario);
	}
	
	public void actualiza(Usuario usuario){
		administradorEntidades.merge(usuario);
	}
	
	public void elimina(Usuario usuario){
		administradorEntidades.remove(administradorEntidades.contains(usuario) ? usuario : administradorEntidades.merge(usuario));
//		em.remove(usuario);
	}

	public List<Usuario> dameUsuarios(){
		List<?> listObjs = administradorEntidades.createQuery(
	            "SELECT u FROM Usuario u").getResultList();//aqui uso el nombre de la entidad(Usuario) no de la tabla(USUARIO)
		List<Usuario> listUsus = new ArrayList<Usuario>();
		for(Object obj : listObjs) {
			if(obj instanceof Usuario) {
				listUsus.add((Usuario)obj);
			}
		}
		return listUsus;
	}
}