<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>A ver si ahorra APP - Ver Productos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
</head>

<body class = "m-0 vh-100 row justify-content-center align-items-center">
<div class = "col-auto p-5 text-center">
<table class="table table-bordered">
<tr><td>id</td><td>Producto</td><td>Presentacion</td><td>Precio (c/u)</td><td>Cantidad</td></tr>
<c:forEach items="${sessionScope.productlist}" var="product">
   		<tr><td><c:out value="${product.id}"/></td> 
   		<td><c:out value="${product.product}"/></td>
   		<td><c:out value="${product.presentation}"/></td>
   		<td><c:out value="${product.price}"/></td>
   		<td><c:out value="${product.quantity}"/></td></tr>
  </c:forEach>
</table>
<br><br><br>
<a href="adminMenu.jsp"> <button class="btn btn-primary">Regresar al menu</button></a>
</div>
</body>
</html>