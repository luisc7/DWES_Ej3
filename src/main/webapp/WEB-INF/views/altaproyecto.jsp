<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta proyecto</title>
</head>
<body>

	
	<h1>Alta de nuevo proyecto</h1>
	<a href="/gestion">Volver a Gestión de Proyectos</a>
	<p>Hola ${empleadoActivo.nombre}</p>
	
	<form action="altaProyecto" method="post" name="formAltaProyecto">
	<fieldset>
		<legend>Cumplimenta los datos el nuevo proyecto:</legend>
		<input type="text" name="descripcion">
		<label for="descripcion"> Descripción del proyecto </label><br>
		<input type="number" name="costePrevisto">
		<label for="costePrevisto"> Coste previsto </label><br>
		<input type="number" name="ventaPrevisto">
		<label for="ventaPrevisto"> Ventas previstas para el proyecto </label><br>
		<input type="date" name="fechaInicio">
		<label for="fechaInicio"> Fecha de inicio </label><br>
		<input type="date" name="fechaFinPrevisto">
		<label for="fechaFinPrevisto"> Fecha prevista de finalización </label><br>
		<select name="cliente">
		<c:forEach var="eleCliente" items="${listaClientes}">
			<option value="${eleCliente.cif}">${eleCliente.nombre}</option>
		</c:forEach>
		</select>
		<label for="cliente"> Cliente </label><br>
		<select name="jefeProyecto">
		<c:forEach var="eleJefe" items="${listaJefes}">
			<option value="${eleJefe.idEmpl}">${eleJefe.nombre}</option>
		</c:forEach>
		</select>
		<label for="jefeProyecto"> Jefe de proyecto </label>
	</fieldset>
	
	<input class="send-button" type="submit" value="Dar de alta el proyecto" />
	
	</form>
	

</body>
</html>