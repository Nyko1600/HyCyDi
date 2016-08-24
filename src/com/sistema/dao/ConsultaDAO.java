package com.sistema.dao;

import java.util.List;

import com.sistema.pojo.Consulta;

public interface ConsultaDAO {

	public void save(Consulta consulta);
	
	List<Consulta> findAllConsultas(int id);

	void update(Consulta consulta);

	
}
