<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>A ver si ahorra APP - Tienda</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
</head>

<body class="m-0 vh-100 row justify-content-center align-items-center">
	<div class="col-auto p-5 text-center">
		<a href="login.jsp">
			<button class="btn btn-primary">Cerrar sesion</button>
		</a> <br>
		<br>

		<form action="StoreServlet" method="post">
			<button type="submit" class="btn btn-primary">Revisar
				factura</button>
			<br>
			<br>
			<table class="table table-bordered">
				<tr>
					<th>id</th>
					<th>Producto</th>
					<th>Presentacion</th>
					<th>Costo unitario ($)</th>
					<th>Disponibles</th>
					<th>Cantidad a comprar</th>
					<th>Estado</th>
				</tr>
				<c:forEach items="${sessionScope.productlist}" var="product">
					<c:if test="${product.quantity > 4 }">
						<tr>
							<td><c:out value="${product.id}" /></td>
							<td><c:out value="${product.product}" /></td>
							<td><c:out value="${product.presentation}" /></td>
							<td><c:out value="${product.price}" /></td>
							<td><c:out value="${product.quantity}" /></td>
							<td><input type="text" class="form-control line vld draw"
								name="<c:out value="${product.id}"/>"></td>
							<td><input type="checkbox" class="form-check-input"
								name="selected" value="<c:out value="${product.id}"/>">
						</tr>
					</c:if>
				</c:forEach>
			</table>

		</form>
	</div>
</body>
</html>