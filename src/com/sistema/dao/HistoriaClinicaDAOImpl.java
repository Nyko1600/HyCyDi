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

import com.sistema.pojo.HistoriaClinica;

@Repository
@Transactional
public class HistoriaClinicaDAOImpl implements HistoriaClinicaDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public void save(HistoriaClinica historia) {
		getSession().save(historia);
	}

	@Override
	public HistoriaClinica findByUsuario(int id){
		Criteria criteria = getSession().createCriteria(HistoriaClinica.class).setFetchMode("usuario", FetchMode.JOIN)
				.add(Restrictions.eq("usuario.id_usuario", id)).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		return (HistoriaClinica) criteria.uniqueResult();
	}
	
	@Override
	public HistoriaClinica findByNumero(int nro){
		Criteria criteria = getSession().createCriteria(HistoriaClinica.class)
				.add(Restrictions.eq("nro_historia", nro));
		
		return (HistoriaClinica) criteria.uniqueResult();
	}
	
	@Override
	public HistoriaClinica findById(int id){
		Criteria criteria = getSession().createCriteria(HistoriaClinica.class)
				.add(Restrictions.eq("id_historia", id));
		
		return (HistoriaClinica) criteria.uniqueResult();
	}
	
	@Override
	public List<HistoriaClinica> findAllHistorias(){
		Query query = getSession().createQuery("from HistoriaClinica");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HistoriaClinica> findByName(String name){
		try {

			String queryString = "SELECT * FROM historiaclinica hc WHERE hc.id_usuario =(SELECT us.id_usuario FROM usuario us WHERE us.apellido1 LIKE ?)";
				
			Query query = getSession().createSQLQuery(queryString);
			query.setString(0,"%"+name+"%");
			return query.list();
		} catch (Exception e) {
			System.out.println("ERROR BUSCAR: " + e.getMessage());
			return null;
		}
	}
	
	
}
