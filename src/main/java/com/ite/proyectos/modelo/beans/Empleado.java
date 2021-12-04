package com.ite.proyectos.modelo.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the empleados database table.
 * 
 */
public class Empleado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idEmpl;
	private String correo;	
	private Date fechaIngreso;	
	private Date fechaNacimiento;
	private String nombre;
	private BigDecimal salario;	
	private Departamento departamento;	
	private Perfile perfile;
	private String password;

	public Empleado() {
	}

	public Empleado(int idEmpl, String correo, Date fechaIngreso, Date fechaNacimiento, String nombre,
			BigDecimal salario, Departamento departamento, Perfile perfile, String password) {
		super();
		this.idEmpl = idEmpl;
		this.correo = correo;
		this.fechaIngreso = fechaIngreso;
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
		this.salario = salario;
		this.departamento = departamento;
		this.perfile = perfile;
		this.password = password;
	}

	public int getIdEmpl() {
		return this.idEmpl;
	}

	public void setIdEmpl(int idEmpl) {
		this.idEmpl = idEmpl;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getSalario() {
		return this.salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Perfile getPerfile() {
		return this.perfile;
	}

	public void setPerfile(Perfile perfile) {
		this.perfile = perfile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEmpl;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Empleado))
			return false;
		Empleado other = (Empleado) obj;
		if (idEmpl != other.idEmpl)
			return false;
		return true;
	}

}