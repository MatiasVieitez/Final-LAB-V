<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clientes</title>
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
					<h1>Clientes</h1>
					<input type="button" value="Agregar Cliente" onclick="location.href = 'altaCliente.html';" class="btn btn-success"></input>
				</div>
				<br>
				<form class="col-12" action="listarClienteFiltro.html"	method="Get">
					<h3>Filtrar por:</h3>
					<div class=" form-group row">
						<label for="nombre" class="col-sm-2 col-form-label">Nombre:</label>
						<div class="col-sm-7">
							<input class="form-control"  type="text" id="nombre" name="nombre" placeholder="Ingrese nombre cliente">
						</div>
					</div>
					<div class="form-group row">
						<label for="apellido" class="col-sm-2 col-form-label">Apellido:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" id="apellido" name="apellido" placeholder="Ingrese apellido cliente">
						</div>
					</div>
					<div class="form-group row">
						<label for="nacionalidad" class="col-sm-2 col-form-label">Nacionalidad:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" id="nacionalidad" name="nacionalidad" placeholder="Ingrese nacionalidad cliente">
						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-7">
							<input class="col-sm-2 col-form-label" type="submit" value="Filtrar">
						</div>
					</div>
				</form>
				<h3>${msg}</h3>
				<div class="table-responsive">
					<table class="table table-bordered table-hover table-sm">
						<tr>
								<td>ID</td>
								<td>DNI</td>
								<td>Nombre</td>
								<td>Apellido</td>
								<td>Sexo</td>
								<td>Nacionalidad</td>
								<td>Email</td>
								<td>Direccion</td>
								<td>Localidad</td>
								<td>Telefono</td>
								<td>Fecha de Nacimiento</td>
								<td>Acciones</td>
							</tr>
							<c:forEach var="obj" items="${clientesList}">
							
								<tr>
								 <form action="modificarCliente.html" method="post">
								 	
									<td><input type="text"  name="id" value="${obj.getId()}" readonly></td>
									<td><input type="text" name="dni" value="${obj.getDni()}" ></td>
									<td><input type="text" name="nombre" value="${obj.getNombre()}" ></td>
									<td><input type="text" name="apellido" value="${obj.getApellido()}" ></td>
									<td><input type="text" name="sexo" value="${obj.getSexo()}" ></td>
									<td><select required name="nacionalidad">                    			
	                           	
                        				<option default value="${obj.getNacionalidad().getId_nacionalidad()}">${obj.getNacionalidad().getDescripcion()}</option>
                   						 <c:forEach items="${nacionalidadesList}" var="item">
                       					 <option value="${item.getID()}">${item.getDescripcion()}</option>
                   						</c:forEach>
									</select></td>
									<td><input type="text" name="correo" value="${obj.getEmail()}" ></td>
									<td><input type="text" name="direccion" value="${obj.getDireccion()}" ></td>
									<td><input type="text" name="localidad" value="${obj.getLocalidad()}" ></td>
									<td><input type="text" name="telefono" value="${obj.getTelefono()}" ></td>
									<td><input type="text" name="fNacimiento" value="${obj.getFechaNacimiento()}" ></td>
									<td>
											<input type="button" value="Eliminar" data-id-cliente="${obj.getId()}" class="btn btn-danger eliminarCliente"></input>							
	                              	</td>
	                              	<td><input type="submit" value="Modificar"  class="btn btn-primary"></input></td>
	                              	
                              	</form>
								</tr>
							</c:forEach>
						</table>
						</div>
					</div>
				</div>
			</div>
	<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Detalles
						del cliente</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>
		<!-- Modal -->
	<div class="modal fade" id="eliminarclienteModal" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">Eliminar Cliente</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class=" form-group row">
							<div class="col-lg-8 offset-2">Quiere confirmar esta operacion ? </div>
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
				$(document).off('click', '.eliminarCliente');
				$(document).on('click','.eliminarCliente', function (e) {
					let cliente = $(this).data('id-cliente');
					 $('#eliminarclienteModal').modal('show');
					
					$('#eliminarclienteModal').on('click', '.btn-primary', function(){
					    
					    $('#eliminarclienteModal').modal('hide');
					    location.href = 'eliminarCliente.html?id=' + cliente;
					    
					});
				});
			});					
		</script>		
</body>
</html>