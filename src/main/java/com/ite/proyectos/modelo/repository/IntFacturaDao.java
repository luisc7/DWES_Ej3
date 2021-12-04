package com.ite.proyectos.modelo.repository;

import java.util.List;

import com.ite.proyectos.modelo.beans.Factura;
import com.ite.proyectos.modelo.beans.Proyecto;

public interface IntFacturaDao {
	int AddFactura(String idFactura, String descripcion, Proyecto proyecto);
	List<Factura> findAll();
	List<Factura> FacturasProyecto(Proyecto proyecto);
}
