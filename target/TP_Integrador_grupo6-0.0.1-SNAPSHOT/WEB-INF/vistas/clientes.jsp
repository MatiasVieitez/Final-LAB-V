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


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="//cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="/css/tables.css">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="//cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
        $(document).ready(function () {
            $('#table').DataTable();
        });
    </script>

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
				<input class="form-control" id="myInput" type="text" placeholder="Search..">
  <br>
				<div class="table-responsive">
					<table class="table table-bordered table-hover table-sm" id="MyTable" >
                        <thead>
						<tr>
								<th>ID</th>
								<th>DNI</th>
								<th>Nombre</th>
								<th>Apellido</th>
								<th>Sexo</th>
								<th>Nacionalidad</th>
								<th>Email</th>
								<th>Direccion</th>
								<th>Localidad</th>
								<th>Telefono</th>
								<th>Fecha de Nacimiento</th>
								<th>Acciones</th>
							</tr>
							</thead>
							<c:forEach var="obj" items="${clientesList}">
							<tbody id="myTable">
								<tr>
								 <form action="modificarCliente.html" method="post">
								 	
									<td>${obj.getId()} <input  type="text" hidden name="id" value="${obj.getId()}" > </td>
									<td>${obj.getDni()}<input  type="text" hidden name="dni" value="${obj.getDni()}" ></td>
									<td>${obj.getNombre()}<input  type="text" hidden name="nombre" value="${obj.getNombre()}" ></td>
									<td>${obj.getApellido()}<input  type="text" hidden name="apellido" value="${obj.getApellido()}" ></td>
									<td>${obj.getSexo()}<input  type="text" hidden name="sexo" value="${obj.getSexo()}" ></td>
									<td >${obj.getNacionalidad().getDescripcion()}<input  type="text" hidden name="nacionalidad" value="${obj.getNacionalidad().getId_nacionalidad()}" ></td>
									<td><input  type="text" name="correo" value="${obj.getEmail()}" ></td>
									<td><input type="text" name="direccion" value="${obj.getDireccion()}" ></td>
									<td><input type="text" name="localidad" value="${obj.getLocalidad()}" ></td>
									<td><input type="text" name="telefono" value="${obj.getTelefono()}" ></td>
									<td>${obj.getFechaNacimiento()}<input  type="text" hidden name="fNacimiento" value="${obj.getFechaNacimiento()}" ></td>
									<td>
											<input type="button" value="Eliminar" data-id-cliente="${obj.getId()}" class="btn btn-danger eliminarCliente"></input>							
	                              	</td>
	                              	<td><input type="submit" value="Modificar"  class="btn btn-primary"></input></td>
	                              	
                              	</form>
								</tr>
								</tbody>
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
		
		
		<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
				
</body>
</html>