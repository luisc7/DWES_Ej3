package com.ite.proyectos.modelo.beans;

import java.io.Serializable;
import java.util.Objects;


public class Perfile implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idPerfil;
	private String nombre;

	public Perfile() {
		super();
	}	

	public Perfile(int idPerfil, String nombre) {
		super();
		this.idPerfil = idPerfil;
		this.nombre = nombre;
	}

	public int getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPerfil);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perfile other = (Perfile) obj;
		return idPerfil == other.idPerfil;
	}

}