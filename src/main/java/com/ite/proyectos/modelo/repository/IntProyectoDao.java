package com.ite.proyectos.modelo.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.ite.proyectos.modelo.beans.Cliente;
import com.ite.proyectos.modelo.beans.Empleado;
import com.ite.proyectos.modelo.beans.Proyecto;

public interface IntProyectoDao {

	String altaProyecto(BigDecimal costesPrevisto, String descripcion, Date fechaFinPrevisto, Date fechaInicio,
			BigDecimal ventaPrevisto, Cliente cliente, Empleado jefeProyecto);

	List<Proyecto> listarProyectos();
	

}
