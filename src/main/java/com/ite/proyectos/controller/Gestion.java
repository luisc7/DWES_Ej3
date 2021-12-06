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
		/**
		 * Se recoge de sesion el empleado activo.
		 * 
		 * Si su perfil coincide con 1 (perfil de gestion), lleva
		 * al JSP que permite gestionar los proyectos.
		 * 
		 * En otro caso (empleado activo es null, o se accede a la url
		 * con empleado activo de diferente perfil) lleva a / (y desde 
		 * alli el homeController decidirá a qué ruta dirige en función 
		 * del perfil del empleado activo.
		 */
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
		/**
		 * Lleva a un JSP para dar de alta un proyecto.
		 * 
		 * Se recogen las listas de los clientes y los 
		 * jefes de las interfaces, y se envían como atributos de
		 * petición para luego en un select
		 * elegir de qué cliente es el proyecto, y a qué 
		 * jefe se asigna el proyecto.
		 */
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
		
		/**
		 * En el formulario que da de alta un proyecto, se recogen los 
		 * campos del formulario cumplimentados con @RequestParam y se utilizan
		 * para crear un nuevo proyecto que se añade a la interfaz de 
		 * proyectos.
		 * 
		 * En el método de creación del proyecto, se crea con la lista de 
		 * ProyectoConEmpleado a null.
		 * Luego, se obtiene la lista de los empleados y se añaden como lista
		 * de ProyectoConEmpleado, siendo sus horas asignadas cero para todos ellos
		 * y su fecha de inicio a null.
		 */
		
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
		
		/**
		 * Envía a un JSP con un formulario donde indicar fecha de fin y 
		 * coste final del proyecto.
		 * 
		 * Pasa por petición el proyecto en cuestión, cuya id venía por la Path
		 */
		model.addAttribute("proyectoATerminar", iproyectos.findById(Integer.toString(idProyecto)));
		return "terminarProyectoForm";
	}
	
	@PostMapping("/terminarProyecto/{id}")
	public String terminarProyectoPost(
			Model model,
			@PathVariable("id") String idProyecto,
			@RequestParam("costeReal") String costeRealString,
			@RequestParam("fechaFinReal") String fechaFinRealString) throws ParseException {
		/**
		 * Recoge los datos del formulario de terminación del proyecto.
		 * 
		 * Asigna al proyecto el estado terminado, asi como 
		 * los valores de coste real y fecha de fin real.
		 * 
		 * Desde la path obtiene el id del proyecto.
		 * 
		 * Redirige a la página principal de gestión.
		 */
		
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
