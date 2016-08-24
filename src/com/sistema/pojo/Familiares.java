package com.sistema.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="familiares")
public class Familiares {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_familiares;
	private String diabetes;
	private String hipertension;
	private String tuberculosis;
	private String gemelar;
	private String otros;

	@OneToOne
	@JoinColumn(name="id_antecedentes")
	private Antecedentes antecedentes;

	
	
	public Familiares(){}



	public Familiares(String diabetes, String hipertension, String tuberculosis, String gemelar, String otros,
			Antecedentes antecedentes) {
		super();
		this.diabetes = diabetes;
		this.hipertension = hipertension;
		this.tuberculosis = tuberculosis;
		this.gemelar = gemelar;
		this.otros = otros;
		this.antecedentes = antecedentes;
	}



	public int getId_familiares() {
		return id_familiares;
	}



	public void setId_familiares(int id_familiares) {
		this.id_familiares = id_familiares;
	}



	public String getDiabetes() {
		return diabetes;
	}



	public void setDiabetes(String diabetes) {
		this.diabetes = diabetes;
	}



	public String getHipertension() {
		return hipertension;
	}



	public void setHipertension(String hipertension) {
		this.hipertension = hipertension;
	}



	public String getTuberculosis() {
		return tuberculosis;
	}



	public void setTuberculosis(String tuberculosis) {
		this.tuberculosis = tuberculosis;
	}



	public String getGemelar() {
		return gemelar;
	}



	public void setGemelar(String gemelar) {
		this.gemelar = gemelar;
	}



	public String getOtros() {
		return otros;
	}



	public void setOtros(String otros) {
		this.otros = otros;
	}



	public Antecedentes getAntecedentes() {
		return antecedentes;
	}



	public void setAntecedentes(Antecedentes antecedentes) {
		this.antecedentes = antecedentes;
	}
	
	
	
}
