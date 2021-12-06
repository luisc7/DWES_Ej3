package com.ite.proyectos.modelo.repository;

import java.util.Date;
import java.util.List;

import com.ite.proyectos.modelo.beans.Empleado;
import com.ite.proyectos.modelo.beans.Proyecto;
import com.ite.proyectos.modelo.beans.ProyectoConEmpleado;

public interface IntProyectoConEmpleadoDao {

	int addNewProyectoConEmpleado(Proyecto proyecto, Empleado empleado);
	List<ProyectoConEmpleado> listaEmpleadosEnProyecto(Proyecto proyecto);
	ProyectoConEmpleado empleadoEnProyecto(Proyecto proyecto, Empleado empleado);
	int asignarEmpleadoAProyecto(Proyecto proyecto, Empleado empleado, int horasAsignadas, Date fechaIncorporacion);

}
