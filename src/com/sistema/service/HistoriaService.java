package com.sistema.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.dao.HistoriaClinicaDAO;
import com.sistema.dao.UsuarioDAO;
import com.sistema.pojo.HistoriaClinica;
import com.sistema.pojo.Usuario;

@Service
public class HistoriaService {

	@Autowired
	public HistoriaClinicaDAO historiaDao;
	
	
	public void saveOrUpdate(HistoriaClinica historia){
		
				
		
			if (historia.getId_historia() == 0 
					&& historiaDao.findByUsuario(historia.getUsuario().getId_usuario()) == null
					&& historiaDao.findByNumero(historia.getNro_historia()) == null) {
				
				historiaDao.save(historia);
			}else{
				System.err.println("Verificar Historia");
				//historiaDao.update(historia);
			}
	}
	
	public HistoriaClinica findById(int id){
		return historiaDao.findById(id);
	}
	
	
	public List<HistoriaClinica> findAllHistorias(){
		return historiaDao.findAllHistorias();
	}
	
	public List<HistoriaClinica> findByName(String name){
		return historiaDao.findByName(name);
	}
	
	
}
