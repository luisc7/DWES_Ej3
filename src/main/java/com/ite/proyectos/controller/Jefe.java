package com.ite.proyectos.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

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
import com.ite.proyectos.modelo.beans.ProyectoConEmpleado;
import com.ite.proyectos.modelo.repository.IntEmpleadoDao;
import com.ite.proyectos.modelo.repository.IntProyectoDao;

@Controller
@RequestMapping("/jefe")
public class Jefe {
	
	@Autowired
	private IntProyectoDao iproyectos;
	
	@Autowired
	private IntEmpleadoDao iempleados;
	
	//@Autowired
	//private IntProyectoConEmpleadoDao iproyconempl;
	
	@GetMapping("")
	public String inicioJefe() {
		/**
		 * Redirijo a los proyectos activos de este jefe
		 */
		return "redirect:/jefe/proyectos";
	}
	
	@GetMapping("/proyectos")
	public String ListarProyectos(Model model,
			HttpSession sesionEmpleado) {
		/**
		 * Recoger todos los proyectos activos que tiene este jefe 
		 * desde la interfaz de todos los proyectos.
		 * Se envía al jsp "listarProyectosJefe" para mostrarlos
		 */
		List<Proyecto> listaProyectosJefe = iproyectos.listarProyectosJefe((Empleado)sesionEmpleado.getAttribute("empleadoActivo"));
		model.addAttribute("listaProyectosJefe", listaProyectosJefe);		
		return "listarProyectosJefe";
	}
	
	@GetMapping("/verDetalle/{id}")
	public String VerDetalle(
			Model model,
			@PathVariable("id") String idProyecto) {
		/**
		 * Muestra un jsp con detalles del proyecto.
		 * La id del proyecto se recoge por PathVariable desde la URL,
		 * se busca el proyecto cuya id corresponde, y se pasa al model
		 * como atributo "proyecto" para mostrar en el JSP "detalleProyecto"
		 */
		model.addAttribute("proyecto", iproyectos.findById(idProyecto));
		return "detalleProyecto";
	}
	
	@GetMapping("/asignarEmpleados/{id}")
	public String asignarEmpleados(
			Model model,
			@PathVariable("id") String idProyecto) {
		/**
		 * Muestra un JSP con todos los empleados, las horas asignadas
		 * a ese proyecto, y la capacidad de asignar horas/desasignar del proyecto
		 * a cada empelado.
		 * 
		 * Recoge la id del proyecto desde la Path, se busca el proyecto correspondiente
		 * con la interfaz de proyectos. Se extrae la lista de ProyectoConEmpleado del 
		 * proyecto.
		 * 
		 * Se pasan como atributos de petición el proyecto y la lista anteriores.
		 * 		 * 
		 */
		Proyecto proyectoSeleccionado = iproyectos.findById(idProyecto);
		model.addAttribute("proyecto", proyectoSeleccionado);
		List<ProyectoConEmpleado> listaEmpleadosEnProyecto = proyectoSeleccionado.getProyectoConEmpleados();
		model.addAttribute("empleadosEnProyecto", listaEmpleadosEnProyecto);
		return "asignarEmpleados";
	}
	
