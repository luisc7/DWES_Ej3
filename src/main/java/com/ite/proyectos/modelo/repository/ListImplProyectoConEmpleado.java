package com.ite.proyectos.modelo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.proyectos.modelo.beans.Empleado;
import com.ite.proyectos.modelo.beans.Proyecto;
import com.ite.proyectos.modelo.beans.ProyectoConEmpleado;

@Repository
public class ListImplProyectoConEmpleado implements IntProyectoConEmpleadoDao {

	private List<ProyectoConEmpleado> listaProyectoConEmpleado;
	private int refNuevoProyConEmpl = 1;
	
	public ListImplProyectoConEmpleado() {
		listaProyectoConEmpleado = new ArrayList<ProyectoConEmpleado>();
	}
	
	@Override
	public int addNewProyectoConEmpleado(Proyecto proyecto, Empleado empleado) {
		if (listaProyectoConEmpleado.add(new ProyectoConEmpleado(refNuevoProyConEmpl++, null, 0, empleado, proyecto)))
			return 1;
		else
			return 0;
	}
	
	@Override
	public List<ProyectoConEmpleado> listaEmpleadosEnProyecto(Proyecto proyecto) {
		List<ProyectoConEmpleado> empleadosEnProyecto = new ArrayList<ProyectoConEmpleado>();
		for (ProyectoConEmpleado eleProyConEmpl: empleadosEnProyecto) {
			if (eleProyConEmpl.getProyecto().equals(proyecto))
				empleadosEnProyecto.add(eleProyConEmpl);
		}
		return empleadosEnProyecto;
	}
	
	@Override
	public ProyectoConEmpleado empleadoEnProyecto(Proyecto proyecto, Empleado empleado) {
		ProyectoConEmpleado aux = new ProyectoConEmpleado();
		aux.setProyecto(proyecto);
		aux.setEmpleado(empleado);
		int pos = listaProyectoConEmpleado.indexOf(aux);
		if (pos == -1)
			return null;
		else
			return listaProyectoConEmpleado.get(pos);
	}
	
	@Override
	public int asignarEmpleadoAProyecto(Proyecto proyecto, Empleado empleado, int horasAsignadas, Date fechaIncorporacion) {
		ProyectoConEmpleado aux = new ProyectoConEmpleado();
		aux.setProyecto(proyecto);
		aux.setEmpleado(empleado);
		aux.setHorasAsignadas(horasAsignadas);
		aux.setFechaIncorporacion(fechaIncorporacion);
		int pos = listaProyectoConEmpleado.indexOf(aux);
		if (pos > 0) {
			aux = listaProyectoConEmpleado.get(pos);
			listaProyectoConEmpleado.set(pos, aux);
			return 1;
		} else {
			listaProyectoConEmpleado.add(aux);
			return 0;
		}
			
	}
}
