package com.ite.proyectos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jefe")
public class Jefe {
	
	@GetMapping("/proyectos")
	public String ListarProyectos() {
		return "listarproyectos";
	}
	
	@GetMapping("/verDetalle")
	public String VerDetalle() {
		return "detalle";
	}
	

}
