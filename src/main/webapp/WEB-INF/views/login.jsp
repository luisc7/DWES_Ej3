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
</body>
</html>