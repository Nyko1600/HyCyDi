package com.sistema.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.pojo.Consulta;
import com.sistema.pojo.Diagnostico;
import com.sistema.pojo.Ficha;
import com.sistema.pojo.HistoriaClinica;

@Repository
@Transactional
public class DiagnosticoDAOImpl implements DiagnosticoDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(Diagnostico diagnostico) {
		getSession().save(diagnostico);
	}

	@Override
	public void update(Diagnostico diagnostico) {
		getSession().update(diagnostico);
	}
	
	
}
