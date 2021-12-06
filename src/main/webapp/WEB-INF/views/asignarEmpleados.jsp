<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Asignacion de empleados</title>
</head>
<body>
	<nav>
		<ul>
			<li><a href="/logout">Cerrar sesión</a></li>
		</ul>
	</nav>
	
	<h1>Asignación de empleados al proyecto ${proyecto.descripcion}</h1>
	<p>Hola ${empleadoActivo.nombre}</p>
	<a href="/jefe">
		Volver a la lista de tus proyectos
	</a><br>
	<a href="/jefe/verDetalle/${proyecto.idProyecto}">
		Volver a los detalles del proyecto
	</a>
	<table>		 
		 <tr>
			<th>Nombre empleado</th>
			<th>Horas asignadas al proyecto</th>
			<th>Fecha de incorporación</th>
						
			<th>Opciones</th>
		</tr>
		<c:forEach var="eleEmpleado" items="${empleadosEnProyecto}">
			<tr>
				<td>${eleEmpleado.empleado.nombre}</td>
				<td>${eleEmpleado.horasAsignadas}</td>
				<td>
					<c:if test="${eleEmpleado.horasAsignadas != 0}">
						<fmt:formatDate pattern = "dd-MM-yyyy" value = "${eleEmpleado.fechaIncorporacion}"/>
					</c:if>		
				</td>
				<td>
					<c:if test="${eleEmpleado.horasAsignadas == 0}">
						<a href="${proyecto.idProyecto}/asignarHorasEmpleado/${eleEmpleado.empleado.idEmpl}">Asignar horas</a>
					</c:if>
					<c:if test="${eleEmpleado.horasAsignadas != 0}">
						<a href="${proyecto.idProyecto}/desasignar/${eleEmpleado.empleado.idEmpl}">Desasignar proyecto</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>			
	</table>

</body>
</html>