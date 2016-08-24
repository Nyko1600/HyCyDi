package com.sistema.dao;

import java.util.List;

import com.sistema.pojo.Domicilio;
import com.sistema.pojo.Usuario;

public interface DomicilioDAO {

	public void save(Domicilio domicilio);

	public Domicilio findById(int id);

	public void update(Domicilio domicilio);

	public List<String> findByProvincia(String nombre);

	
	
}
