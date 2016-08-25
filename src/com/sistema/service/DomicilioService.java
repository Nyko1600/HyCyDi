package com.sistema.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sistema.dao.DomicilioDAO;
import com.sistema.dao.UsuarioDAO;
import com.sistema.pojo.Domicilio;
import com.sistema.pojo.Usuario;

@Service
public class DomicilioService {

	
	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Autowired
	DomicilioDAO domicilioDAO;
	
	public void saveOrUpdate(Usuario usuario, Domicilio dir){
					
			if (dir.getId_domicilio() == 0) {
				dir.setUsuario(usuario);
				domicilioDAO.save(dir);
			}else{
				dir.setUsuario(usuario);
				domicilioDAO.update(dir);
			
			}
	
	}
	
	public Domicilio findByUsuario(int id){
		return domicilioDAO.findById(id);
	}
	
	public List<String> findByProvincia(String nombre){
		return domicilioDAO.findByProvincia(nombre);
	}
	
	
	
	
}
