package com.ite.proyectos.modelo.repository;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ite.proyectos.modelo.beans.Departamento;
import com.ite.proyectos.modelo.beans.Empleado;
import com.ite.proyectos.modelo.beans.Perfile;

@Repository
public class ListImplEmpleado implements IntEmpleadoDao {
	
	private List<Empleado> listaEmpleados;
	
	
	private ListImplPerfile perfilEmpleados;
	
	private ListImplDepartamento departamentos;
	
	private int refNuevoEmpleado = 1;
	
	public ListImplEmpleado() throws ParseException {
		listaEmpleados = new ArrayList<Empleado>();
		cargaEmpleados();
	}
	
	private void cargaEmpleados() throws ParseException {
		perfilEmpleados = new ListImplPerfile();
		departamentos = new ListImplDepartamento();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		addNewEmpleado("a@a.a", new Date(), format.parse("1990-01-01"), "Primitivo", new BigDecimal(12000L), departamentos.findById(3), perfilEmpleados.getPerfil(3), "uno");
		addNewEmpleado("b@b.b", new Date(), format.parse("1992-02-02"), "Segundino", new BigDecimal(20000L), departamentos.findById(3), perfilEmpleados.getPerfil(3), "dos");
		addNewEmpleado("c@c.c", new Date(), format.parse("1983-03-03"), "Trifecto", new BigDecimal(31000L), departamentos.findById(3), perfilEmpleados.getPerfil(2), "tres");
		addNewEmpleado("d@d.d", new Date(), format.parse("1974-04-04"), "Cuaternario", new BigDecimal(43000L), departamentos.findById(3), perfilEmpleados.getPerfil(3), "cuatro");
		addNewEmpleado("e@e.e", new Date(), format.parse("1970-01-01"), "Quintiliano", new BigDecimal(52000L), departamentos.findById(3), perfilEmpleados.getPerfil(1), "cinco");
	}
	
	@Override
	public int addNewEmpleado(
			/**
			 * Devuelve el id de empelado si se ha añadido
			 * Devuelve -1 si no se ha añadido
			 */
			String correo,	
			Date fechaIngreso,	
			Date fechaNacimiento,
			String nombre,
			BigDecimal salario,
			Departamento departamento,	
			Perfile perfile, 
			String password) {
		if (listaEmpleados.add(new Empleado(refNuevoEmpleado, correo, fechaIngreso, fechaNacimiento, nombre, salario, departamento, perfile, password)))			
			return refNuevoEmpleado++;
		else
			return -1;		
	}
	
	@Override
	public Empleado findById(int idEmpleado) {
		Empleado aux = new Empleado();
		aux.setIdEmpl(idEmpleado);
		int pos = listaEmpleados.indexOf(aux);
		if (pos == -1)
			return null;
		else
			return listaEmpleados.get(pos);
	}
	
	@Override
	public ListImplPerfile SacarListaPerfiles() {
		return perfilEmpleados;
	}
}
