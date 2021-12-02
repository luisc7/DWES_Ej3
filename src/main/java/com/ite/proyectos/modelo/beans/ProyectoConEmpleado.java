package com.ite.proyectos.modelo.beans;

import java.io.Serializable;
import java.util.Date;


public class ProyectoConEmpleado implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int numeroOrden;
	private Date fechaIncorporacion;
	private int horasAsignadas;	
	private Empleado empleado;
	private Proyecto proyecto;

	public ProyectoConEmpleado() {
	}

	public int getNumeroOrden() {
		return this.numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public Date getFechaIncorporacion() {
		return this.fechaIncorporacion;
	}

	public void setFechaIncorporacion(Date fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}

	public int getHorasAsignadas() {
		return this.horasAsignadas;
	}

	public void setHorasAsignadas(int horasAsignadas) {
		this.horasAsignadas = horasAsignadas;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}