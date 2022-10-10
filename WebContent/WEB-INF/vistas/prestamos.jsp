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
					<h1>Prestamos</h1>
					<input type="button" value="Agregar Prestamo" onclick="location.href = 'altaPrestamo.html';"	class="btn btn-success"></input>
				</div>
				<br>
				<form class="col-12" action="listarPrestamoFiltro.html"	method="Get">
					<h3>Filtrar por:</h3>
					<div class=" form-group row">
						<label for="id" class="col-sm-2 col-form-label">ID:</label>
						<div class="col-sm-7">
							<input class="form-control" min="1" type="number" id="isbn"
								name="id">
						</div>
					</div>
					<div class="form-group row">
						<label for="biblioteca" class="col-sm-2 col-form-label">Biblioteca:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" id="biblioteca" name="biblioteca"
								placeholder="Ingrese una biblioteca">
						</div>
					</div>
						<div class="form-group row">
							<label for="titulo" class="col-sm-2 col-form-label">Cliente:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="cliente" name="cliente"
									placeholder="Ingrese un cliente">
							</div>
						</div>
					<div class="form-group row">
						<label for="estado" class="col-sm-2 col-form-label">Estado:</label>
						<div class="col-sm-7">
							<select name="estado" id="estado">
								<option value="">Todos</option>
								<option value="Disponible">En biblioteca</option>
								<option value="Prestado">Prestado</option>
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label for="fechaAlta" class="col-sm-2 col-form-label">Fecha
							de Prestamo:</label>
						<div class="col-sm-7">
							<input type="date" class="form-control" id="fechaAlta"
								name="fechaAlta">
						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-7">
							<input class="col-sm-2 col-form-label" type="submit" value="Buscar">
						</div>
					</div>
				</form>
				<div class="col-12">
					<table class="table table-bordered table-hover">
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Biblioteca</th>
							<th scope="col">Cliente</th>
							<th scope="col">Fecha Alta</th>
							<th scope="col">Cantidad Dias</th>
							<th scope="col">Estado</th>
						</tr>
						<c:forEach var="obj" items="${prestamos}">
							<tr>
								<td>${obj[0]}</td>
								<td>${obj[1]}</td>
								<td>${obj[2]}</td>
								<td>${obj[3]}</td>
								<td>${obj[4]}</td>
								<td>${obj[5]}</td>
								<td>
									<form method="GET">
										<input type="button" value="Eliminar"
											data-id-biblioteca="${obj[0]}"											
											class="btn btn-danger eliminarbiblioteca"></input> 
											<input type="button"
											value="Modificar"
											onclick="location.href = 'paginaModificarBiblioteca.html?id=${obj[0]}';"
											class="btn btn-primary"></input>
										<c:choose>
											<c:when test="${obj[5] == 'Prestado'}">
												<input type="button" value="Info. Prestamo"
													onclick="location.href = 'listadoPrestamos.html?isbn=${obj[1]}';"
													class="btn btn-primary"></input>
											</c:when>
											<c:otherwise>
												<input type="button" value="Nuevo Prestamo"
													onclick="location.href = 'obtenerBibliotecaDesdeLista.html?idBiblioteca=${obj[0]}';"
													class="btn btn-primary"></input>
											</c:otherwise>
										</c:choose>
									</form>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="eliminarbibliotecaModal" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">Eliminar Prestamo</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class=" form-group row">
							<div class="col-lg-8 offset-2">�Esta Seguro que desea eliminar este Prestamo</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary">SI</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">No</button>
					</div>
				</div>
			</div>
		</div>


	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script type="text/javascript">
			$(document).ready(function () {
				$(document).off('click', '.eliminarbiblioteca');
				$(document).on('click','.eliminarbiblioteca', function (e) {
					let biblioteca = $(this).data('id-biblioteca');
					 $('#eliminarbibliotecaModal').modal('show');
					
					$('#eliminarbibliotecaModal').on('click', '.btn-primary', function(){
					    
					    $('#eliminarbibliotecaModal').modal('hide');
					    location.href = 'eliminarBiblioteca.html?id=' + biblioteca;
					    
					});
					

				});
			});
			
			
		</script>
</body>

</html>