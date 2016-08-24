package com.sistema.dao;

import java.util.List;

import com.sistema.pojo.Domicilio;
import com.sistema.pojo.Ficha;

public interface FichaDAO {

	public void save(Ficha ficha);
	
	public List<Ficha> findAllFicha(int id);

	public void update(Ficha ficha);
	
	public void delete(Ficha ficha);

	public Ficha findById(int id);

	
}
