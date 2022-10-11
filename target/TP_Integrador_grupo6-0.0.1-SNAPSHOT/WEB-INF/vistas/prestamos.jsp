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
								<td>${obj.getId()}</td>
								<td>${obj.getBiblioteca().getId()}</td>
								<td>${obj.getCliente().getNombre()} ${obj.getCliente().getApellido()}</td>
								<td>${obj.getFechaPrestamo()}</td>
								<td>${obj.getCantDias()}</td>
								<td>${obj.getBiblioteca().getEstado()}</td>
								<td><input type="button" value="Devolver Libro"
									data-id-prestamo="${obj.getId()}"
									class="btn btn-success devolverLibro"></input></td>							
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="modal fade" id="devolverLibroModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Devolver
						libro</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class=" form-group row">
						<div class="col-lg-8 offset-2">¿Esta seguro que desea
							devolver el libro?</div>
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



	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>

	<script type="text/javascript">
			$(document).ready(function () {
				$(document).off('click', '.devolverLibro');
				$(document).on('click','.devolverLibro', function (e) {
					let prestamo = $(this).data('id-prestamo');
					 $('#devolverLibroModal').modal('show');
					
					$('#devolverLibroModal').on('click', '.btn-primary', function(){
					    
					    $('#devolverLibroModal').modal('hide');
					    location.href = 'closePrestamo.html?idPrestamo=' + prestamo;
					    
					});
					

				});
			});
			
			
		</script>
</body>

</html>