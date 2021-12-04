package com.ite.proyectos.modelo.repository;

import java.math.BigDecimal;
import java.util.Date;

import com.ite.proyectos.modelo.beans.Cliente;
import com.ite.proyectos.modelo.beans.Empleado;

public interface IntProyectoDao {

	String altaProyecto(BigDecimal costesPrevisto, String descripcion, Date fechaFinPrevisto, Date fechaInicio,
			BigDecimal ventaPrevisto, Cliente cliente, Empleado jefeProyecto);

}
