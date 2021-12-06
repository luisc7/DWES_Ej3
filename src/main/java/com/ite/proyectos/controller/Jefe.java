package com.ite.proyectos.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.ite.proyectos.modelo.repository.IntProyectoConEmpleadoDao;
import com.ite.proyectos.modelo.repository.IntProyectoDao;
import com.ite.proyectos.modelo.repository.ListImplProyectoConEmpleado;

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
		return "redirect:/jefe/proyectos";
	}
	
	@GetMapping("/proyectos")
	public String ListarProyectos(Model model,
			HttpSession sesionEmpleado) {
		List<Proyecto> listaProyectosJefe = iproyectos.listarProyectosJefe((Empleado)sesionEmpleado.getAttribute("empleadoActivo"));
		model.addAttribute("listaProyectosJefe", listaProyectosJefe);		
		return "listarProyectosJefe";
	}
	
	@GetMapping("/verDetalle/{id}")
	public String VerDetalle(
			Model model,
			@PathVariable("id") String idProyecto) {
		model.addAttribute("proyecto", iproyectos.findById(idProyecto));
		return "detalleProyecto";
	}
	
	@GetMapping("/asignarEmpleados/{id}")
	public String asignarEmpleados(
			Model model,
			@PathVariable("id") String idProyecto) {
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
		
		SimpleDateFormat fechaSDF = new SimpleDateFormat("yyyy-MM-dd");

		System.out.println("idProyecto en Postmapping: "+idProyecto);
		System.out.println("idEmpl en Postmapping: "+idEmpl);
		Proyecto proyecto = iproyectos.findById(idProyecto);
		Empleado empleado = iempleados.findById(Integer.parseInt(idEmpl));
		//Empleado empleado = (Empleado) attr.getAttribute("empleado");
		System.out.println("empleado en PostMapping: "+empleado);
		List<ProyectoConEmpleado> listaEmpleadosEnProyecto = proyecto.getProyectoConEmpleados();
		
		ProyectoConEmpleado aux = new ProyectoConEmpleado();
		aux.setProyecto(proyecto);
		aux.setEmpleado(empleado);
		int pos = listaEmpleadosEnProyecto.indexOf(aux);
		aux = listaEmpleadosEnProyecto.get(pos);
		aux.setHorasAsignadas(horasAsignadas);
		aux.setFechaIncorporacion(fechaSDF.parse(fechaIncorporacionString));
		listaEmpleadosEnProyecto.set(pos, aux);
		
		/*ListImplProyectoConEmpleado proyectoConEmpleados = (ListImplProyectoConEmpleado) proyecto.getProyectoConEmpleados();
		ProyectoConEmpleado proyconempl = iproyconempl.empleadoEnProyecto(proyecto, empleado);
		proyconempl.setHorasAsignadas(horasAsignadas);
		proyconempl.setFechaIncorporacion(new Date());*/
		//iproyconempl.asignarEmpleadoAProyecto(proyecto, empleado, horasAsignadas, new Date());
		//iproyconempl.listaEmpleadosEnProyecto(proyecto);
		model.addAttribute("proyecto", proyecto);
		//System.out.println(iproyconempl.empleadoEnProyecto(proyecto, empleado));
		return "redirect:/jefe/asignarEmpleados/{id}";
	}
	
	

}
