package com.sistema.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sistema.dao.UsuarioDAO;
import com.sistema.pojo.Usuario;

@Service("CustomUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		Usuario usuario = usuarioDAO.findByMail(username);
		
		if (usuario != null) {
			authorities.add(new SimpleGrantedAuthority(usuario.getRol()));
			User user = new User(usuario.getMail(), usuario.getPassword(), authorities);
			return user;
		} else {
			System.out.println("hola");
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
	}

}
