package com.ite.proyectos.modelo.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public class Proyecto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String idProyecto;
	private BigDecimal costeReal;
	private BigDecimal costesPrevisto;
	private String descripcion;
	private String estado;
	private Date fechaFinPrevisto;
	private Date fechaFinReal;
	private Date fechaInicio;
	private BigDecimal ventaPrevisto;	
	private List<ProyectoConEmpleado> proyectoConEmpleados;	
	private Cliente cliente;	
	private Empleado jefeProyecto;

	public Proyecto() {
	}

	public String getIdProyecto() {
		return this.idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	public BigDecimal getCosteReal() {
		return this.costeReal;
	}

	public void setCosteReal(BigDecimal costeReal) {
		this.costeReal = costeReal;
	}

	public BigDecimal getCostesPrevisto() {
		return this.costesPrevisto;
	}

	public void setCostesPrevisto(BigDecimal costesPrevisto) {
		this.costesPrevisto = costesPrevisto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaFinPrevisto() {
		return this.fechaFinPrevisto;
	}

	public void setFechaFinPrevisto(Date fechaFinPrevisto) {
		this.fechaFinPrevisto = fechaFinPrevisto;
	}

	public Date getFechaFinReal() {
		return this.fechaFinReal;
	}

	public void setFechaFinReal(Date fechaFinReal) {
		this.fechaFinReal = fechaFinReal;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public BigDecimal getVentaPrevisto() {
		return this.ventaPrevisto;
	}

	public void setVentaPrevisto(BigDecimal ventaPrevisto) {
		this.ventaPrevisto = ventaPrevisto;
	}

	public List<ProyectoConEmpleado> getProyectoConEmpleados() {
		return this.proyectoConEmpleados;
	}

	public void setProyectoConEmpleados(List<ProyectoConEmpleado> proyectoConEmpleados) {
		this.proyectoConEmpleados = proyectoConEmpleados;
	}

	public ProyectoConEmpleado addProyectoConEmpleado(ProyectoConEmpleado proyectoConEmpleado) {
		getProyectoConEmpleados().add(proyectoConEmpleado);
		proyectoConEmpleado.setProyecto(this);

		return proyectoConEmpleado;
	}

	public ProyectoConEmpleado removeProyectoConEmpleado(ProyectoConEmpleado proyectoConEmpleado) {
		getProyectoConEmpleados().remove(proyectoConEmpleado);
		proyectoConEmpleado.setProyecto(null);

		return proyectoConEmpleado;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getJefeProyecto() {
		return this.jefeProyecto;
	}

	public void setJefeProyecto(Empleado jefeProyecto) {
		this.jefeProyecto = jefeProyecto;
	}

}