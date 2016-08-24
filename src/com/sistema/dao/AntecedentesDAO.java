package com.sistema.dao;

import java.util.Set;

import com.sistema.pojo.Antecedentes;
import com.sistema.pojo.Familiares;
import com.sistema.pojo.Fisiologicos;
import com.sistema.pojo.Ginecologicos;
import com.sistema.pojo.HabitosToxicos;
import com.sistema.pojo.Patologicos;

public interface AntecedentesDAO {

	
	public void saveAntecedentes(Antecedentes a);
	public void updateAntecedentes(Antecedentes a);
	public void deleteAntecedentes(Set<Antecedentes> set);
	
	public void saveHabitos(HabitosToxicos h);
	public void updateHabitos(HabitosToxicos h);
	public void deleteHabitos(HabitosToxicos h);
	
	public void saveFamiliares(Familiares f);
	public void updateFamiliares(Familiares f);
	public void deleteFamiliares(Familiares f);
	
	public void saveFisiologicos(Fisiologicos f);
	public void updateFisiologicos(Fisiologicos f);
	public void deleteFisiologicos(Fisiologicos f);
	
	public void savePatologicos(Patologicos p);
	public void updatePatologicos(Patologicos p);
	public void deletePatologicos(Patologicos p);
	
	public void saveGinecologicos(Ginecologicos g);
	public void updateGinecologicos(Ginecologicos g);
	public void deleteGinecologicos(Ginecologicos g);
	
}
