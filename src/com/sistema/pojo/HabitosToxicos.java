package com.sistema.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="habitostoxicos")
public class HabitosToxicos {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_habitos;
	private String alcohol;
	private String tabaco;
	private String drogas;
	private String infusiones;
	private String otros;
	private String descripcion;
	
	@OneToOne
	@JoinColumn(name="id_antecedentes")
	private Antecedentes antecedentes;

	
	
	public HabitosToxicos(){}
	
	public HabitosToxicos(String alcohol, String tabaco, String drogas, String infusiones, String otros,
			String descripcion, Antecedentes antecedentes) {
		super();
		this.alcohol = alcohol;
		this.tabaco = tabaco;
		this.drogas = drogas;
		this.infusiones = infusiones;
		this.otros = otros;
		this.descripcion = descripcion;
		this.antecedentes = antecedentes;
	}

	public int getId_habitos() {
		return id_habitos;
	}

	public void setId_habitos(int id_habitos) {
		this.id_habitos = id_habitos;
	}

	public String getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}

	public String getTabaco() {
		return tabaco;
	}

	public void setTabaco(String tabaco) {
		this.tabaco = tabaco;
	}

	public String getDrogas() {
		return drogas;
	}

	public void setDrogas(String drogas) {
		this.drogas = drogas;
	}

	public String getInfusiones() {
		return infusiones;
	}

	public void setInfusiones(String infusiones) {
		this.infusiones = infusiones;
	}

	public String getOtros() {
		return otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Antecedentes getAntecedentes() {
		return antecedentes;
	}

	public void setAntecedentes(Antecedentes antecedentes) {
		this.antecedentes = antecedentes;
	}

	@Override
	public String toString() {
		return "HabitosToxicos [id_habitos=" + id_habitos + ", alcohol=" + alcohol + ", tabaco=" + tabaco + ", drogas="
				+ drogas + ", infusiones=" + infusiones + ", otros=" + otros + ", descripcion=" + descripcion
				+ ", antecedentes=" + antecedentes + "]";
	}
	
	

}
