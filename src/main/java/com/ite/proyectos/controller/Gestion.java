package com.ite.proyectos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gestion")
public class Gestion {
	
	@GetMapping("/")
	public String inicioGestion() {
		return "gestion";
	}
	
	@GetMapping("/altaProyecto")
	public String altaProyecto() {
		return "altaproyecto";
	}
	
	@GetMapping("/terminarProyecto")
	public String terminarProyecto() {
		return "formTerminarProyecto";
	}
	
	@PostMapping("/terminarProyecto")
	public String terminarProyectoPost() {
		return "redirect:/gestion";
	}
	
	/*@GetMapping("/altaProducto")
	public String altaProducto() {
		return "altaproducto";
	}
	
	@PostMapping("/altaProducto")
	public String altaProductoPost() {
		return "redirect:/gestion";
	}*/
}
