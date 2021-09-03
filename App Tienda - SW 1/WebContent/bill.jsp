<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>A ver si ahorra APP - Factura Preliminar</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
</head>

<body class="m-0 vh-100 row justify-content-center align-items-center">
	<div class="col-auto p-5 text-center">
		<form action="BillServlet" method="post">

			<h1>
				<b> FACTURA </b>
			</h1>
			<br>
			<table class="table">
				<tr>
					<c:forEach items="${sessionScope.userdata}" var="user">
						<td><c:out value="${user}" /></td>
					</c:forEach>
					<td align="center"># Factura<input type="text"
						class="form-control line vld draw" name="bill_id" value=${bill_id
						} readonly></td>
				</tr>
			</table>
			<br>
			<br>
			<table class="table table-bordered">
				<tr>
					<th>Producto</th>
					<th>Presentacion</th>
					<th>Costo unitario ($)</th>
					<th>Cantidad a comprar</th>
					<th>Total ($)</th>
				</tr>
				<c:forEach items="${sessionScope.billList}" var="bill">
					<tr>
						<td><c:out value="${bill.product}" /></td>
						<td><c:out value="${bill.presentation}" /></td>
						<td><c:out value="${bill.unitPrice}" /></td>
						<td><c:out value="${bill.quantity}" /></td>
						<td><c:out value="${bill.totalPrice}" /></td>
					</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<th>Subtotal (sin IVA)</th>
					<td><input type="text" class="form-control line vld draw"
						name="subtotal" value=${subtotal } readonly></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<th>Total a pagar</th>
					<td><input type="text" class="form-control line vld draw"
						name="total" value=${total } readonly></td>
				</tr>
			</table>
			<br>
			<br>
			<button type="submit" class="btn btn-primary">Confirmar
				pedido</button>
		</form>
	</div>
</body>
</html>