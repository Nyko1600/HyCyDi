package com.sistema.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="domicilio")
public class Domicilio {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_domicilio;
	
	private String provincia;
	private String localidad;
	private String direccion;
	
	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	public Domicilio(){}
	
	
	public Domicilio(int id_dom,String provincia, String localidad, String direccion) {
		this.id_domicilio = id_dom;
		this.provincia = provincia;
		this.localidad = localidad;
		this.direccion = direccion;
	}
	public Domicilio(String provincia, String localidad, String direccion) {
	
		this.provincia = provincia;
		this.localidad = localidad;
		this.direccion = direccion;
	}
	public int getId_domicilio() {
		return id_domicilio;
	}
	public void setId_domicilio(int id_domicilio) {
		this.id_domicilio = id_domicilio;
	}
	
	
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	@Override
	public String toString() {
		return "Domicilio [id_domicilio=" + id_domicilio + ", provincia=" + provincia + ", localidad=" + localidad
				+ ", direccion=" + direccion + "]";
	}
	
	

	
	
}
