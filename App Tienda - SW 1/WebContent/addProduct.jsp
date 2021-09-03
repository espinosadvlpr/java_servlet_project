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
		<form action="AddProductServlet" method="post">
			<h3>Digite los datos del producto</h3>
			<br>
			<br>
			<table class="table table-responsive">
				<tr>
					<td align="right">Codigo:</td>
					<td><input type="text" class="form-control line vld draw"
						name="id"></td>
					<td align="right">Costo unitario:</td>
					<td><input type="text" class="form-control line vld draw"
						name="price"></td>
				</tr>
				<tr>
					<td align="right">Producto:</td>
					<td><input type="text" class="form-control line vld draw"
						name="product"></td>
					<td align="right">Disponible:</td>
					<td><input type="text" class="form-control line vld draw"
						name="quantity"></td>
				</tr>
				<tr>
					<td align="right">Presentacion:</td>
					<td><input type="text" class="form-control line vld draw"
						name="presentation"></td>
				</tr>
			</table>
			<br>
			<br>
			<br>
			<button type="submit" class="btn btn-primary">Añadir</button>
		</form>
		<br>
	</div>
</body>
</html>