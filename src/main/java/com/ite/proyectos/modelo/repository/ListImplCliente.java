package com.ite.proyectos.modelo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.proyectos.modelo.beans.Cliente;


@Repository
public class ListImplCliente implements IntClienteDao {
	
	private List<Cliente> listaClientes;
}
