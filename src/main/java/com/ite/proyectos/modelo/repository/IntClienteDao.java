package com.ite.proyectos.modelo.repository;

import java.util.List;

import com.ite.proyectos.modelo.beans.Cliente;

public interface IntClienteDao {

	List<Cliente> listarClientes();
	Cliente findByCif(String cif);

}
