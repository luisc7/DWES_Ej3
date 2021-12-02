package com.ite.proyectos.modelo.beans;

import java.io.Serializable;


public class Perfile implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idPerfil;
	private String nombre;

	public Perfile() {
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

}