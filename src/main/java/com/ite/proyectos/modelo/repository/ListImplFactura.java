package com.ite.proyectos.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.proyectos.modelo.beans.Factura;
import com.ite.proyectos.modelo.beans.Proyecto;

@Repository
public class ListImplFactura implements IntFacturaDao {
	
	private List<Factura> listaFacturas;
	
	public ListImplFactura() {
		listaFacturas = new ArrayList<Factura>();
	}
	
	public int AddFactura(String idFactura, String descripcion, Proyecto proyecto) {
		/**
		 * Si se puede añadir la factura al listado, devuelve 1.
		 * Si no se puede añadir la factura al listado , devuelve 0.
		 */
		if(listaFacturas.add(new Factura(idFactura, descripcion, proyecto)))
			return 1;
		else
			return 0;
	}
	

	public List<Factura> findAll() {
		return listaFacturas;
	}
	
	public List<Factura> FacturasProyecto(Proyecto proyecto) {
		List<Factura> auxFacturas = new ArrayList<Factura>();
		for (Factura factura: listaFacturas) {
			if (factura.getProyecto().equals(proyecto))
				auxFacturas.add(factura);
		}
		return auxFacturas;
	}

}
