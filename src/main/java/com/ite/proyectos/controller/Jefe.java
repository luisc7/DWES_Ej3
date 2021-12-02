package com.ite.proyectos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jefe")
public class Jefe {
	
	@GetMapping
	public String ListarProyectos() {
		return "listarproyectos";
	}
	
	@GetMapping
	public String VerDetalle() {
		return "detalle";
	}
	

}
