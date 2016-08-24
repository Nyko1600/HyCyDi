<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:import url="/WEB-INF/views/jsp/menu/tags.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="/WEB-INF/views/jsp/menu/header.jsp" />

<body>
	<c:import url="/WEB-INF/views/jsp/menu/topMenu.jsp" />
	<div class="container">
	<form action="${pageContext.request.contextPath}/historia/save"
		method="POST" class="form-inline">

		<fieldset>

			<legend>Datos</legend>

			<div class="form-group">
			<input name="id_paciente" type="hidden" value="${paciente.getId_usuario()}">
				<label class="control-label" for="mail">Nro Historia</label> <input
					name="nro_historia" type="text" class="form-control" /> 
					<input class="btn btn-primary form-group" type="submit" value="Guardar" />

			</div>
		</fieldset>

	</form>
</div>
</body>
<c:import url="/WEB-INF/views/jsp/menu/includeScripts.jsp" />
<%-- <c:import url="/WEB-INF/views/jsp/menu/footer.jsp"/> --%>

</html>