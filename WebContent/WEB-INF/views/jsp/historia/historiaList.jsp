<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/jsp/menu/tags.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="/WEB-INF/views/jsp/menu/header.jsp" />
<body>
	<c:import url="/WEB-INF/views/jsp/menu/topMenu.jsp" />
	<script type="text/javascript">
	$(document).ready(function(){
	  
	    //funcion que lee los a href
	    $('tr').each(function() {
	    	  var href = $(this).attr('href');
	    	  $(this).click(function() { window.location = href; })
	    	});
});

	</script>
	<div class="container">
		
		<br> <br>
		<h1 class="text-center">Lista de Historias Clinicas</h1>
		<br>
		<table class="table table-hover">
			 <thead>
			<tr>
				<th>Nro Historia</th>
				<th>Nombre</th>
				<th>1er Apellido</th>
				<th>2do Apellido</th>
				<th>DNI</th>

			</tr>
 		</thead>
		<tbody>
			<c:forEach items="${historias}" var="historia">

				<tr  id="filas" href='<c:url value="/ficha/${historia.id_historia}"/>'>
					<td><c:out value="${historia.nro_historia}" /></td>
					<td><c:out value="${historia.getUsuario().getNombre()}" /></td>
					<td><c:out value="${historia.getUsuario().getApellido1()}" /></td>
					<td><c:out value="${historia.getUsuario().getApellido2()}" /></td>
					<td><c:out value="${historia.getUsuario().getDni()}" /></td>
				</tr>

			</c:forEach>
		</tbody>
		</table>

	</div>









	<c:import url="/WEB-INF/views/jsp/menu/includeScripts.jsp" />
	<%-- 	<c:import url="/WEB-INF/views/jsp/menu/footer.jsp" /> --%>
</body>


</html>