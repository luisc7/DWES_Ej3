package com.ite.proyectos.modelo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.proyectos.modelo.beans.Cliente;
import com.ite.proyectos.modelo.beans.Empleado;


@Repository
public class ListImplCliente implements IntClienteDao {
	
	private List<Cliente> listaClientes;
	
	public ListImplCliente() {
		listaClientes = new ArrayList<Cliente>();
		cargarClientes();
	}
	
	private void cargarClientes() {
		listaClientes.add(new Cliente("1A", "Calle I", new BigDecimal(81000L), "Unai", 34));
		listaClientes.add(new Cliente("2B", "Calle II", new BigDecimal(527000L), "Desu", 76));
		listaClientes.add(new Cliente("3C", "Calle III", new BigDecimal(15000L), "Trix", 3));
		listaClientes.add(new Cliente("4D", "Calle IV", new BigDecimal(312000L), "Corinto", 54));
		listaClientes.add(new Cliente("5E", "Calle V", new BigDecimal(2000L), "Pentalo", 1));
		listaClientes.add(new Cliente("6F", "Calle VI", new BigDecimal(24000L), "Sixto", 4));
		listaClientes.add(new Cliente("7G", "Calle VII", new BigDecimal(978000L), "Séptúgalo", 127));
		listaClientes.add(new Cliente("8H", "Calle VIII", new BigDecimal(54000L), "Octoplus", 25));
	}
	
	@Override
	public List<Cliente> listarClientes() {
		return listaClientes;
	}
	
	@Override
	public Cliente findByCif(String cif) {
		Cliente aux = new Cliente();
		aux.setCif(cif);
		int pos = listaClientes.indexOf(aux);
		if (pos == -1)
			return null;
		else
			return listaClientes.get(pos);
	}
}
