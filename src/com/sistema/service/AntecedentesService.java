package com.sistema.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.dao.AntecedentesDAO;
import com.sistema.dao.DomicilioDAO;
import com.sistema.dao.FichaDAO;
import com.sistema.dao.UsuarioDAO;
import com.sistema.pojo.Antecedentes;
import com.sistema.pojo.Domicilio;
import com.sistema.pojo.Familiares;
import com.sistema.pojo.Ficha;
import com.sistema.pojo.Fisiologicos;
import com.sistema.pojo.Ginecologicos;
import com.sistema.pojo.HabitosToxicos;
import com.sistema.pojo.Patologicos;
import com.sistema.pojo.Usuario;

@Service
public class AntecedentesService {

	@Autowired
	FichaDAO fichaDAO;

	@Autowired
	AntecedentesDAO antecedentesDAO;

	public void saveOrUpdateAntecedentes(Antecedentes ant) {

		if (ant.getId_antecedentes() == 0) {
			ant.setFecha(new Timestamp(new Date().getTime()));
			antecedentesDAO.saveAntecedentes(ant);
		} else {
			ant.setFecha(new Timestamp(new Date().getTime()));
			antecedentesDAO.updateAntecedentes(ant);
		}

	}

	public void saveOrUpdateHabitos(HabitosToxicos hab) {

		if (hab.getId_habitos() == 0) {
			antecedentesDAO.saveHabitos(hab);
		} else {
			antecedentesDAO.updateHabitos(hab);
		}

	}

	public void saveOrUpdateFamiliares(Familiares fam) {

		if (fam.getId_familiares() == 0) {
			antecedentesDAO.saveFamiliares(fam);
		} else {
			antecedentesDAO.updateFamiliares(fam);
		}

	}
	
	public void saveOrUpdateFisiologicos(Fisiologicos fis) {

		if (fis.getId_fisiologicos() == 0) {
			antecedentesDAO.saveFisiologicos(fis);
		} else {
			antecedentesDAO.updateFisiologicos(fis);
		}

	}
	
	public void saveOrUpdatePatologicos(Patologicos p) {

		if (p.getId_patologicos() == 0) {
			antecedentesDAO.savePatologicos(p);
		} else {
			antecedentesDAO.updatePatologicos(p);
		}

	}
	
	public void saveOrUpdateGinecologicos(Ginecologicos g) {

		if (g.getId_ginecologicos() == 0) {
			antecedentesDAO.saveGinecologicos(g);
		} else {
			antecedentesDAO.updateGinecologicos(g);
		}

	}
	
	
	public void deleteAntecedentes(Set<Antecedentes> set) {
			antecedentesDAO.deleteAntecedentes(set);
		
	}

	
	
}
