package com.sistema.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.dao.UsuarioDAO;
import com.sistema.pojo.Usuario;

@Service
public class UsuarioService {

	@Autowired
	public UsuarioDAO usuarioDao;
	
	public void saveOrUpdate(Usuario usuario){
		
		try {
			if (usuario.getId_usuario() == 0) {
				usuario.setFechaAlta(new Timestamp(new Date().getTime()));
				
				usuarioDao.save(usuario);
			}else{
				//usuario.setFechaAlta(usuario.getFechaAlta());
				usuarioDao.update(usuario);
			}
		} catch (Exception e) {
			System.err.println("SaveOrUpdate-UsuarioService: "+ e.getMessage());
		}
	}
	
	public List<Usuario> findAll() {
		return usuarioDao.findAll();
	}
	
	public List<Usuario> findAllAdmins() {
		return usuarioDao.findAllAdmins();
	}
	
	public List<Usuario> findAllProfesionales() {
		return usuarioDao.findAllProfesionales();
	}
	
	public List<Usuario> findAllPacientes() {
		return usuarioDao.findAllPacientes();
	}
	
	public Usuario findById(int id){
		return usuarioDao.findById(id);
	}
	
	public Usuario findByMail(String m){
		return usuarioDao.findByMail(m);
	}

	public List<Usuario> findAllByName(String name) {
		return usuarioDao.findByName(name);
	}
	
	public List<Usuario> findAllByNamePacientes(String name) {
		return usuarioDao.findByNamePacientes(name);
	}
	
	public Usuario findByDNI(int dni) {
		return usuarioDao.findByDNI(dni);
	}

	public Usuario findByDNIPacientes(int dni) {
		return usuarioDao.findByDNIPacientes(dni);
	}
	
	public void Delete(Usuario us){
		usuarioDao.delete(us);
	}
}
