package com.sistema.pojo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ginecologicos")
public class Ginecologicos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_ginecologicos;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date FUM;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date FPP;
	private int edadGestacional;
	private int menarca;
	private String RM;
	private int IRS;
	private int  nroParejas;
	private String flujoGenital;
	private int gestas;
	private int partos;
	private int cesareas;
	private int abortos;
	private String descripcion;

	
	@OneToOne
	@JoinColumn(name="id_antecedentes")
	private Antecedentes antecedentes;

	public Ginecologicos(){}

	
	public Ginecologicos(Date fUM, Date fPP, int edadGestacional, int menarca, String rM, int iRS, int nroParejas,
			String flujoGenital, int gestas, int partos, int cesareas, int abortos, String descripcion,
			Antecedentes antecedentes) {
		super();
		FUM = fUM;
		FPP = fPP;
		this.edadGestacional = edadGestacional;
		this.menarca = menarca;
		RM = rM;
		IRS = iRS;
		this.nroParejas = nroParejas;
		this.flujoGenital = flujoGenital;
		this.gestas = gestas;
		this.partos = partos;
		this.cesareas = cesareas;
		this.abortos = abortos;
		this.descripcion = descripcion;
		this.antecedentes = antecedentes;
	}



	public int getId_ginecologicos() {
		return id_ginecologicos;
	}

	public void setId_ginecologicos(int id_ginecologicos) {
		this.id_ginecologicos = id_ginecologicos;
	}

	public Date getFUM() {
		return FUM;
	}

	public void setFUM(Date fUM) {
		FUM = fUM;
	}

	public Date getFPP() {
		return FPP;
	}

	public void setFPP(Date fPP) {
		FPP = fPP;
	}

	public int getEdadGestacional() {
		return edadGestacional;
	}

	public void setEdadGestacional(int edadGestacional) {
		this.edadGestacional = edadGestacional;
	}

	public int getMenarca() {
		return menarca;
	}

	public void setMenarca(int menarca) {
		this.menarca = menarca;
	}

	public String getRM() {
		return RM;
	}

	public void setRM(String rM) {
		RM = rM;
	}

	public int getIRS() {
		return IRS;
	}

	public void setIRS(int iRS) {
		IRS = iRS;
	}

	public int getNroParejas() {
		return nroParejas;
	}

	public void setNroParejas(int nroParejas) {
		this.nroParejas = nroParejas;
	}

	public String getFlujoGenital() {
		return flujoGenital;
	}

	public void setFlujoGenital(String flujoGenital) {
		this.flujoGenital = flujoGenital;
	}

	public int getGestas() {
		return gestas;
	}

	public void setGestas(int gestas) {
		this.gestas = gestas;
	}

	public int getPartos() {
		return partos;
	}

	public void setPartos(int partos) {
		this.partos = partos;
	}

	public int getCesareas() {
		return cesareas;
	}

	public void setCesareas(int cesareas) {
		this.cesareas = cesareas;
	}

	public int getAbortos() {
		return abortos;
	}

	public void setAbortos(int abortos) {
		this.abortos = abortos;
	}

	public String getOtros() {
		return descripcion;
	}

	public void setOtros(String otros) {
		this.descripcion = otros;
	}

	public Antecedentes getAntecedentes() {
		return antecedentes;
	}

	public void setAntecedentes(Antecedentes antecedentes) {
		this.antecedentes = antecedentes;
	}

	@Override
	public String toString() {
		return "Ginecologicos [id_ginecologicos=" + id_ginecologicos + ", FUM=" + FUM + ", FPP=" + FPP
				+ ", edadGestacional=" + edadGestacional + ", menarca=" + menarca + ", RM=" + RM + ", IRS=" + IRS
				+ ", nroParejas=" + nroParejas + ", flujoGenital=" + flujoGenital + ", gestas=" + gestas + ", partos="
				+ partos + ", cesareas=" + cesareas + ", abortos=" + abortos + ", otros=" + descripcion + ", antecedentes="
				+ antecedentes + "]";
	}
	
	
	
	
	
	
}
