package test;

import com.ite.proyectos.modelo.repository.IntPerfileDao;
import com.ite.proyectos.modelo.repository.ListImplPerfile;

public class TestPerfile {

	public static void main(String[] args) {
		IntPerfileDao perfiles = new ListImplPerfile();
		System.out.println(perfiles.getNombrePerfil(1));
		System.out.println(perfiles.getNombrePerfil(2));
		System.out.println(perfiles.getNombrePerfil(3));

	}

}
