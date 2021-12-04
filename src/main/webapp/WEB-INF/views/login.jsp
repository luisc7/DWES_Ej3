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
		
		<label for="idEmpleado">N�mero de empleado </label>
		<input type="number" name="idEmpleado" id="idEmpleado"/>
		<label for="email">Correo electr�nico </label>
		<input type="text" name="email" id="email"/>
		<label for="password">Contrase�a </label>
		<input type="password" name="password" id="password"/>
		
		</div>
		
	<input class="send-button" type="submit" value="Iniciar sesi�n" />
		
	</fieldset>
	
	</form>
	<p>${mensajeLogin}</p>
</body>
</html>