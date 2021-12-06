package com.ite.proyectos.modelo.repository;

import com.ite.proyectos.modelo.beans.Producto;

public interface IntProductoDao {
	Producto findById(int idProducto);
}
