package com.sistema.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.sistema.pojo.Domicilio;

@Repository
@Transactional
public class DomicilioDAOImpl implements DomicilioDAO{

	
	
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(Domicilio domicilio){
		try {
			getSession().save(domicilio);
			
		} catch (Exception e) {
			System.out.println("SaveDAOImpl: " + e.getMessage());
		}
	}
	
	@Override
	public Domicilio findById(int id){
		try {
			Criteria query = getSession().createCriteria(Domicilio.class).setFetchMode("usuario",FetchMode.JOIN)
					.add(Restrictions.eq("usuario.id_usuario",id)).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			return (Domicilio) query.uniqueResult();
		} catch (Exception e) {
			System.out.println("Return DAOimpl:"+ e.getMessage());
			return null;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findByProvincia(String nombre) {
		String sql = "SELECT provincia FROM historiaclinicadb.provincias where provincia LIKE '%"+nombre+"%";
		Criteria crit = (Criteria) getSession().createSQLQuery(sql);
		return crit.list();
	}
	
	@Override
	public void update(Domicilio domicilio) {

		try {
			getSession().update(domicilio);
			
			
		} catch (Exception e) {
			System.out.println("RESULTADO query-error: " + e.getMessage());
		}
		
	}
}
