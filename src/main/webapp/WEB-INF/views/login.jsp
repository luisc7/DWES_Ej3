<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" media="screen" href="/css/style.css"/>
<title>Inicio de sesión</title>
</head>
<body>
	<form action="login" method="post" name="formAlta">
	<fieldset>
		<legend>Inicio de sesión</legend>
		<div class="grid">		
		<input type="number" name="idEmpleado" id="idEmpleado"/>
		<label for="idEmpleado"> Número de empleado </label><br>
		<input type="text" name="email" id="email"/>
		<label for="email"> Correo electrónico </label><br>
		<input type="password" name="password" id="password"/>
		<label for="password"> Contraseña </label>
		
		</div>
		
	<input class="send-button" type="submit" value="Iniciar sesión" />
		
	</fieldset>
	
	</form>
	<p>${mensajeLogin}</p>
	<table>
		<tr>
			<th>Tipo usuario</th>
			<th>Número</th>
			<th>Correo electrónico</th>
			<th>Contraseña</th>
		</tr>
		<tr>
			<td>Gestor:</td>
			<td><b>5</b></td>
			<td><b>e@e.e</b></td>
			<td><b>cinco</b></td>
		</tr>
		<tr>
			<td>Jefe:</td>
			<td><b>3</b></td>
			<td><b>c@c.c</b></td>
			<td><b>tres</b></td>
		</tr>
	</table>
</body>
</html>