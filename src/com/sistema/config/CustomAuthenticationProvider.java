package com.sistema.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestAttributes;

import com.sistema.dao.UsuarioDAO;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	//@Autowired
	//private HttpServletRequest request;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		
		//Datos del Formulario de Login
		String principal = authentication.getName();
		String credentials = (String) authentication.getCredentials(); 
	
		User user = (User) customUserDetailsService.loadUserByUsername(principal);
		
		if (user != null) {
			if (credentials.equals(user.getPassword())) {
				
				System.out.println("Login Correcto: ");
			//request.getSession().setAttribute("UsuarioSession", user);
				return new UsernamePasswordAuthenticationToken(principal, user.getPassword(), user.getAuthorities());
			}else{
				System.out.println("Error de Login: " + principal);
				throw new BadCredentialsException("Error de Login");
			}
			
		} else {
			System.out.println("Error de Login: " + principal);
			throw new BadCredentialsException("Error de Login");
		}
		
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;//Importante retornar true siempre
	}

	
}
