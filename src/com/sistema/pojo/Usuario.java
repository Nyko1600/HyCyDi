package com.sistema.pojo;


import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.context.annotation.Scope;

import com.sistema.util.JsonDateDeserialize;
import com.sistema.util.JsonDateSerialize;



@Entity
@Table(name="usuario")
@Scope("session")
public class Usuario{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuario;
	@Column(name="nro_doc")
	private int nro_doc;
	private int matricula;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String mail;
	@JsonIgnore
	private String password;
	private String foto;
	private String telefono;
	private String sexo;
	private String fechaNacimiento;
	@JsonIgnore
	private Timestamp fechaAlta;
	private String grupoSanguineo;
	private String estadoCivil;
	private String categoria;
	private String rol;
	private String estado;
	
	//Carga Temprana.... relación tipo casacada.
	@JsonIgnore
	@OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Domicilio domicilio;
	
	@JsonIgnore
	@OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private HistoriaClinica historia;
	
	public Usuario(){}	
	
	public Usuario(int id_usuario, int nro_doc, int matricula, String nombre, String apellido1, String apellido2,
			String mail, String password, String foto, String telefono, String sexo, String fechaNacimiento,
			Timestamp fechaAlta, String grupoSanguineo, String estadoCivil, String categoria, String rol,
			String estado) {
		super();
		this.id_usuario = id_usuario;
		this.nro_doc = nro_doc;
		this.matricula = matricula;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.mail = mail;
		this.password = password;
		this.foto = foto;
		this.telefono = telefono;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaAlta = fechaAlta;
		this.grupoSanguineo = grupoSanguineo;
		this.estadoCivil = estadoCivil;
		this.categoria = categoria;
		this.rol = rol;
		this.estado = estado;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public int getNroDoc() {
		return nro_doc;
	}
	public void setNroDoc(int nro_doc) {
		this.nro_doc = nro_doc;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	@JsonIgnore
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	//@JsonSerialize(using=JsonDateSerialize.class)
	@JsonIgnore
	public Timestamp getFechaAlta() {
		return fechaAlta;
	}
	

	//@JsonDeserialize(using = JsonDateDeserialize.class, as = Timestamp.class)
	@JsonIgnore
	public void setFechaAlta(Timestamp fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}
	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	@JsonIgnore
	public Domicilio getDomicilio() {
		return domicilio;
	}
	
	
	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	@JsonIgnore
	public HistoriaClinica getHistoria() {
		return historia;
	}

	public void setHistoria(HistoriaClinica historia) {
		this.historia = historia;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nro_doc=" + nro_doc + ", matricula=" + matricula + ", nombre=" + nombre
				+ ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", mail=" + mail + ", password=" + password
				+ ", foto=" + foto + ", telefono=" + telefono + ", sexo=" + sexo + ", fechaNacimiento="
				+ fechaNacimiento + ", fechaAlta=" + fechaAlta + ", grupoSanguineo=" + grupoSanguineo + ", estadoCivil="
				+ estadoCivil + ", categoria=" + categoria + ", rol=" + rol + ", estado=" + estado + "]";
	}
	
	
}
