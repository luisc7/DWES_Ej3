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
import com.ite.proyectos.modelo.repository.IntDepartamentoDao;
import com.ite.proyectos.modelo.repository.IntEmpleadoDao;
import com.ite.proyectos.modelo.repository.IntPerfileDao;
import com.ite.proyectos.modelo.repository.IntProyectoDao;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private final int gestion = 1;
	private final int jefe = 2;
	private final int operativo = 3;
	private final int recursosHumanos = 4;
	
	@Autowired
	private IntEmpleadoDao iempleados;
	
	@GetMapping("/")
	public String inicio(HttpSession sesionEmpleado) {
		Empleado empleadoActivo = (Empleado) sesionEmpleado.getAttribute("empleadoActivo");
		if (empleadoActivo == null)
			return "redirect:/login";		
		else {
			int opcion = empleadoActivo.getPerfile().getIdPerfil();
			switch(opcion) {
				case 1:
					return "redirect:/gestion";
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
		Empleado empleadoActivo = iempleados.findById(idEmpleado);
		
		System.out.println(empleadoActivo.getCorreo().equals(email));
		System.out.println(empleadoActivo.getPassword().equals(password));
		System.out.println(email);
		System.out.println(password);
		
		if (!empleadoActivo.getCorreo().equals(email) || !empleadoActivo.getPassword().equals(password)) {
			model.addAttribute("mensajeLogin", "Error de login");
			return "login";
		}
		if (empleadoActivo.getPerfile().equals(iempleados.SacarListaPerfiles().getPerfil(gestion))) {
			attr.addFlashAttribute("mensajeLogin", "Inicio de sesión correcto");
			sesionEmpleado.setAttribute("empleadoActivo", empleadoActivo);
			return "redirect:/gestion";
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
		return "/login";
	}

}
