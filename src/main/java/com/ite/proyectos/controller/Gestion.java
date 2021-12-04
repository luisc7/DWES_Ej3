package com.ite.proyectos.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ite.proyectos.modelo.beans.Empleado;
import com.ite.proyectos.modelo.repository.IntProyectoDao;

@Controller
@RequestMapping("/gestion")
public class Gestion {
	
	@Autowired
	IntProyectoDao iproyectos;
	
	@GetMapping("")
	public String inicioGestion(HttpSession sesionEmpleado) {
		Empleado empleadoActivo = (Empleado)sesionEmpleado.getAttribute("empleadoActivo");
		if (empleadoActivo.getPerfile().getIdPerfil()==1)
			return "gestionpanel";
		else
			return "redirect:/login";
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
