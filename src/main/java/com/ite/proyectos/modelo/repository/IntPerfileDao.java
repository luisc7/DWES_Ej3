package com.ite.proyectos.modelo.repository;

import com.ite.proyectos.modelo.beans.Perfile;

public interface IntPerfileDao {
	
	String getNombrePerfil(int idPerfil);
	Perfile getPerfil(int idPerfil);

}
