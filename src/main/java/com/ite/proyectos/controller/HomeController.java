package com.ite.proyectos.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.proyectos.modelo.beans.Empleado;
//import com.ite.proyectos.modelo.repository.IntClienteDao;
import com.ite.proyectos.modelo.repository.IntEmpleadoDao;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private final int gestion = 1;
	private final int jefe = 2;
	//private final int operativo = 3;
	//private final int recursosHumanos = 4;
	
	@Autowired
	private IntEmpleadoDao iempleados;
	
	//@Autowired
	//private IntClienteDao iclientes;
	
	@GetMapping("/")
	public String inicio(HttpSession sesionEmpleado) {
		/**
		 * Aquí dirijo al login si no hay empleado logeado
		 */
		Empleado empleadoActivo = (Empleado) sesionEmpleado.getAttribute("empleadoActivo");
		if (empleadoActivo == null)
			return "redirect:/login";		
		else {
			int opcion = empleadoActivo.getPerfile().getIdPerfil();
			switch(opcion) {
				case gestion:
					return "redirect:/gestion";
				case jefe:
					return "redirect:/jefe";
				default:
					return "redirect:/login";
			}
		}
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String loginPost(
			@RequestParam("idEmpleado") int idEmpleado, 
			@RequestParam("email") String email, 
			@RequestParam("password") String password,
			HttpSession sesionEmpleado,
			RedirectAttributes attr,
			Model model) {
		/**
		 * Comprueba el usuario y vuelve al login en caso de ser incorrecto
		 * Si es correcto, dirige a gestion o jefe según sea el tipo de empleado
		 */
		Empleado empleadoActivo = iempleados.findById(idEmpleado);
		
		if (!empleadoActivo.getCorreo().equals(email) || !empleadoActivo.getPassword().equals(password)) {
			model.addAttribute("mensajeLogin", "Error de login");
			return "login";
		}
		if (empleadoActivo.getPerfile().equals(iempleados.SacarListaPerfiles().getPerfil(gestion))) {
			attr.addFlashAttribute("mensajeLogin", "Inicio de sesión correcto");
			sesionEmpleado.setAttribute("empleadoActivo", empleadoActivo);
			return "redirect:/gestion";
		} else if (empleadoActivo.getPerfile().equals(iempleados.SacarListaPerfiles().getPerfil(jefe))) {
			attr.addFlashAttribute("mensajeLogin", "Inicio de sesión correcto");
			sesionEmpleado.setAttribute("empleadoActivo", empleadoActivo);
			return "redirect:/jefe";
		} else {
			model.addAttribute("mensajeLogin", "Error de login");
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(
			HttpSession sesionEmpleado) {
		/**
		 * Cierra la sesión borrando el atributo del empleadoActivo,
		 * y vuelve a login
		 */
		
		sesionEmpleado.removeAttribute("empleadoActivo");
		return "redirect:/login";
	}

}
