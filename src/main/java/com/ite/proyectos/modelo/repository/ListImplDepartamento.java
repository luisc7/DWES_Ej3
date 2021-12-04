package com.ite.proyectos.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.proyectos.modelo.beans.Departamento;
import com.ite.proyectos.modelo.beans.Empleado;

@Repository
public class ListImplDepartamento implements IntDepartamentoDao{
	
	private List<Departamento> listaDepartamentos = new ArrayList<Departamento>();
	private int refDpto = 1;
	
	

	public ListImplDepartamento() {
		super();
		cargarDptosIniciales();
	}
	
	private void cargarDptosIniciales() {
		listaDepartamentos.add(new Departamento(1, "C/ Alfa", "RRHH", null));
		listaDepartamentos.add(new Departamento(2, "C/ Beta", "Ventas", null));
		listaDepartamentos.add(new Departamento(3, "C/ Gamma", "Gestión", null));
		listaDepartamentos.add(new Departamento(4, "C/ Delta", "Dirección", null));
		listaDepartamentos.add(new Departamento(5, "C/ Epsilon", "Técnico", null));
		refDpto = 6;
	}

	@Override
	public int crearDpto(String nombre) {
		Departamento aux = new Departamento(refDpto, null, nombre, null);
		if (listaDepartamentos.add(aux))
			return refDpto++;
		else
			return 0;
	}

	@Override
	public int crearDpto(String nombre, String direccion) {
		Departamento aux = new Departamento(refDpto, direccion, nombre, null);
		if (listaDepartamentos.add(aux))
			return refDpto++;
		else
			return 0;
	}

	@Override
	public Departamento findById(int idDepartamento) {
		return findInList(idDepartamento);
	}
	
	private Departamento findInList(int idDepartamento) {
		Departamento auxDepartamento = new Departamento();
		auxDepartamento.setIdDepar(idDepartamento);
		int pos = listaDepartamentos.indexOf(auxDepartamento);
		if (pos == -1)
			return null;
		else
			return listaDepartamentos.get(pos);
	}
	
	@Override
	public int fijarJefeDpto (Departamento departamento, Empleado empleado ) {
	/**
	 * @return int Si no existe el dpto pasado, devuelve -1.
	 * Si existe pero ha habido problemas al cambiarlo, devuelve 0.
	 * Si ha podido actualizar el jefe de departamento, devuelve 1
	 */
		if (!listaDepartamentos.contains(departamento))
			return -1;
		else {
			int posicionEnListaDpto = listaDepartamentos.indexOf(departamento);
			Departamento aux = findInList(posicionEnListaDpto);
			aux.setJefeDepar(empleado);
			// Boolean borrar = listaDepartamentos.remove(posicionEnListaDpto)==departamento;
			// Boolean addDptoConCambios = listaDepartamentos.add(aux);
			// if (borrar && addDptoConCambios)
			if (listaDepartamentos.set(posicionEnListaDpto, aux) == aux)
				return 1;
			else
				return 0;
		}
	}

}
