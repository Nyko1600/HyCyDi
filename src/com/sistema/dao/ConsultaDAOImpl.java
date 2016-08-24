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
import com.sistema.pojo.Ficha;
import com.sistema.pojo.HistoriaClinica;

@Repository
@Transactional
public class ConsultaDAOImpl implements ConsultaDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public void save(Consulta consulta) {
		getSession().save(consulta);
	}
	@Override
	public void update(Consulta consulta) {
		getSession().update(consulta);
	}
	
	@Override
	public List<Consulta> findAllConsultas(int id){
		Query query = getSession().createQuery("from Consulta WHERE id_usuario = :id");
		return query.list();
	}
	
	
}
