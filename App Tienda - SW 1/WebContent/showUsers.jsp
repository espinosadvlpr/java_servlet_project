<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>A ver si ahorra APP - Ver Usuarios</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
</head>

<body class = "m-0 vh-100 row justify-content-center align-items-center">
<div class = "col-auto p-5 text-center">
<table class="table table-bordered">
<tr><td>Codigo</td><td>Nombre</td><td>Direccion</td><td>E-mail</td><td>Contraseña</td></tr>
<c:forEach items="${sessionScope.userlist}" var="user">
   		<tr><td><c:out value="${user.id}"/></td> 
   		<td><c:out value="${user.name}"/></td>
   		<td><c:out value="${user.address}"/></td>
   		<td><c:out value="${user.email}"/></td>
   		<td><c:out value="${user.password}"/></td></tr>
  </c:forEach>
</table>
<br><br>
<a href="adminMenu.jsp"> <button class="btn btn-primary">Regresar al menu</button></a>
</div>
</body>
</html>