package com.ite.proyectos.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.proyectos.modelo.beans.Empleado;
import com.ite.proyectos.modelo.beans.Proyecto;
import com.ite.proyectos.modelo.repository.IntClienteDao;
import com.ite.proyectos.modelo.repository.IntEmpleadoDao;
import com.ite.proyectos.modelo.repository.IntProyectoDao;

@Controller
@RequestMapping("/gestion")
public class Gestion {
	
	@Autowired
	private IntProyectoDao iproyectos;
	
	@Autowired
	private IntClienteDao iclientes;
	
	@Autowired
	private IntEmpleadoDao iempleados;
	
	@GetMapping("")
	public String inicioGestion(
			Model model,
			HttpSession sesionEmpleado) {
		Empleado empleadoActivo = (Empleado)sesionEmpleado.getAttribute("empleadoActivo");
		int perfil = empleadoActivo.getPerfile().getIdPerfil();
		if (perfil==1) {
			model.addAttribute("listaProyectos", iproyectos.listarProyectos());
			model.addAttribute("listaClientes", iclientes.listarClientes());
			return "gestionpanel";
		}
		else
			return "redirect:/";
	}
	
	@GetMapping("/altaProyecto")
	public String altaProyecto(Model model) {
		model.addAttribute("listaClientes", iclientes.listarClientes());
		model.addAttribute("listaJefes", iempleados.listarJefes());
		return "altaProyecto";
	}
	
	@PostMapping("/altaProyecto")
	public String altaProyectoPost(
		RedirectAttributes attr,
		@RequestParam("descripcion") String descripcion,
		@RequestParam("costePrevisto") String costePrevistoString,
		@RequestParam("fechaInicio") String fechaInicioString,
		@RequestParam("fechaFinPrevisto") String fechaFinPrevistoString,
		@RequestParam("ventaPrevisto") String ventaPrevistoString,
		@RequestParam("cliente") String cifCliente,
		@RequestParam("jefeProyecto") int idEmpleado) throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Proyecto proyectoCargado = iproyectos.altaProyecto(
				new BigDecimal(costePrevistoString), 
				descripcion, 
				format.parse(fechaFinPrevistoString), 
				format.parse(fechaInicioString), 
				new BigDecimal(ventaPrevistoString), 
				iclientes.findByCif(cifCliente),
				iempleados.findById(idEmpleado));
		iproyectos.cargaInicialProyectosConEmpleado(proyectoCargado, iempleados.listarEmpleados());
		return "redirect:/gestion";
	}
	
	@GetMapping("/terminarProyecto/{id}")
	public String terminarProyecto(
			Model model,
			@PathVariable("id") int idProyecto) {
		model.addAttribute("proyectoATerminar", iproyectos.findById(Integer.toString(idProyecto)));
		return "terminarProyectoForm";
	}
	
	@PostMapping("/terminarProyecto/{id}")
	public String terminarProyectoPost(
			Model model,
			@PathVariable("id") String idProyecto,
			@RequestParam("costeReal") String costeRealString,
			@RequestParam("fechaFinReal") String fechaFinRealString) throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		iproyectos.terminarProyecto(idProyecto, new BigDecimal(costeRealString), format.parse(fechaFinRealString));
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
