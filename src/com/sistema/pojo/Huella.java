package com.sistema.pojo;



import java.util.Arrays;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.context.annotation.Scope;



@Entity
@Table(name="huelladigital")
public class Huella{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_huella;
	private int id_usuario;
	private String dedo;
	private byte[] huella;
	
	
	public Huella(){}
	
	public Huella(int id_usuario, String dedo, byte[] huella) {
		this.id_usuario = id_usuario;
		this.dedo = dedo;
		this.huella = huella;
	}

	public int getId_huella() {
		return id_huella;
	}

	public void setId_huella(int id_huella) {
		this.id_huella = id_huella;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getDedo() {
		return dedo;
	}

	public void setDedo(String dedo) {
		this.dedo = dedo;
	}

	public byte[] getHuella() {
		return huella;
	}

	public void setHuella(byte[] huella) {
		this.huella = huella;
	}

	@Override
	public String toString() {
		return "Huella [id_huella=" + id_huella + ", id_usuario=" + id_usuario + ", dedo=" + dedo + ", huella="
				+ Arrays.toString(huella) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dedo == null) ? 0 : dedo.hashCode());
		result = prime * result + Arrays.hashCode(huella);
		result = prime * result + id_huella;
		result = prime * result + id_usuario;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Huella other = (Huella) obj;
		if (dedo == null) {
			if (other.dedo != null)
				return false;
		} else if (!dedo.equals(other.dedo))
			return false;
		if (!Arrays.equals(huella, other.huella))
			return false;
		if (id_huella != other.id_huella)
			return false;
		if (id_usuario != other.id_usuario)
			return false;
		return true;
	}
	
	
	

	
	
	
	
}
