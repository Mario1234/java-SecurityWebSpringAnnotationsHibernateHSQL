package comun.configuracion;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import comun.Constantes;

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource fuenteDatos;
	
	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		JdbcUserDetailsManagerConfigurer<AuthenticationManagerBuilder> configuracionUsuarioContrasenia = auth.jdbcAuthentication();
		configuracionUsuarioContrasenia.dataSource(fuenteDatos);		
		configuracionUsuarioContrasenia.usersByUsernameQuery(Constantes.ConsultaUsuarioContrasenia);
		configuracionUsuarioContrasenia.authoritiesByUsernameQuery(Constantes.ConsultaUsuarioRol);
	}
	
	@Override
	 protected void configure(HttpSecurity http) throws Exception {		
	   http.authorizeRequests()
	 //pone restricciones de acceso a editar y guardar usuario
	  .antMatchers(Constantes.DIRECCION_EDITAR_USUARIO+"/**").access("hasRole('R_NORMAL')")  
	//los unicos que pueden acceder a editar y guardar son los que tienen rol R_NORMAL
	  .antMatchers(Constantes.DIRECCION_ANIADE_USUARIO+"/**").access("hasRole('R_NORMAL')")  
	  //pero no pone restircciones a "logeo o cualquier otra"(permitAll), entra cualquier rol aqui
	  .anyRequest().permitAll()
	  .and()
	//establece /logeo como pagina de login
	    .formLogin().loginPage(Constantes.DIRECCION_LOGEO)
	  //asocia los campos del jsp de logeo usuario y contrasenia para llevar a cabo la autorizacion de seguridad spring
	    .usernameParameter(Constantes.NOMBRE_CAMPO_USUARIO)
	    .passwordParameter(Constantes.NOMBRE_CAMPO_CONTRASENIA)
	  //establece la pagina a mostrar si logeo exitoso, que es la edicion de usuarios
	    .defaultSuccessUrl(Constantes.DIRECCION_EDITAR_USUARIO)
	  //establece la pagina a mostrar si logeo erroneo o fallido, que es la pagina de logeo de nuevo
	    .failureUrl(Constantes.DIRECCION_LOGEO+"?error=1")
	    //establece peticion de proceso de logeo
	    .loginProcessingUrl(Constantes.DIRECCION_PROCESO_LOGEO)
	  .and()
	  //establece la direccion de logeo con parametro de (sesion cerrada) como pagina resultado de hacer logout
	    .logout().logoutSuccessUrl(Constantes.DIRECCION_LOGOUT_EXITOSO) 
	   .and()
	   .exceptionHandling().accessDeniedPage("/403");
	 }
	
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}
