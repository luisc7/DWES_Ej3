<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	<title>A�adir horas de proyecto al empleado</title>
</head>

<body>	
	<h1>A�adir horas del empleado ${empleado.nombre} al proyecto ${proyecto.descripcion}</h1>
	<p>Hola ${empleadoActivo.nombre}</p>
	
	<form action="/jefe/asignarEmpleados/${proyecto.idProyecto }/asignarHorasEmpleado/${empleado.idEmpl}" method="post" name="formAddHorasEmpleado">
	<fieldset>
		<legend>Selecciona las horas que dedicar� ${empleado.nombre} al proyecto ${proyecto.descripcion} y su fecha de incorporaci�n: </legend>
		<input type="number" name="horasAsignadas">
		<label for="horasAsignadas"> Horas a asignar </label><br>
		<input type="date" name="fechaIncorporacion">
		<label for="fechaIncorporacion"> Fecha de incorporaci�n </label><br>
	</fieldset>
	
	<input class="send-button" type="submit" value="Asignar horas" />
	
	</form>	

</body>

</html>