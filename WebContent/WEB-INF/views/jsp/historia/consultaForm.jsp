<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:import url="/WEB-INF/views/jsp/menu/tags.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="/WEB-INF/views/jsp/menu/header.jsp" />

<body>
	<c:import url="/WEB-INF/views/jsp/menu/topMenu.jsp" />

	
<!-- 	<legend class="col-md-12 alert alert-info text-center">CONSULTA MÉDICA</legend>	 -->

	<form action="${pageContext.request.contextPath}/consultas/save" class="container" method="POST">
		<div id="Consulta" class="form-group">
			<input name="id_historia" type="hidden" value="${id_historia}" />
			<input name="usuario" type="hidden" value="${userMail}" />
		</div>
		<h1 class="col-md-12 alert alert-info text-center">CONSULTA MÉDICA</h1>
		<div class="row">
			<ul class="nav nav-pills nav-justified">
				<li class="active"><a data-toggle="tab" href="#anamnesis">Anamnesis</a></li>
				<li><a data-toggle="tab" href="#exploracion">Exploracion</a></li>
				<li><a data-toggle="tab" href="#observaciones">Observaciones</a></li>
			</ul>

			<div class="tab-content">
				<div id="anamnesis" class="tab-pane fade in active">
					<textarea name="anamnesis" class="form-control" rows="5"></textarea>
				</div>
				<div id="exploracion" class="tab-pane fade">
					<textarea name="exploracion" class="form-control" rows="5"></textarea>
				</div>

				<div id="observaciones" class="tab-pane fade">
					<textarea name="observaciones" class="form-control" rows="5"></textarea>
				</div>

			</div>
		</div>
		
		<h1 class="col-md-12 alert alert-success text-center">DIAGNOSTICO</h1>
	
		<div class="row">
			<ul class="nav nav-pills nav-justified">
				<li class="active"><a data-toggle="tab" href="#titulo">Titulo</a></li>
				<li><a data-toggle="tab" href="#tratamiento">Tratamiento</a></li>
				<li><a data-toggle="tab" href="#descripcion">Descripción</a></li>
			</ul>

			<div class="tab-content">
				<div id="titulo" class="tab-pane fade in active">
					<textarea name="titulo" class="form-control" rows="5"></textarea>
				</div>
				<div id="tratamiento" class="tab-pane fade">
					<textarea name="tratamiento" class="form-control" rows="5"></textarea>
				</div>

				<div id="descripcion" class="tab-pane fade">
					<textarea name="descripcion" class="form-control" rows="5"></textarea>
				</div>

			</div>
		</div>
			
		<br>
		<div class="form-group col-md-12 text-center">
			<input class="btn btn-success form-group" type="submit" value="Guardar" />
		</div>
	</form>
	
	


</body>
<c:import url="/WEB-INF/views/jsp/menu/includeScripts.jsp" />
<%-- <c:import url="/WEB-INF/views/jsp/menu/footer.jsp"/> --%>

</html>