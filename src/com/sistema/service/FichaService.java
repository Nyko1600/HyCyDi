package com.sistema.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.dao.FichaDAO;
import com.sistema.dao.HistoriaClinicaDAO;
import com.sistema.dao.UsuarioDAO;
import com.sistema.pojo.Ficha;
import com.sistema.pojo.HistoriaClinica;
import com.sistema.pojo.Usuario;

@Service
public class FichaService {

	@Autowired
	public FichaDAO fichaDao;
	
	
	public void saveOrUpdate(Ficha ficha){
		
				
		try {
			if (ficha.getId_ficha() == 0 ) {
				ficha.setFecha(new Timestamp(new Date().getTime()));
				fichaDao.save(ficha);
			}else{
				
				fichaDao.update(ficha);
			}
		} catch (Exception e) {
			System.err.println("SaveOrUpdate-fichaService: "+ e.getMessage());
		}
	}
	
	public void delete(Ficha ficha){
		fichaDao.delete(ficha);
	}
	
	public List<Ficha> findAllFichas(int id){
		return fichaDao.findAllFicha(id);
	}
	
	public Ficha findById(int id){
		return fichaDao.findById(id);
	}
}
