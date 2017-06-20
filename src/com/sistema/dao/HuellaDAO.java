package com.sistema.dao;

import java.util.List;

import com.sistema.pojo.Huella;

public interface HuellaDAO {

	public void save(Huella huella);
	public void update(Huella huella);
	public void delete(Huella huella);
	public List<Huella> findAll();
	public Huella findById(int id);
	public List<Huella> findByDedo(String name);
	

}
