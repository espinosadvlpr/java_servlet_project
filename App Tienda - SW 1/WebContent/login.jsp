<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>A ver si ahorra APP - Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
</head>

<body class = "m-0 vh-100 row justify-content-center align-items-center">
<div class = "col-auto p-5 text-center">
<form action="LoginServlet" method="post">
<h1><b>A VER SI AHORRA - APP</b><br><br></h1>
<h3>Inicio de sesion<br><br></h3>
<div class="form-group mx-sm-3">
       <input type="email" class="form-control" name="email" placeholder="E-mail">
       <br>
   </div>
   <div class="form-group mx-sm-3">
       <input type="password" class="form-control" name="password" placeholder="Contraseña">
       <br>
   </div>
   <button type="submit" class="btn btn-primary">Ingresar</button>
</form>
</div>

</body>
</html>