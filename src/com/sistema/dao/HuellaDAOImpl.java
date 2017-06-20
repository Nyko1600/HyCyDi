package com.sistema.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.sistema.pojo.HistoriaClinica;
import com.sistema.pojo.Huella;
import com.sistema.pojo.Usuario;

@Repository
@Transactional
public class HuellaDAOImpl implements HuellaDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Huella huella) {

		getSession().save(huella);
	}

	@Override
	public void update(Huella huella) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Huella huella) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Huella> findAll() {
		Query query = getSession().createQuery("from Huella");
		return query.list();
	}

	@Override
	public Huella findById(int id) {
		Criteria criteria = getSession().createCriteria(Huella.class);
		criteria.add(Restrictions.eq("id_usuario", id));
		return (Huella) criteria.uniqueResult();
	}
	
	@Override
	public List<Huella> findByDedo(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
