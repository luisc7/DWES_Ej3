package com.ite.proyectos.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.proyectos.modelo.beans.Perfile;

@Repository
public class ListImplPerfile implements IntPerfileDao {
	
	private List<Perfile> listaPerfiles;
	
	public ListImplPerfile() {
		listaPerfiles = new ArrayList<Perfile>();
		cargarPerfiles();
	}
	
	private void cargarPerfiles() {
		listaPerfiles.add(new Perfile(1, "Control de Gestión"));
		listaPerfiles.add(new Perfile(2, "Jefe de proyecto"));
		listaPerfiles.add(new Perfile(3, "Operativo"));
		listaPerfiles.add(new Perfile(4, "Recursos Humanos"));
	}
	
	@Override
	public String getNombrePerfil(int idPerfil) {
		Perfile auxPerfile = new Perfile();
		auxPerfile.setIdPerfil(idPerfil);
		int pos = listaPerfiles.indexOf(auxPerfile);
		if (pos == -1)
			return null;
		else
			return listaPerfiles.get(pos).getNombre();
	}
	
	@Override
	public Perfile getPerfil(int idPerfil) {
		Perfile auxPerfile = new Perfile();
		auxPerfile.setIdPerfil(idPerfil);
		int pos = listaPerfiles.indexOf(auxPerfile);
		if (pos == -1)
			return null;
		else
			return listaPerfiles.get(pos);
	}

}
