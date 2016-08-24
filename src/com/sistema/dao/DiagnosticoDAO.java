package com.sistema.dao;

import java.util.List;

import com.sistema.pojo.Consulta;
import com.sistema.pojo.Diagnostico;

public interface DiagnosticoDAO {

	public void save(Diagnostico diagnostico);
	
	void update(Diagnostico diagnostico);

	
}
