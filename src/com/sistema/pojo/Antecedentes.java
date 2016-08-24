package com.sistema.pojo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="antecedentes")
public class Antecedentes {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_antecedentes;
	
	private Timestamp fecha;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ficha")
	private Ficha ficha;

	@OneToOne(mappedBy="antecedentes")
	@Cascade(CascadeType.DELETE)
	private HabitosToxicos habitos;

	@OneToOne(mappedBy="antecedentes")
	@Cascade(CascadeType.DELETE)
	private Familiares familiares;
	
	@OneToOne(mappedBy="antecedentes")
	@Cascade(CascadeType.DELETE)
	private Fisiologicos fisiologicos;
	
	@OneToOne(mappedBy="antecedentes")
	@Cascade(CascadeType.DELETE)
	private Patologicos patologicos;
	
	@OneToOne(mappedBy="antecedentes")
	@Cascade(CascadeType.DELETE)
	private Ginecologicos ginecologicos;
	
	public Antecedentes() {
		super();
	}

	public Antecedentes(Ficha ficha, HabitosToxicos habitos, Familiares familiares, Fisiologicos fisiologicos,Patologicos patologicos,Ginecologicos ginecologicos) {
		super();
		this.ficha = ficha;
		this.habitos = habitos;
		this.familiares = familiares;
		this.fisiologicos = fisiologicos;
		this.patologicos = patologicos;
		this.ginecologicos = ginecologicos;
	}

	public int getId_antecedentes() {
		return id_antecedentes;
	}

	public void setId_antecedentes(int id_antecedentes) {
		this.id_antecedentes = id_antecedentes;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Ficha getFicha() {
		return ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}

	
	
	public HabitosToxicos getHabitos() {
		return habitos;
	}

	public void setHabitos(HabitosToxicos habitos) {
		this.habitos = habitos;
	}

	public Familiares getFamiliares() {
		return familiares;
	}

	public void setFamiliares(Familiares familiares) {
		this.familiares = familiares;
	}

	public Fisiologicos getFisiologicos() {
		return fisiologicos;
	}

	public void setFisiologicos(Fisiologicos fisiologicos) {
		this.fisiologicos = fisiologicos;
	}

	public Patologicos getPatologicos() {
		return patologicos;
	}

	public void setPatologicos(Patologicos patologicos) {
		this.patologicos = patologicos;
	}
	
	
	

	
	

	
	
	

	
	
}