	@GetMapping("/asignarEmpleados/{id}/asignarHorasEmpleado/{EmplId}")
	public String asignarHorasEmpleado(
			Model model,
			RedirectAttributes attr,
			@PathVariable("id") String idProyecto,
			@PathVariable("EmplId") String idEmpl
			) {
		/**
		 * Dirige a un JSP con un formulario para detallar las horas y fecha
		 * de incorporación del empleado.
		 * 
		 * Recoge por Path los ids del proyecto y el empleado
		 */
		System.out.println("GetMapping idEmpl: "+idEmpl);
		System.out.println("GetMapping idEmpl parseInt: "+Integer.parseInt(idEmpl));
		System.out.println("Empleado findById " + iempleados.findById(Integer.parseInt(idEmpl)));
		model.addAttribute("proyecto", iproyectos.findById(idProyecto));
		model.addAttribute("empleado", iempleados.findById(Integer.parseInt(idEmpl)));
		return "asignarHorasEmpleadoForm";
	}
	
	
	@PostMapping("/asignarEmpleados/{id}/asignarHorasEmpleado/{EmplId}")
	public String formAddHorasEmpleado(
			Model model,
			RedirectAttributes attr,
			@PathVariable("id") String idProyecto,
			@PathVariable("EmplId") String idEmpl,
			@RequestParam("horasAsignadas") int horasAsignadas,
			@RequestParam("fechaIncorporacion") String fechaIncorporacionString) throws ParseException {
		/**
		 * Al enviar el formulario de asignación de horas a un empleado en un proyecto,
		 * se recupera la lista de ProyectoConEmpleado del proyecto usando el idProyecto y 
		 * el idEmpl desde la Path. 
		 * 
		 * Se extrae el correspondiente a ese empleado y proyecto, y se modifica con las
		 * horas y fecha que han venido por POST (@RequestParam) y se sobreescribe el
		 * ProyectoConEmpleado de la lista con las modificaciones.
		 * 
		 * Se hace redirect al JSP que muestra las horas de empleados en el proyecto.
		 * 
		 */
		
		SimpleDateFormat fechaSDF = new SimpleDateFormat("yyyy-MM-dd");
		
		Proyecto proyecto = iproyectos.findById(idProyecto);
		Empleado empleado = iempleados.findById(Integer.parseInt(idEmpl));
		
		List<ProyectoConEmpleado> listaEmpleadosEnProyecto = proyecto.getProyectoConEmpleados();
		
		ProyectoConEmpleado aux = new ProyectoConEmpleado();
		aux.setProyecto(proyecto);
		aux.setEmpleado(empleado);
		int pos = listaEmpleadosEnProyecto.indexOf(aux);
		aux = listaEmpleadosEnProyecto.get(pos);
		aux.setHorasAsignadas(horasAsignadas);
		aux.setFechaIncorporacion(fechaSDF.parse(fechaIncorporacionString));
		listaEmpleadosEnProyecto.set(pos, aux);
		
		return "redirect:/jefe/asignarEmpleados/{id}";
	}
	
	@GetMapping("/asignarEmpleados/{id}/desasignar/{EmplId}")
	public String desasignarEmpleados(
			Model model,
			@PathVariable("id") String idProyecto,
			@PathVariable("EmplId") String idEmpl) {
		/**
		 * Para desasignar empleados de un proyecto, se hace una combinación
		 * de lo realizado en el GetMapping y PostMapping de "asignarHorasEmpleado":
		 * 
		 * Se obtienen el empleado y proyecto usando las id respectivas 
		 * que vienen por la path a sus correspondientes interfaces, se extrae
		 * del proyecto la lista de ProyectoConEmpleado.
		 * 
		 * Se busca en la lista el ProyectoConEmpleado que involucran a 
		 * este proyecto y empleado, se le asignan 0 horas y fecha de 
		 * incorporacion a null. Se sustituye el de la lista por el modificado.
		 * 
		 * Se hace redirect al JSP que muestra las horas de empleados en el proyecto.
		 */
		
		Proyecto proyecto = iproyectos.findById(idProyecto);
		Empleado empleado = iempleados.findById(Integer.parseInt(idEmpl));
		
		List<ProyectoConEmpleado> listaEmpleadosEnProyecto = proyecto.getProyectoConEmpleados();
		
		ProyectoConEmpleado aux = new ProyectoConEmpleado();
		aux.setProyecto(proyecto);
		aux.setEmpleado(empleado);
		int pos = listaEmpleadosEnProyecto.indexOf(aux);
		aux = listaEmpleadosEnProyecto.get(pos);
		aux.setHorasAsignadas(0);
		aux.setFechaIncorporacion(null);
		listaEmpleadosEnProyecto.set(pos, aux);
		return "redirect:/jefe/asignarEmpleados/{id}";
	}
	
	

}
