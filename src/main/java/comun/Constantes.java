package comun;

public class Constantes {
	
	//CONSULTAS SEGURIDAD SPRING
	//utiliza apellido como contrasenia
	public static final String ConsultaUsuarioContrasenia = 
	         "SELECT NOMBRE, APELLIDO, 'true' "+
	         "FROM USUARIO "+
	         "WHERE NOMBRE=?;";
	
	public static final String ConsultaUsuarioRol = 
			"SELECT u.NOMBRE, CONCAT('ROLE_', r.NOMBRE) as autoridad "+
    		"FROM USUARIO u "+
    		"INNER JOIN ROL r ON u.ID = r.ID_USUARIO "+
    		"WHERE u.ID = r.ID_USUARIO "+
    		"AND u.NOMBRE=?;";
	
	//NOMBRES ELEMENTOS JSP SEGURIDAD SPRING
	public static final String NOMBRE_CAMPO_USUARIO = "nombreUsuario";
	public static final String NOMBRE_CAMPO_CONTRASENIA = "contrasenia";
	
	//DIRECCIONES DE PETICIONES
	public static final String DIRECCION_EDITAR_USUARIO = "/editarUsuario";
	public static final String DIRECCION_LOGEO = "/logeo";
	public static final String DIRECCION_PROCESO_LOGEO = "/procesaLogeo";
	public static final String DIRECCION_ANIADE_USUARIO = "/aniadeUsuario";
	public static final String DIRECCION_LOGOUT_EXITOSO = "/logeo?sesion_cerrada=1";

	//NOMBRES DE JSPs
	public static final String NOMBRE_LOGEO_JSP = "logeo";
	public static final String NOMBRE_EDITAR_USUARIO_JSP = "editar_usuario";
	
}
