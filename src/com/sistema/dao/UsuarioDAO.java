package com.sistema.dao;

import java.util.List;

import com.sistema.pojo.Usuario;

public interface UsuarioDAO {

	public void save(Usuario user);
	public void update(Usuario user);
	public void delete(Usuario user);
	public List<Usuario> findAll();
	public List<Usuario> findAllAdmins();
	public List<Usuario> findAllProfesionales();
	public List<Usuario> findAllPacientes();
	public Usuario findById(int id);
	public Usuario findByDNI(int dni);
	public List<Usuario> findByName(String name);
	public Usuario findByMail(String m);
	List<Usuario> findByNamePacientes(String apellido1);
	Usuario findByDNIPacientes(int dni);
	

}
