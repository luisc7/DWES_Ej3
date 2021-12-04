package com.ite.proyectos.modelo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.proyectos.modelo.beans.Cliente;
import com.ite.proyectos.modelo.beans.Empleado;
import com.ite.proyectos.modelo.beans.Proyecto;

@Repository
public class ListImplProyecto implements IntProyectoDao {
	
	private List<Proyecto> listaProyectos;
	
	private Integer indiceProyecto=1;
	
	public ListImplProyecto() {
		listaProyectos = new ArrayList<Proyecto>();
	}
	
	@Override
	public String altaProyecto(
			BigDecimal costesPrevisto, 
			String descripcion,
			Date fechaFinPrevisto,
			Date fechaInicio,
			BigDecimal ventaPrevisto, 
			Cliente cliente,
			Empleado jefeProyecto) {
		
		Proyecto proyecto = new Proyecto(
				indiceProyecto.toString(), 
				costesPrevisto, 
				null, 
				descripcion, 
				"activo", 
				fechaFinPrevisto, 
				null, 
				fechaInicio,
				ventaPrevisto, 
				null, 
				cliente,
				jefeProyecto);
		
		if (listaProyectos.add(proyecto)) {
			indiceProyecto++;
			return proyecto.getIdProyecto();
		} else
			return null;
	}
}
