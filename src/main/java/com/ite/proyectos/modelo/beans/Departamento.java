package com.ite.proyectos.modelo.beans;

import java.io.Serializable;



public class Departamento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idDepar;
	private String direccion;
	private String nombre;	
	private Empleado jefeDepar;

	public Departamento() {
	}

	public int getIdDepar() {
		return this.idDepar;
	}

	public void setIdDepar(int idDepar) {
		this.idDepar = idDepar;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Empleado getJefeDepar() {
		return this.jefeDepar;
	}

	public void setJefeDepar(Empleado jefeDepar) {
		this.jefeDepar = jefeDepar;
	}

}