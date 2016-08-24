<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:import url="/WEB-INF/views/jsp/menu/tags.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="/WEB-INF/views/jsp/menu/header.jsp" />

<body>
	<c:import url="/WEB-INF/views/jsp/menu/topMenu.jsp" />

	<form:form action="${pageContext.request.contextPath}/usuarios/paciente/save"
		method="POST" class="container" commandName="pacienteForm">

		<fieldset>

			<form:input path="id_usuario" type="hidden"
				value="${pacienteForm.getId_usuario()}" />
			<input name="id_domicilio" type="hidden"
				value="${domicilio.getId_domicilio()}" />
			<!-- Form Name -->
			<legend>Datos de Cuenta</legend>

			<div class="row">
				<!-- Text input-->
				<div class="form-group col-md-4">
					<label class="control-label" for="mail">Email</label>
					<form:input path="mail" type="text" class="form-control" />

				</div>

				<!--Password input-->
				<div class="form-group col-md-4">
					<label class="control-label" for="password">Contraseña</label>
					<form:input path="password" type="password" class="form-control" />
				</div>
				<!-- Password input-->
				<div class="form-group col-md-4">
					<label class="control-label" for="password2">Confirmar
						Contraseña</label> <input name="password2" type="password"
						class="form-control" />
				</div>
			</div>


			<legend>Datos Paciente</legend>
			<div class="row">
				<!-- Text input-->
				<div class="form-group col-md-4">
					<label class="control-label" for="textinput">Nombre</label>
					<form:input path="nombre" type="text" class="form-control" />

				</div>

				<!-- Text input-->
				<div class="form-group col-md-4">
					<label class="control-label" for="apellido1">Apellido</label>
					<form:input path="apellido1" type="text" class="form-control" />

				</div>

				<!-- Text input-->
				<div class="form-group">
					<div class="form-group col-md-4">
						<label class="control-label" for="apellido2">Apellido
							Madre</label>
						<form:input path="apellido2" type="text" class="form-control" />

					</div>
				</div>
			</div>
			<div class="row">
				<!--Text input-->
				<div class="form-group col-md-4">
					<label class=" control-label" for="dni">DNI:</label>
					<form:input path="dni" type="text" class="form-control" />
				</div>
				



				<!-- Button Drop Down -->
				<div class="form-group col-md-4">
					<label class="control-label" for="rol">Grupo Sanguíneo</label>

					<form:select path="grupoSanguineo" class="form-control">
						<option value="NONE" label="--- Select ---" />
						<option value="AB+" label="AB+" />
						<option value="AB-" label="AB-" />
						<option value="A+" label="A+" />
						<option value="A-" label="A-" />
						<option value="B+" label="B+" />
						<option value="B-" label="B-" />
						<option value="O+" label="O+" />
						<option value="O-" label="O-" />
					</form:select>
				</div>
			</div>

			<div class="row">

				<!-- Select Basic -->
				<div class="form-group col-md-4">
					<label class="control-label" for="sexo">Sexo</label>
					<form:select path="sexo" class="form-control">
						<option value="NONE" label="--- Select ---" />
						<option value="Masculino" label="Masculino" />
						<option value="Femenino" label="Femenino" />
					</form:select>
				</div>

				<!-- Text input-->
				<div class="form-group col-md-4">
					<label class="control-label" for="telefono">Teléfono</label>
					<form:input path="telefono" type="text" class="form-control" />

				</div>
				<!--Text input-->
				<div class="form-group col-md-4">
					<label class="control-label" for="dni">Estado Civil</label>
					<form:select path="estadoCivil" class="form-control">
						<option value="NONE" label="--- Select ---" />
						<option value="Soltero" label="Soltero" />
						<option value="Casado" label="Casado" />
						<option value="Divorciado" label="Divorciado" />
						<option value="Viudo" label="Viudo" />
					</form:select>
				</div>
			</div>

			<div class="row">
				<!-- File Button -->
				<div class="form-group col-md-4">
					<label class="control-label" for="foto">Foto Perfil</label>
					<form:input path="foto" class="input-file" type="file" />
				</div>
				<!-- Text input-->
				<div class="form-group col-md-4">
				<label class="control-label" for="foto">Fecha Nacimiento:</label>
				 <form:input path="fechaNacimiento" type="text" id="datepicker" class="form-control"/>
				 </div>
				<form:input type="hidden" path="rol" value="ROLE_PACIENTE" />
				<form:input type="hidden" path="estado" value="Alta" />

			</div>

			<legend>Datos Domicilio</legend>
			<div class="row">

				<div class="form-group col-md-4">
					<label class="control-label" for="provincia">Provincia</label> <input
						name="provincia" type="text" class="form-control"
						value="${domicilio.getProvincia()}" />

				</div>
				<div class="form-group col-md-4">
					<label class="control-label" for="localidad">Localidad</label> <input
						name="localidad" type="text" class="form-control"
						value="${domicilio.getLocalidad() }" />

				</div>
				<div class="form-group col-md-4">
					<label class="control-label" for="direccion">Direccion</label> <input
						name="direccion" type="text" class="form-control"
						value="${domicilio.getDireccion()}" />

				</div>
			</div>
			<div class="row text-center">
				<input class="btn btn-primary form-group" type="submit"
					value="Guardar" />
			</div>
		</fieldset>

	</form:form>

</body>
<c:import url="/WEB-INF/views/jsp/menu/includeScripts.jsp" />
<%-- <c:import url="/WEB-INF/views/jsp/menu/footer.jsp"/> --%>

</html>