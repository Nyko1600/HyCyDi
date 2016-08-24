<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:import url="/WEB-INF/views/jsp/menu/tags.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="/WEB-INF/views/jsp/menu/header.jsp" />

<body>
	<c:import url="/WEB-INF/views/jsp/menu/topMenu.jsp" />
<script type="text/javascript">
	$(document).ready(function(){
	    $("#filas").hover(function(){
        $(this).css("background-color", "lightblue");
        }, function(){
        $(this).css("background-color", "white");
    });
	    //funcion que lee los a href
	    $('tr').each(function() {
	    	  var href = $(this).attr('href');
	    	  $(this).click(function() { window.location = href; })
	    	});
});

	</script>
<h1 class="text-center">FICHA MÉDICA</h1>
<br>
	<form:form action="${pageContext.request.contextPath}/ficha/save" class="container" method="POST"
		commandName="fichaForm" >
		<form:input path="id_ficha" type="hidden" value="${fichaForm.getId_ficha()}"/>
		<input name="id_historia" type="hidden" value="${id_historia}" />

		<ul class="nav nav-pills nav-justified">
			<li class="active" role="presentation"><a data-toggle="tab" href="#alergias">Alergias</a></li>
			<li role="presentation"><a data-toggle="tab" href="#vacunas">Vacunas</a></li>
			<li role="presentation"><a data-toggle="tab" href="#tratamientoHabitual">Tratamiento
					Habitual</a></li>
			<li role="presentation"><a data-toggle="tab" href="#enfermedadesCronicas">Enfermedades
					Crónicas</a></li>

		</ul>
		<div class="tab-content">
		<div id="alergias" class="tab-pane fade in active">
				<form:textarea path="alergias" class="form-control" rows="5" />
			</div>
			<div id="vacunas" class="tab-pane fade">
				<form:textarea path="vacunas" class="form-control" rows="5" />
			</div>

				<div id="tratamientoHabitual" class="tab-pane fade">
					<form:textarea path="tratamientoHabitual" class="form-control" rows="5" />
				</div>
				<div id="enfermedadesCronicas" class="tab-pane fade">
					<form:textarea path="enfermedadesCronicas" class="form-control" rows="5" />
				</div>
		</div>
		<br><br>
		<div class="row text-center">
				<input class="btn btn-success form-group" type="submit"
					value="Guardar" />
			</div>
	</form:form>

	
	<div class="container">
		
		<br> <br>
		<h1 class="text-center">Lista de Fichas Clinicas</h1>
		<br>
		<table class="table table-responsive">
			<tr>
				<td>id</td>
				<td>Fecha</td>
				<td>Alergias</td>
				<td>Vacunas</td>
				<td>Tratamiento Habitual</td>
				<td>Enfermedades Cronicas</td>
				<td></td>
				<td></td>
				<td></td>

			</tr>


			<c:forEach items="${fichas}" var="ficha">

				<tr  id="fila">
					<td><c:out value="${ficha.id_ficha}" /></td>
					<td><c:out value="${ficha.fecha}" /></td>
					<td><c:out value="${ficha.alergias}" /></td>
					<td><c:out value="${ficha.vacunas}" /></td>
					<td><c:out value="${ficha.tratamientoHabitual}" /></td>
					<td><c:out value="${ficha.enfermedadesCronicas}" /></td>
					<td><a href='<c:url value="/ficha/antecedentes/${ficha.id_ficha}"/>' class="btn btn-success text-bold">Antecedentes</a></td>
					<td><a href='<c:url value="#"/>' class="btn btn-primary text-bold">Modificar</a></td>
					<td><a href='<c:url value="/ficha/delete/${ficha.id_ficha}"/>' class="btn btn-danger text-bold">Eliminar</a></td>
				</tr>

			</c:forEach>

		</table>

	</div>
	
	<c:out value="${sessionScope.id_historia}"></c:out>
</body>
<c:import url="/WEB-INF/views/jsp/menu/includeScripts.jsp" />
<%-- <c:import url="/WEB-INF/views/jsp/menu/footer.jsp"/> --%>

</html>