package com.ite.proyectos.modelo.repository;

import com.ite.proyectos.modelo.beans.Departamento;
import com.ite.proyectos.modelo.beans.Empleado;

public interface IntDepartamentoDao {
	int crearDpto(String nombre);	
	int crearDpto(String nombre, String direccion);
	Departamento findById(int departamento);
	int fijarJefeDpto(Departamento departamento, Empleado empleado);

}
