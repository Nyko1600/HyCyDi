<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/jsp/menu/tags.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="/WEB-INF/views/jsp/menu/header.jsp" />
<body>
	<c:import url="/WEB-INF/views/jsp/menu/topMenu.jsp" />

	<div class="container">
		
		<a href='<c:url value="/usuarios/administrador"/>' class="btn btn-primary">Nuevo Administrador</a>
	
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
	<h1 class="text-center">Lista de Administradores</h1>
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
		
		
		<c:forEach items="${admins}" var="admins">
		
		<tr>
			<td><c:out value="${admins.nombre}"/></td>
			<td><c:out value="${admins.apellido1}"/></td>
			<td><c:out value="${admins.apellido2}"/></td>
			<td><c:out value="${admins.dni}"/></td>
			<td><c:out value="${admins.mail}"/></td>
			<td><c:out value="${admins.rol}"/></td>
			<td><a href='<c:url value="/usuarios/administrador/${admins.id_usuario}/update"/>' class="btn btn-primary">Modificar</a></td>
			<td><a href='<c:url value="/usuarios/administrador/${admins.id_usuario}/delete"/>' class="btn btn-danger">Eliminar</a></td>			
			</tr>
		
		</c:forEach>

	</table>

	</div>









	<c:import url="/WEB-INF/views/jsp/menu/includeScripts.jsp" />
<%-- 	<c:import url="/WEB-INF/views/jsp/menu/footer.jsp" /> --%>
</body>


</html>