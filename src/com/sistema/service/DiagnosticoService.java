package com.sistema.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.dao.ConsultaDAO;
import com.sistema.dao.DiagnosticoDAO;
import com.sistema.dao.FichaDAO;
import com.sistema.dao.HistoriaClinicaDAO;
import com.sistema.dao.UsuarioDAO;
import com.sistema.pojo.Consulta;
import com.sistema.pojo.Diagnostico;
import com.sistema.pojo.Ficha;
import com.sistema.pojo.HistoriaClinica;
import com.sistema.pojo.Usuario;

@Service
public class DiagnosticoService {

	@Autowired
	public DiagnosticoDAO diagnosticoDao;
	
	
	public void saveOrUpdate(Diagnostico diagnostico){
		
			
			if (diagnostico.getId_diagnostico() == 0 ) {
				diagnosticoDao.save(diagnostico);
			}else{
				
				diagnosticoDao.update(diagnostico);
			}
	}
	
	
	
}
