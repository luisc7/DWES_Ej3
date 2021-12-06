<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyectos activos</title>
</head>
<body>
	<nav>
		<ul>
			<li><a href="/logout">Cerrar sesión</a></li>
		</ul>
	</nav>
	
	<h1>Proyectos activos</h1>
	<p>Estos son los proyectos que diriges, ${empleadoActivo.nombre}:</p>	
	<table>		 
		 <tr>
			<th class="col1">Nombre del proyecto</th>
			<th class="col2">Cliente</th>
			<th class="col3">Coste previsto</th>
			<th class="col4">Ventas previstas</th>						
			<th class="col5">Opciones</th>
		</tr>
		<c:forEach var="eleProyecto" items="${listaProyectosJefe}">
			<c:if test="${eleProyecto.estado !='Terminado'}">
				<tr>
					<td class="col1 filled-col">${eleProyecto.descripcion}</td>
					<td class="col3 filled-col">${eleProyecto.cliente.nombre}</td>
					<td class="col3 filled-col">${eleProyecto.costesPrevisto}</td>
					<td class="col4 filled-col">${eleProyecto.ventaPrevisto}</td>
					<td class="col5 filled-col"><a href="verDetalle/${eleProyecto.idProyecto}">Ver detalles</a></td>
				</tr>
			</c:if>
		</c:forEach>
		
	</table>

</body>
</html>