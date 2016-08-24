package com.sistema.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="patologicos")
public class Patologicos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_patologicos;
	
	private String infancia;
	private String adulto;
	private String DBT;
	private String HTA;
	private String TBC;
	private String gemelar;
	private String  quirurgicos;
	private String traumatologicos;
	private String alergicos;
	private String otros;

	
	@OneToOne
	@JoinColumn(name="id_antecedentes")
	private Antecedentes antecedentes;

	public Patologicos(){}
	
	public Patologicos(String infancia, String adulto, String dBT, String hTA, String tBC, String gemelar,
			String quirurjicos, String traumatologicos, String alergicos, String otros, Antecedentes antecedentes) {
		super();
		this.infancia = infancia;
		this.adulto = adulto;
		DBT = dBT;
		HTA = hTA;
		TBC = tBC;
		this.gemelar = gemelar;
		this.quirurgicos = quirurjicos;
		this.traumatologicos = traumatologicos;
		this.alergicos = alergicos;
		this.otros = otros;
		this.antecedentes = antecedentes;
	}

	public int getId_patologicos() {
		return id_patologicos;
	}

	public void setId_patologicos(int id_patologicos) {
		this.id_patologicos = id_patologicos;
	}

	public String getInfancia() {
		return infancia;
	}

	public void setInfancia(String infancia) {
		this.infancia = infancia;
	}

	public String getAdulto() {
		return adulto;
	}

	public void setAdulto(String adulto) {
		this.adulto = adulto;
	}

	public String getDBT() {
		return DBT;
	}

	public void setDBT(String dBT) {
		DBT = dBT;
	}

	public String getHTA() {
		return HTA;
	}

	public void setHTA(String hTA) {
		HTA = hTA;
	}

	public String getTBC() {
		return TBC;
	}

	public void setTBC(String tBC) {
		TBC = tBC;
	}

	public String getGemelar() {
		return gemelar;
	}

	public void setGemelar(String gemelar) {
		this.gemelar = gemelar;
	}

	public String getQuirurjicos() {
		return quirurgicos;
	}

	public void setQuirurjicos(String quirurjicos) {
		this.quirurgicos = quirurjicos;
	}

	public String getTraumatologicos() {
		return traumatologicos;
	}

	public void setTraumatologicos(String traumatologicos) {
		this.traumatologicos = traumatologicos;
	}

	public String getAlergicos() {
		return alergicos;
	}

	public void setAlergicos(String alergicos) {
		this.alergicos = alergicos;
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

	@Override
	public String toString() {
		return "Patologicos [id_patologicos=" + id_patologicos + ", infancia=" + infancia + ", adulto=" + adulto
				+ ", DBT=" + DBT + ", HTA=" + HTA + ", TBC=" + TBC + ", gemelar=" + gemelar + ", quirurjicos="
				+ quirurgicos + ", traumatologicos=" + traumatologicos + ", alergicos=" + alergicos + ", otros=" + otros
				+ ", antecedentes=" + antecedentes + "]";
	}
	
	
	
	
	
	
}
