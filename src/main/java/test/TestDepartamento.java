package test;

import com.ite.proyectos.modelo.repository.IntDepartamentoDao;
import com.ite.proyectos.modelo.repository.ListImplDepartamento;

public class TestDepartamento {

	public static void main(String[] args) {
		IntDepartamentoDao idep = new ListImplDepartamento();
		System.out.println("Departamento con id = 1: ");
		System.out.println(idep.findById(1).toString());

		System.out.println("Departamento con id = 2: ");
		System.out.println(idep.findById(2).toString());
		
		idep.crearDpto("apuestas");
		System.out.println("\n " + idep);

	}

}
