package com.ite.proyectos.modelo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.proyectos.modelo.beans.Producto;

@Repository
public class ListImplProducto implements IntProductoDao {
	
	private List<Producto> listaProductos;

	public ListImplProducto() {
		super();
		cargarProductos();
	}
	
	private void cargarProductos() {
		listaProductos = new ArrayList<Producto>();
		
		listaProductos.add(new Producto(1, "Monitor estándar", "Monitor 22 pulgadas", new BigDecimal(125L), 75));
		listaProductos.add(new Producto(2, "Monitor diseño", "Monitor 32 pulgadas ultrawide", new BigDecimal(450L), 20));
		listaProductos.add(new Producto(3, "PC oficina", "Barebone AMD", new BigDecimal(460L), 40));
		listaProductos.add(new Producto(4, "PC diseño", "Torre Intel", new BigDecimal(1250L), 15));
		listaProductos.add(new Producto(5, "Portátil multiusos", "MacBook Pro 16", new BigDecimal(2750L), 28));
		listaProductos.add(new Producto(6, "Servidor básico", "Rack Xeon", new BigDecimal(720L), 25));
		listaProductos.add(new Producto(7, "Servidor alto rendimiento", "Rack doble Xeon", new BigDecimal(1950L), 10));
		listaProductos.add(new Producto(8, "Silla estática", "Silla sala de espera", new BigDecimal(75L), 120));
		listaProductos.add(new Producto(9, "Silla oficina", "Silla puesto de trabajo", new BigDecimal(220L), 70));
	}
	
	@Override
	public Producto findById(int idProducto) {
		Producto aux = new Producto();
		aux.setIdProducto(idProducto);
		int pos = listaProductos.indexOf(aux);
		if (pos == -1)
			return null;
		else
			return listaProductos.get(pos);
	}
	
	

}
