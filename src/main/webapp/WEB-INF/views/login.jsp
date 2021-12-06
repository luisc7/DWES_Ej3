<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" media="screen" href="/css/style.css"/>
<title>Inicio de sesi�n</title>
</head>
<body>
	<form action="login" method="post" name="formAlta">
	<fieldset>
		<legend>Inicio de sesi�n</legend>
		<div class="grid">		
		<input type="number" name="idEmpleado" id="idEmpleado"/>
		<label for="idEmpleado"> N�mero de empleado </label><br>
		<input type="text" name="email" id="email"/>
		<label for="email"> Correo electr�nico </label><br>
		<input type="password" name="password" id="password"/>
		<label for="password"> Contrase�a </label>
		
		</div>
		
	<input class="send-button" type="submit" value="Iniciar sesi�n" />
		
	</fieldset>
	
	</form>
	<p>${mensajeLogin}</p>
	<table>
		<tr>
			<th>Tipo usuario</th>
			<th>N�mero</th>
			<th>Correo electr�nico</th>
			<th>Contrase�a</th>
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