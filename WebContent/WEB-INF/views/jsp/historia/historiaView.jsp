<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/jsp/menu/tags.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="/WEB-INF/views/jsp/menu/header.jsp" />
<body>
	<c:import url="/WEB-INF/views/jsp/menu/topMenu.jsp" />

	<div class="container">
		
		<a href='<c:url value="/usuarios/paciente"/>' class="btn btn-primary">Nuevo Paciente</a>
	
	<br>	<br>
	<h1 class="text-center">Lista de Pacientes</h1>
	<br>
	<table class="table table-responsive">
		<tr>
			<td>Nombre</td>
			<td>1er Apellido</td>
			<td>2do Apellido</td>
			<td>DNI</td>
			<td>Grupo Sanguineo</td>
			<td>Estado Civil</td>
			<td>Rol</td>
			<td>ACCION</td>
		</tr>
		
		
		<c:forEach items="${pacientes}" var="paciente">
		
		<tr>
			<td><c:out value="${paciente.nombre}"/></td>
			<td><c:out value="${paciente.apellido1}"/></td>
			<td><c:out value="${paciente.apellido2}"/></td>
			<td><c:out value="${paciente.dni}"/></td>
			<td><c:out value="${paciente.grupoSanguineo}"/></td>
			<td><c:out value="${paciente.estadoCivil}"/></td>
			<td><c:out value="${paciente.rol}"/></td>
			<td><a href='<c:url value="/historia/${paciente.id_usuario}/save"/>' class="btn btn-success text-bold">Crear Historia</a></td>
			</tr>
		
		</c:forEach>

	</table>

	</div>
	<c:import url="/WEB-INF/views/jsp/menu/includeScripts.jsp" />
<%-- 	<c:import url="/WEB-INF/views/jsp/menu/footer.jsp" /> --%>
</body>


</html>