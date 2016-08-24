<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:import url="/WEB-INF/views/jsp/menu/tags.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<c:import url="/WEB-INF/views/jsp/menu/header.jsp" />
  <title>Usuarios</title>
  
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<script src="/resources/js/jquery-1.12.0.min.js" ></script> 
<script src="/resources/js/jquery-ui.js" ></script> 
 
<script type="text/javascript">

function validarFormulario(){
	jQuery.validator.messages.required = 'Este campo es obligatorio.';
	
	$("#searchByName").validate();
 
	$("#botonByName").click(function(){
	   var validado = $("#searchByName").valid();
	   if(validado){
	     alert('El formulario es correcto.');
	   }
	    });
 
 }
 $(document).ready(function(){
    validarFormulario();
 });

 

</script>
  
<body>
  <c:import url="/WEB-INF/views/jsp/menu/topMenu.jsp" />
 <div class="container">
	
		<div class="row">
			<div class="form-group">
			<a href='<c:url value="/usuarios/administrador"/>'
				class="btn btn-primary">Nuevo Administrador</a> <a
				href='<c:url value="/usuarios/profesional"/>'
				class="btn btn-primary">Nuevo Profesional</a> <a
				href='<c:url value="/usuarios/paciente"/>' class="btn btn-primary">Nuevo Paciente</a>
			</div>	
		</div>
		<div class="row">
			<div class="ui-widget form-group col-md-4">
  			<form id = "searchByName" action="${pageContext.request.contextPath}/usuarios/searchByName"> 
				<input type="hidden" id="path" value="${pageContext.request.contextPath}" /> 		
					<input name="apellido" type="text" id="buscarAdmin" class="form-control" placeholder="Buscar por Apellido"></input>
 				  	
 				    <button id="botonByName"  type="submit" class="btn btn-default">Buscar</button>  
    		  </form>  
				</div>
			<div class="ui-widget form-group col-md-4">
  			<form action="${pageContext.request.contextPath}/usuarios/searchByDNI"> 
				<input type="hidden" id="path" value="${pageContext.request.contextPath}" /> 		
					<input name="dni" type="text" value="" class="form-control" placeholder="Buscar por DNI"></input>
 				    <button type="submit" class="btn btn-default">Buscar</button>  
    		  </form>  
    		  <div><h3 style='color:red;'>${msj}</h3></div>
			</div>
	</div>
	
		


	<div id="us_list">
		<h1 class="text-center">Lista de Usuarios</h1>
		<br>
		<table class="table table-responsive">
			<tr>
				<td>Nombre</td>
				<td>1er Apellido</td>
				<td>2do Apellido</td>
				<td>DNI</td>
				<td>Mail</td>
				<td>Rol</td>
				<td>ACCION</td>
			</tr>


			<c:forEach items="${usuarios}" var="us">
				<tr>
					<td><c:out value="${us.nombre}" /></td>
					<td><c:out value="${us.apellido1}" /></td>
					<td><c:out value="${us.apellido2}" /></td>
					<td><c:out value="${us.dni}" /></td>
					<td><c:out value="${us.mail}" /></td>
					<td><c:out value="${us.rol}" /></td>
					<td><a
						href='<c:url value="/usuarios/administrador/${us.id_usuario}/update"/>'
						class="btn btn-primary">Modificar</a></td>
					<td><a
						href='<c:url value="/usuarios/administrador/${us.id_usuario}/delete"/>'
						class="btn btn-danger">Eliminar</a></td>
				</tr>

			</c:forEach>
			
			<c:if test="${usuarioDNI != null}">
			<tr>
					<td><c:out value="${usuarioDNI.nombre}" /></td>
					<td><c:out value="${usuarioDNI.apellido1}" /></td>
					<td><c:out value="${usuarioDNI.apellido2}" /></td>
					<td><c:out value="${usuarioDNI.dni}" /></td>
					<td><c:out value="${usuarioDNI.mail}" /></td>
					<td><c:out value="${usuarioDNI.rol}" /></td>
					<td><a
						href='<c:url value="/usuarios/administrador/${usuarioDNI.id_usuario}/update"/>'
						class="btn btn-primary">Modificar</a></td>
					<td><a
						href='<c:url value="/usuarios/administrador/${usuarioDNI.id_usuario}/delete"/>'
						class="btn btn-danger">Eliminar</a></td>
				</tr>
<%-- 		<p>USUARIO:	<c:out value="${usuarioDNI}"/> </p> --%>
		</c:if>

		</table>
		
</div>
	</div>
</body>
</html>