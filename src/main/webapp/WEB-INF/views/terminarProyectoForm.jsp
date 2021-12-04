<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Terminar proyecto</title>
</head>
<body>

	
	<h1>Proyecto: ${proyectoATerminar.descripcion }</h1>
	<p>Hola ${empleadoActivo.nombre}</p>
	
	<form action="${proyectoATerminar.idProyecto }" method="post" name="formTerminarProyecto">
	<fieldset>
		<legend>Cumplimenta los datos para terminar el proyecto:</legend>
		<label for="costeReal">Coste final del proyecto: </label>
		<input type="number" name="costeReal"><br>
		<label for="fechaFinReal">Fecha de finalización: </label>
		<input type="date" name="fechaFinReal"><br>
	</fieldset>
	
	<input class="send-button" type="submit" value="Terminar el proyecto" />
	
	</form>
	

</body>
</html>