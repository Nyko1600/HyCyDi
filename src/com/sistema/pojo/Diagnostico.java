package com.sistema.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="diagnostico")
public class Diagnostico{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_diagnostico;
	private String titulo;
	private String tratamiento;
	private String descripcion;

	@OneToOne
	@JoinColumn(name="id_consulta")
	private Consulta consulta;
	
	public Diagnostico() {
	}

	public Diagnostico( String titulo, String tratamiento, String descripcion) {
		super();
		this.titulo = titulo;
		this.tratamiento = tratamiento;
		this.descripcion = descripcion;
	}

	public int getId_diagnostico() {
		return id_diagnostico;
	}


	public void setId_diagnostico(int id_diagnostico) {
		this.id_diagnostico = id_diagnostico;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getTratamiento() {
		return tratamiento;
	}


	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}





	@Override
	public String toString() {
		return "Diagnostico [id_diagnostico=" + id_diagnostico + ", titulo=" + titulo + ", tratamiento=" + tratamiento
				+ ", descripcion=" + descripcion + ", consulta=" + consulta + "]";
	}


	


	
	
}
