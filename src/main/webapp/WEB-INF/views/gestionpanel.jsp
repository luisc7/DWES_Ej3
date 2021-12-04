<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Panel de gesti�n</title>
</head>
<body>
	<nav>
		<ul>
			<li><a href="/logout">Cerrar sesi�n</a></li>
		</ul>
	</nav>
	
	<h1>Gesti�n de Proyectos</h1>
	<p>Hola ${empleadoActivo.nombre}</p>
	<a href="/altaProyecto">
		<input type="button" value="Dar proyecto de alta">
	</a>
	<table>
		 
		 <tr>
			<th class="col1">Nombre del proyecto</th>
			<th class="col2">Estado</th>
			<th class="col3">Jefe de proyecto</th>
						
			<th class="col5">Opciones</th>
		</tr>
		<c:forEach var="eleProyecto" items="${listaProyectos}">
			<tr>
				<td class="col1 filled-col">${eleProyecto.descripcion}</td>
				<td class="col3 filled-col">${eleProyecto.estado}</td>
				<td class="col3 filled-col">${eleProyecto.jefeProyecto}</td>
				<td class="col5 filled-col"><a href="terminarProyecto/${eleProyecto.idProyecto}">Terminar proyecto</a></td>
			</tr>
		</c:forEach>
		
	</table>

</body>
</html>