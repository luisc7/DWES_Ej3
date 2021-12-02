package com.ite.proyectos.modelo.beans;

import java.io.Serializable;
import java.math.BigDecimal;


public class ProyectoConProducto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int numeroOrden;
	private int cantidad;
	private BigDecimal precioAsignado;
	private Producto producto;
	private Proyecto proyecto;

	public ProyectoConProducto() {
	}

	public int getNumeroOrden() {
		return this.numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioAsignado() {
		return this.precioAsignado;
	}

	public void setPrecioAsignado(BigDecimal precioAsignado) {
		this.precioAsignado = precioAsignado;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}