package com.ite.proyectos.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
	public String inicioGestion(HttpSession sesionEmpleado) {
		Empleado empleadoActivo = (Empleado)sesionEmpleado.getAttribute("empleadoActivo");
		if (empleadoActivo.getPerfile().getIdPerfil()==1)
			return "gestionpanel";
		else
			return "redirect:/login";
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
		@RequestParam("cliente") String cifCliente) throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		iproyectos.altaProyecto(
				new BigDecimal(costePrevistoString), 
				descripcion, 
				format.parse(fechaFinPrevistoString), 
				format.parse(fechaInicioString), 
				new BigDecimal(ventaPrevistoString), 
				iclientes.findByCif(cifCliente), 
				null);
		
		attr.addFlashAttribute("listaProyectos", iproyectos.listarProyectos());
		attr.addFlashAttribute("listaClientes", iclientes.listarClientes());
	
		return "redirect:/gestion";
	}
	
	@GetMapping("/terminarProyecto")
	public String terminarProyecto() {
		return "redirect:/gestion";
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
