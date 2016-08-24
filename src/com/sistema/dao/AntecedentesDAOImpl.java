package com.sistema.dao;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.pojo.Antecedentes;
import com.sistema.pojo.Familiares;
import com.sistema.pojo.Fisiologicos;
import com.sistema.pojo.Ginecologicos;
import com.sistema.pojo.HabitosToxicos;
import com.sistema.pojo.Patologicos;

@Repository
@Transactional
public class AntecedentesDAOImpl implements AntecedentesDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void saveAntecedentes(Antecedentes a) {
		try {
			getSession().save(a);
		} catch (Exception e) {
			System.out.println("SaveDAOImpl Ant: " + e.getMessage());
		}
		
	}

	@Override
	public void updateAntecedentes(Antecedentes a) {
		try {
			getSession().update(a);
		} catch (Exception e) {
			System.out.println("UpdateDAOImpl Ant: " + e.getMessage());
		}
	}

	@Override
	public void saveHabitos(HabitosToxicos h) {
		try {
			getSession().save(h);
		} catch (Exception e) {
			System.out.println("SaveDAOImpl Ant: " + e.getMessage());
		}
		
	}

	@Override
	public void updateHabitos(HabitosToxicos h) {
		try {
			getSession().update(h);
		} catch (Exception e) {
			System.out.println("UpdateDAOImpl Ant: " + e.getMessage());
		}
		
	}

	@Override
	public void saveFamiliares(Familiares f) {
		try {
			getSession().save(f);
		} catch (Exception e) {
			System.out.println("SaveDAOImpl Ant: " + e.getMessage());
		}
		
	}

	@Override
	public void updateFamiliares(Familiares f) {
		try {
			getSession().update(f);
		} catch (Exception e) {
			System.out.println("UpdateDAOImpl Ant: " + e.getMessage());
		}
		
	}
	
	
	@Override
	public void saveFisiologicos(Fisiologicos f) {
		try {
			getSession().save(f);
		} catch (Exception e) {
			System.out.println("SaveDAOImpl FIS: " + e.getMessage());
		}
		
	}

	@Override
	public void updateFisiologicos(Fisiologicos f) {
		try {
			getSession().update(f);
		} catch (Exception e) {
			System.out.println("UpdateDAOImpl Ant: " + e.getMessage());
		}
		
	}

	@Override
	public void savePatologicos(Patologicos p) {
		try {
			getSession().save(p);
		} catch (Exception e) {
			System.out.println("SaveDAOImpl PAT: " + e.getMessage());
		}
		
	}

	@Override
	public void updatePatologicos(Patologicos p) {
		try {
			getSession().update(p);
		} catch (Exception e) {
			System.out.println("UpdateDAOImpl PAT: " + e.getMessage());
		}
		
	}
	
	@Override
	public void saveGinecologicos(Ginecologicos g) {
		try {
			getSession().save(g);
		} catch (Exception e) {
			System.out.println("UpdateDAOImpl PAT: " + e.getMessage());
		}
		
	}
	
	@Override
	public void updateGinecologicos(Ginecologicos g) {
		try {
			getSession().update(g);
		} catch (Exception e) {
			System.out.println("UpdateDAOImpl PAT: " + e.getMessage());
		}
		
	}

	@Override
	public void deleteAntecedentes(Set<Antecedentes> a) {
		try {
			getSession().delete(a);
		} catch (Exception e) {
			System.out.println("DELETE Antecedentes: "+e.getMessage());
		}
		
	}

	@Override
	public void deleteHabitos(HabitosToxicos h) {
		try {
			getSession().delete(h);
		} catch (Exception e) {
			System.out.println("DELETE Antecedentes: "+e.getMessage());
		}
		
	}

	@Override
	public void deleteFamiliares(Familiares f) {
		try {
			getSession().delete(f);
		} catch (Exception e) {
			System.out.println("DELETE Antecedentes: "+e.getMessage());
		}
	}

	@Override
	public void deleteFisiologicos(Fisiologicos f) {
		try {
			getSession().delete(f);
		} catch (Exception e) {
			System.out.println("DELETE Antecedentes: "+e.getMessage());
		}
	}

	@Override
	public void deletePatologicos(Patologicos p) {
		try {
			getSession().delete(p);
		} catch (Exception e) {
			System.out.println("DELETE Antecedentes: "+e.getMessage());
		}
	}

	@Override
	public void deleteGinecologicos(Ginecologicos g) {
		try {
			getSession().delete(g);
		} catch (Exception e) {
			System.out.println("DELETE Antecedentes: "+e.getMessage());
		}
		
	}
}
