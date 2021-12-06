package com.ite.proyectos.modelo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.proyectos.modelo.beans.Cliente;
import com.ite.proyectos.modelo.beans.Empleado;
import com.ite.proyectos.modelo.beans.Proyecto;
import com.ite.proyectos.modelo.beans.ProyectoConEmpleado;

@Repository
public class ListImplProyecto implements IntProyectoDao {
	
	private List<Proyecto> listaProyectos;
	
	private Integer indiceProyecto=1;
	
	public ListImplProyecto() {
		listaProyectos = new ArrayList<Proyecto>();
	}
	
	@Override
	public Proyecto altaProyecto(
			BigDecimal costesPrevisto, 
			String descripcion,
			Date fechaFinPrevisto,
			Date fechaInicio,
			BigDecimal ventaPrevisto, 
			Cliente cliente,
			Empleado jefeProyecto) {
		
		Proyecto proyecto = new Proyecto(
				indiceProyecto.toString(), 
				null, 
				costesPrevisto, 
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
			//return proyecto.getIdProyecto();
			return proyecto;
		} else
			return null;
	}
	
	@Override
	public List<Proyecto> listarProyectos() {
		return listaProyectos;
	}
	
	@Override
	public Proyecto findById(String idProyecto) {
		Proyecto aux = new Proyecto();
		aux.setIdProyecto(idProyecto);
		int pos = listaProyectos.indexOf(aux);
		if (pos == -1)
			return null;
		else
			return listaProyectos.get(pos);
	}
	
	@Override
	public List<Proyecto> listarProyectosJefe(Empleado jefe) {
		List<Proyecto> proyectosJefe = new ArrayList<Proyecto>();
		for (Proyecto eleProyecto : listaProyectos) {
			if (eleProyecto.getJefeProyecto().equals(jefe)) {
				proyectosJefe.add(eleProyecto);
			}
		}
		return proyectosJefe;
	}

	@Override
	public int terminarProyecto(String idProyecto, BigDecimal costeReal, Date fechaFinReal) {
		Proyecto aux = new Proyecto();
		aux.setIdProyecto(idProyecto);
		int pos = listaProyectos.indexOf(aux);
		if (pos == -1) {
			System.out.println("Entra en cero...");
			return 0;
		} else {
			aux = listaProyectos.get(pos);
			aux.setEstado("Terminado");
			System.out.println(aux.getEstado());
			aux.setCosteReal(costeReal);
			aux.setFechaFinReal(fechaFinReal);
			listaProyectos.set(pos, aux);

			System.out.println(listaProyectos.get(pos).getEstado());
			return 1;
		}
	}
	
	@Override
	public int cargaInicialProyectosConEmpleado(Proyecto proyecto, List<Empleado> listaEmpleados) {
		//Proyecto aux = new Proyecto();
		//aux.setIdProyecto(idProyecto);
		int pos = listaProyectos.indexOf(proyecto);
		if (pos == -1)
			return -1;
		else {
			//aux = listaProyectos.get(pos);
			List<ProyectoConEmpleado> proyectoConEmpleados = new ArrayList<ProyectoConEmpleado>();
			for (Empleado empleado:listaEmpleados) {
				int orden = 0;
				proyectoConEmpleados.add(new ProyectoConEmpleado(++orden, null, 0, empleado, proyecto));
			}
			proyecto.setProyectoConEmpleados(proyectoConEmpleados);
			listaProyectos.set(pos, proyecto);
			return 1;
		}
	}
}
