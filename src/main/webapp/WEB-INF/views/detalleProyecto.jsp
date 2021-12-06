<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalles del proyecto</title>
</head>
<body>
	<nav>
		<ul>
			<li><a href="/logout">Cerrar sesión</a></li>
		</ul>
	</nav>
	
	<h1>Proyecto ${proyecto.descripcion}</h1>
	<p>Hola ${empleadoActivo.nombre}</p>
	<a href="/jefe">
		Volver a la lista de tus proyectos
	</a>
	<table>		 
		 <tr>
		 	<th>Identificador del proyecto</th>
			<th>Nombre del proyecto</th>
			<th>Cliente</th>
			<th>Estado</th>
			<th>Fecha de inicio</th>
			<th>Fecha prevista de finalización</th>
			<th>Fecha de finalización real</th>
			<th>Ventas previstas</th>
			<th>Costes previstos</th>
			<th>Coste real</th>
		</tr>
		<tr>
			<td>${proyecto.idProyecto}</td>
			<td>${proyecto.descripcion}</td>
			<td>${proyecto.cliente.nombre}</td>
			<td>${proyecto.estado}</td>
			<td>${proyecto.fechaInicio}</td>
			<td>${proyecto.fechaFinPrevisto}</td>
			<td>${proyecto.fechaFinReal}</td>
			<td>${proyecto.ventaPrevisto}</td>
			<td>${proyecto.costesPrevisto}</td>
			<td>${proyecto.costeReal}</td>
		</tr>	
	</table>
	
	<a href="/jefe/asignarEmpleados/${proyecto.idProyecto}">
		<input type="button" value="Añadir empleados al proyecto">
	</a>
	<table>
	<caption>Empleados asignados al proyecto</caption>
		<tr>
			<th>Número de empleado</th>
			<th>Nombre</th>
		</tr>
		<c:forEach var="proyconempleado" items="${proyecto.proyectoConEmpleados}">
		<c:if test="${proyconempleado.horasAsignadas != 0}">
		<tr>
			<td>${proyconempleado.empleado.idEmpl }</td>
			<td>${proyconempleado.empleado.nombre }</td>
		</tr>
		</c:if>
		</c:forEach>
	</table>
	
	<table>
	<caption>Productos asignados al proyecto</caption>
		<tr>
			<th>Número de producto</th>
			<th>Nombre</th>
		</tr>
		<c:forEach var="producto" items="${proyecto.proyectoConProductos}">
		<tr>
			<td>${producto.idProducto }</td>
			<td>${producto.descripcionBreve }</td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>