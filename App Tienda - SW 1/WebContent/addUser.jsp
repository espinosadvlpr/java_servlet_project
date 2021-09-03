<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>A ver si ahorra APP - Agregar Usuario</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
</head>

<body class="m-0 vh-100 row justify-content-center align-items-center">
	<div class="col-auto p-5 text-center">
		<form action="AddUserServlet" method="post">
			<h3>Digite los datos del usuario</h3>
			<br>
			<br>
			<br>
			<table class="table table-responsive">
				<tr>
					<td align="right">Nombre:</td>
					<td><input type="text" class="form-control line vld draw"
						name="name"></td>
					<td align="right">Direccion:</td>
					<td><input type="text" class="form-control line vld draw"
						name="address"></td>
				</tr>
				<tr>
					<td align="right">E-mail:</td>
					<td><input type="text" class="form-control line vld draw"
						name="email"></td>
					<td align="right">Contraseña:</td>
					<td><input type="text" class="form-control line vld draw"
						name="password"></td>
				</tr>
			</table>
			<br>
			<br>
			<button type="submit" class="btn btn-primary">Añadir</button>
		</form>
	</div>
</body>
</html>