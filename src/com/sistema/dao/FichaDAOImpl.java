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

import com.sistema.pojo.Domicilio;
import com.sistema.pojo.Ficha;
import com.sistema.pojo.HistoriaClinica;

@Repository
@Transactional
public class FichaDAOImpl implements FichaDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public void save(Ficha ficha) {
		getSession().save(ficha);
	}
	
	@Override
	public void update(Ficha ficha) {
		getSession().update(ficha);
	}
	
	@Override
	public void delete(Ficha ficha) {
		getSession().delete(ficha);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ficha> findAllFicha(int id){
		Query query = getSession().createQuery("FROM Ficha WHERE id_historia = "+id);
		return query.list();
	}
	
	@Override
	public Ficha findById(int id){
		try {
			Criteria query = getSession().createCriteria(Ficha.class)
					.add(Restrictions.eq("id_ficha",id));
			return (Ficha) query.uniqueResult();
		} catch (Exception e) {
			System.out.println("Return DAOimpl:"+ e.getMessage());
			return null;
		}
		
	}
}
