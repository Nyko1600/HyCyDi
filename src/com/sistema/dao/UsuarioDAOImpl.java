package com.sistema.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.pojo.HistoriaClinica;
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
	public List<Usuario> findAll() throws HibernateException{
		Query query = getSession().createQuery("from Usuario us order by us.apellido1");
		
		//System.out.println("sis: " + query.toString());
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAllAdmins() throws HibernateException{
		Query query = getSession().createQuery("from Usuario WHERE rol = 'ROLE_ADMIN'");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAllProfesionales() throws HibernateException{
		Query query = getSession().createQuery("from Usuario WHERE rol = 'ROLE_PROFESIONAL'");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAllPacientes() throws HibernateException{
		Query query = getSession().createQuery("from Usuario WHERE rol = 'ROLE_PACIENTE'");
		return query.list();
	}

	@Override
	public List<Usuario> findPacientesSinHistoria()  throws HibernateException {
		
		Query query = getSession().createSQLQuery("Select usuario.* from usuario left join historiaclinica On usuario.id_usuario = historiaclinica.id_usuario WHERE usuario.rol = :rol AND historiaclinica.id_usuario IS NULL")
				.addEntity(Usuario.class)
				.setParameter("rol","ROLE_PACIENTE");
				
		return query.list();
	}

	@Override
	public Usuario findById(int id) throws HibernateException{
		
		Query query = getSession().createQuery("from Usuario WHERE id_usuario = :id");
		query.setParameter("id", id);
		return (Usuario) query.uniqueResult();
		
	}

	@Override
	public Usuario findByDNI(int dni) throws HibernateException{
		/*Query query = getSession().createQuery("from Usuario WHERE nro_doc = :id");
		query.setInteger("id", dni);
		return (Usuario) query.uniqueResult();*/
		Criteria criteria = getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("nro_doc", dni));
		Usuario user = (Usuario) criteria.uniqueResult();
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Usuario findByDNIPacientes(int dni) throws HibernateException{
		Criteria criteria = getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("nro_doc", dni))
		.add(Restrictions.eq("rol","ROLE_PACIENTE"));
		return (Usuario) criteria.uniqueResult();
	}
	
	@Override
	public Usuario findByMail(String m) throws HibernateException{
		Criteria query = getSession().createCriteria(Usuario.class);
		query.add(Restrictions.eq("mail", m));
		
		return (Usuario) query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findByName(String nombre) throws HibernateException{

		SQLQuery query = getSession().createSQLQuery("SELECT * FROM usuario as us where concat(us.nro_doc,' ',us.nombre,' ',us.apellido1,' ',us.apellido2) like :nombre");
		query.addEntity(Usuario.class);
		query.setParameter("nombre", "%"+nombre+"%");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findByNamePacientes(String apellido1) throws HibernateException{
		
		Criteria query = getSession().createCriteria(Usuario.class)
		.add(Restrictions.like("apellido1", "%" + apellido1 + "%"))
		.add(Restrictions.eq("rol","ROLE_PACIENTE"))
		.addOrder(Order.asc("apellido1"));
		return query.list();
	}
	
	
	

}
