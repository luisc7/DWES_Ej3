package com.ite.proyectos.modelo.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.ite.proyectos.modelo.beans.Departamento;
import com.ite.proyectos.modelo.beans.Empleado;
import com.ite.proyectos.modelo.beans.Perfile;

public interface IntEmpleadoDao {
	int addNewEmpleado(String correo, Date fechaIngreso, Date fechaNacimiento, String nombre, BigDecimal salario,
			Departamento departamento, Perfile perfile, String password);
	Empleado findById(int idEmpleado);
	ListImplPerfile SacarListaPerfiles();
	List<Empleado> listarJefes();
	
	
}
