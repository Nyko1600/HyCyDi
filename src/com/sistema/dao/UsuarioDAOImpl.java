package com.sistema.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.sistema.pojo.Usuario;

@Repository
@Transactional
public class UsuarioDAOImpl implements UsuarioDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public void save(Usuario user) {
		getSession().save(user);
	}

	@Override
	public void update(Usuario user) {
		getSession().update(user);
		
	}

	@Override
	public void delete(Usuario user) {
		getSession().delete(user);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAll() {
		Query query = getSession().createQuery("from Usuario us order by us.apellido1");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAllAdmins() {
		Query query = getSession().createQuery("from Usuario WHERE rol = 'ROLE_ADMIN'");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAllProfesionales() {
		Query query = getSession().createQuery("from Usuario WHERE rol = 'ROLE_PROFESIONAL'");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAllPacientes() {
		Query query = getSession().createQuery("from Usuario WHERE rol = 'ROLE_PACIENTE'");
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Usuario findById(int id) {
		//Query query = getSession().createQuery("from Usuario WHERE id_usuario = :id");
		//return (Usuario) query.uniqueResult();
		Criteria criteria = getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("id_usuario", id));
		return (Usuario) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Usuario findByDNI(int dni) {
		//Query query = getSession().createQuery("from Usuario WHERE id_usuario = :id");
		//return (Usuario) query.uniqueResult();
		Criteria criteria = getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("dni", dni));
		return (Usuario) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Usuario findByDNIPacientes(int dni) {
		//Query query = getSession().createQuery("from Usuario WHERE id_usuario = :id");
		//return (Usuario) query.uniqueResult();
		Criteria criteria = getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("dni", dni))
		.add(Restrictions.eq("rol","ROLE_PACIENTE"));
		return (Usuario) criteria.uniqueResult();
	}
	
	@Override
	public Usuario findByMail(String m) {
		Criteria query = getSession().createCriteria(Usuario.class);
		query.add(Restrictions.eq("mail", m));
		
		return (Usuario) query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findByName(String apellido1) {
		
		Criteria query = getSession().createCriteria(Usuario.class)
		.add(Restrictions.like("apellido1", "%" + apellido1 + "%"))
		//.add(Restrictions.or(Restrictions.like("apellido2", "%" + apellido1 + "%")))
		.addOrder(Order.asc("apellido1"));
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findByNamePacientes(String apellido1) {
		
		Criteria query = getSession().createCriteria(Usuario.class)
		.add(Restrictions.like("apellido1", "%" + apellido1 + "%"))
		.add(Restrictions.eq("rol","ROLE_PACIENTE"))
		.addOrder(Order.asc("apellido1"));
		return query.list();
	}
	
	
	

}
