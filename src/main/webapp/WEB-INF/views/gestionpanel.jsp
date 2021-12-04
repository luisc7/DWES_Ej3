<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Panel de gestión</title>
</head>
<body>
	<nav>
		<ul>
			<li><a href="/logout">Cerrar sesión</a></li>
		</ul>
	</nav>
	
	<h1>Gestión de Proyectos</h1>
	<p>Hola ${empleadoActivo.nombre}</p>
	<a href="gestion/altaProyecto">
		<input type="button" value="Dar proyecto de alta">
	</a>
	<table>
		 
		 <tr>
			<th class="col1">Nombre del proyecto</th>
			<th class="col2">Cliente</th>
			<th class="col3">Estado</th>
			<th class="col4">Jefe de proyecto</th>
						
			<th class="col5">Opciones</th>
		</tr>
		<c:forEach var="eleProyecto" items="${listaProyectos}">
			<tr>
				<td class="col1 filled-col">${eleProyecto.descripcion}</td>
				<td class="col3 filled-col">${eleProyecto.cliente.nombre}</td>
				<td class="col3 filled-col">${eleProyecto.estado}</td>
				<td class="col4 filled-col">${eleProyecto.jefeProyecto.nombre}</td>
				<td class="col5 filled-col"><c:if test="${eleProyecto.estado !='Terminado'}"><a href="gestion/terminarProyecto/${eleProyecto.idProyecto}">Terminar proyecto</a></c:if></td>
			</tr>
		</c:forEach>
		
	</table>

</body>
</html>