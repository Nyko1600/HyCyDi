package com.sistema.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.dao.ConsultaDAO;
import com.sistema.dao.FichaDAO;
import com.sistema.dao.HistoriaClinicaDAO;
import com.sistema.dao.UsuarioDAO;
import com.sistema.pojo.Consulta;
import com.sistema.pojo.Ficha;
import com.sistema.pojo.HistoriaClinica;
import com.sistema.pojo.Usuario;

@Service
public class ConsultaService {

	@Autowired
	public ConsultaDAO consultaDao;
	
	
	public void saveOrUpdate(Consulta consulta){
		
				
		if (consulta.getId_consulta() == 0 ) {
				consulta.setFecha(new Timestamp(new Date().getTime()));
				consultaDao.save(consulta);
		}else{
				
				consultaDao.update(consulta);
		}
		
	}
	
	
	public List<Consulta> findAllConsultas(int id){
		return consultaDao.findAllConsultas(id);
	}
	
	
}
