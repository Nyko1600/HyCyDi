package com.sistema.pojo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="consulta")
public class Consulta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_consulta;
	private Timestamp fecha;
	private String anamnesis;
	private String exploracion;
	private String observaciones;
	
	
	@ManyToOne
	@JoinColumn(name="id_historia")
	private HistoriaClinica historia;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@OneToOne(mappedBy="consulta")
	private Diagnostico diagnostico;
	
	
	public Consulta(){}
	
	public Consulta(String anamnesis, String exploracion, String observaciones, HistoriaClinica historia,
			Usuario usuario, Diagnostico diagnostico) {
		super();
		this.anamnesis = anamnesis;
		this.exploracion = exploracion;
		this.observaciones = observaciones;
		this.historia = historia;
		this.usuario = usuario;
		this.diagnostico = diagnostico;
	}


	public int getId_consulta() {
		return id_consulta;
	}

	public void setId_consulta(int id_consulta) {
		this.id_consulta = id_consulta;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getAnamnesis() {
		return anamnesis;
	}

	public void setAnamnesis(String anamnesis) {
		this.anamnesis = anamnesis;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public HistoriaClinica getHistoria() {
		return historia;
	}

	public void setHistoria(HistoriaClinica historia) {
		this.historia = historia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getExploracion() {
		return exploracion;
	}

	public void setExploracion(String exploracion) {
		this.exploracion = exploracion;
	}

	public Diagnostico getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}

	@Override
	public String toString() {
		return "Consulta [id_consulta=" + id_consulta + ", fecha=" + fecha + ", anamnesis=" + anamnesis
				+ ", exploracion=" + exploracion + ", observaciones=" + observaciones + ", historia=" + historia
				+ ", usuario=" + usuario + ", diagnostico=" + diagnostico + "]";
	}




	
	
	
	
	
}
