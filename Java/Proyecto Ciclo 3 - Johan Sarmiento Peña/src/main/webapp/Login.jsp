<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="./Login.css">
	<link rel="stylesheet" href="./Global.css">
	<title>SakuraShop | Login</title>
</head>
<body>
	<img class="nike-banner" alt="Nike" src="https://pbs.twimg.com/media/Cngf9lLUEAAwyPH.jpg">
	<article class="login-container" >
		<h1>Iniciar Sesión</h1>
		<form class="login-form" method="post" action="./DemoServlet">
			<input class="login-input" placeholder="Usuario">
			<input type="password" class="login-input" placeholder="Contraseña">
			<button class="login-button" type="submit">Iniciar Sesión</button>
		</form>
	</article>
</body>
</html>