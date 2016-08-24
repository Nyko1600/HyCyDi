package com.sistema.pojo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.Mapping;

@Entity
@Table(name="historiaclinica")
public class HistoriaClinica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_historia;
	private int nro_historia;
	
	@OneToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	@OneToMany(mappedBy="historia")
	private Set<Ficha> ficha;
	
	
	public int getId_historia() {
		return id_historia;
	}

	public void setId_historia(int id_historia) {
		this.id_historia = id_historia;
	}

	public int getNro_historia() {
		return nro_historia;
	}

	public void setNro_historia(int nro_historia) {
		this.nro_historia = nro_historia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "HistoriaClinica [id_historia=" + id_historia + ", nro_historia=" + nro_historia + ", usuario=" + usuario
				+ "]";
	}

	public Set<Ficha> getFicha() {
		return ficha;
	}

	public void setFicha(Set<Ficha> ficha) {
		this.ficha = ficha;
	}

	
	
	
	
}
