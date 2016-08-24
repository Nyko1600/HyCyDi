package com.sistema.dao;

import java.util.List;

import com.sistema.pojo.HistoriaClinica;

public interface HistoriaClinicaDAO {

	public void save(HistoriaClinica historia);

	public HistoriaClinica findByUsuario(int id);

	public HistoriaClinica findByNumero(int id);
	
	public List<HistoriaClinica> findAllHistorias();

	public HistoriaClinica findById(int id);

	public List<HistoriaClinica> findByName(String name);
}
