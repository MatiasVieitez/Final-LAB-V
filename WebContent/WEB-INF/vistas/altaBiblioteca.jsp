<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prestamos</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="css/index.css" />

</head>

<body>
<jsp:include page="navbar.jsp" />
	<div class="container">
		<div class="card">
		<div class="card-body">				
				<div class="col-12">
					<h1>Alta Biblioteca</h1>
					<input type="button" value="Volver" onclick="location.href = 'biblioteca.html';" class="btn btn-success"></input>
				</div>
				<br>
				<form class="col-12" action="addBiblioteca.html"	method="Get">
					<h3>Biblioteca</h3>
					
					<div class=" form-group row">
					
						<label for="cliente" class="col-sm-2 col-form-label">Biblioteca:</label>
						<div class="col-sm-7">
							<select name="cliente" id="cliente">
								<option value="">Diamante</option>
								<option value="Disponible">Oro</option>
								<option value="Prestado">Plata</option>
								<option value="Prestado">Bronce</option>
							</select>
						</div>
						
					</div>
					
					<div class=" form-group row">
						<label for="libros" class="col-sm-2 col-form-label">Libro :</label>
							<div class="col-sm-7">
								<select name="libros" id="libros">
									<c:forEach items="${libroList}" var="item">
                        			<option value="${item.getId()}">${item.getTitulo()}</option>
                   				 </c:forEach>
							</select>
							</div>	
					</div>
					
					<div class="form-group row">
						
						<label for="fechaAlta" class="col-sm-2 col-form-label">Fecha de Alta:</label>
						<div class="col-sm-7">
							<input type="date" class="form-control" id="fechaAlta"
								name="fechaAlta">
						</div>
					
					</div>
					
					
					<div class="form-group row">
						<div class="col-sm-7">
							<input class="col-sm-2 col-form-label" type="submit" value="Crear">
						</div>
					</div>
				</form>
				
	
</body>
</html>