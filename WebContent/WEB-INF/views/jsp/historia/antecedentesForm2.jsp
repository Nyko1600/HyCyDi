<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:import url="/WEB-INF/views/jsp/menu/tags.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<c:import url="/WEB-INF/views/jsp/menu/header.jsp" />

<body>
	<c:import url="/WEB-INF/views/jsp/menu/topMenu.jsp" />

	<h1 class="text-center">Antecedentes Medicos</h1>
	<br>

	<form id="antecedentes" class="container" action="${pageContext.request.contextPath}/ficha/antecedentes/save" method="POST">
	<legend>Habitos Tóxicos</legend>	
	<div class="row">	
		<div class="form-group col-md-12">
		<!-- TOXICOS-->	<label for="titulo">id_ant: </label>
 		<input name="id_antecedentes" type="text" value="${id_antecedentes}" class="form-control"/>  
		<label for="titulo">id_ficha: </label>
			<input name="id_ficha" type="text" value="${id_ficha}" class="form-control"/> 
			<label for="titulo">id_habitos: </label>
  			<input name="id_habitos" value="0" type="text" class="form-control"/> 
 		</div>
 		<div class="form-group col-md-4">
				<label for="titulo">Alcohol: </label>
		<input name="alcohol" type="text" value="${alcohol}" class="form-control"/>
		</div>
		<div class="form-group col-md-4">
				<label for="titulo">Tabaco: </label>
		<input name="tabaco" type="text" value="${tabaco}" class="form-control"/>
		</div>
		<div class="form-group col-md-4">
				<label for="titulo">Drogas: </label>
		<input name="drogas" type="text" value="${drogas}" class="form-control"/>
		</div>
		<div class="form-group col-md-4">
				<label for="titulo">Infusiones: </label>
			<input name="infusiones"  type="text" value="${infusiones}" class="form-control"/>
		</div>
		<div class="form-group col-md-8">
				<label for="titulo">Otros: </label>
		<input name="otrosHabitos" type="text" value="${otros}" class="form-control"/>
		</div>
		<div class="form-group col-md-12">
				<label for="titulo">Descripción: </label>
<!-- 		<textarea name="descripcion" class="form-control" rows="3" ></textarea> -->
 		<input name="descripcionHabitos" id="descripcion" type="text" value="${descripcion}" class="form-control"/> 
		</div>
	</div>

   
		<legend>Antecedentes Familiares</legend>
		<div class="row">
		<!-- FAMILIARES-->
			<div class="form-group col-md-12">
			<label for="titulo">Id_familar: </label>
<%-- 			<input name="id_familiares" type="text" value="${familiares.getId_familiares()}" class="form-control"/>  --%>
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Diabetes: </label>
				<input name="diabetes" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Hiper Tensión Arterial: </label>
				<input name="hipertension" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Tuberculosis: </label>
				<input name="tuberculosis" type="text" value="" class="form-control" />
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Gemelar: </label>
				<input name="gemelarFamiliar" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-8">
				<label for="titulo">Otros: </label>
				<input name="otrosFamiliar" type="text" value="" class="form-control"/>
			</div>
	</div>		
	
	<legend>Antecedentes Fisiologicos</legend>
		<div class="row">
		<!-- FAMILIARES-->
			<div class="form-group col-md-12">
			<label for="titulo">Id_fisiologicos: </label>
<%-- 			<input name="id_familiares" type="text" value="${familiares.getId_familiares()}" class="form-control"/>  --%>
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Alimentacion: </label>
				<input name="alimentacion" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Dipsia: </label>
				<input name="dipsia" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Diuresis: </label>
				<input name="diuresis" type="text" value="" class="form-control" />
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Catarsis: </label>
				<input name="catarsis" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-8">
				<label for="titulo">somnia: </label>
				<input name="somnia" type="text" value="" class="form-control"/>
			</div><div class="form-group col-md-8">
				<label for="titulo">Otros: </label>
				<input name="otrosFisiologicos" type="text" value="" class="form-control"/>
			</div>
	</div>		
	<legend>Antecedentes Patologicos</legend>
		<div class="row">
		<!-- FAMILIARES-->
			<div class="form-group col-md-12">
			<label for="titulo">Id_patologicos: </label>
<%-- 			<input name="id_patologicos" type="text" value="${familiares.getId_familiares()}" class="form-control"/>  --%>
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Infancia: </label>
				<input name="infancia" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Adulto: </label>
				<input name="adulto" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Diabetes: </label>
				<input name="DBT" type="text" value="" class="form-control" />
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Hipertensión Arterial: </label>
				<input name="HTA" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-8">
				<label for="titulo">Tuberculosis: </label>
				<input name="TBC" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-8">
				<label for="titulo">Gemelar: </label>
				<input name="gemelarPatologico" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-8">
				<label for="titulo">Quirurgicos: </label>
				<input name="quirurgicos" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-8">
				<label for="titulo">Traumatologicos: </label>
				<input name="traumatologicos" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-8">
				<label for="titulo">Alergicos: </label>
				<input name="alergicos" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-8">
				<label for="titulo">Otros: </label>
				<input name="otrosPatologicos" type="text" value="" class="form-control"/>
			</div>
	</div>
	<legend>Antecedentes Ginecologicos</legend>
		<div class="row">
		<!-- FAMILIARES-->
			<div class="form-group col-md-12">
			<label for="titulo">id_Ginecologicos: </label>
<%-- 			<input name="id_ginecologicos" type="text" value="${familiares.getId_familiares()}" class="form-control"/>  --%>
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Fecha Última Menstruación: </label>
				<input name="FUM" type="date" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Fecha Primer Parto: </label>
				<input name="FPP" type="date" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Edad Gestacional: </label>
				<input name="edadGestacional" type="text" value="" class="form-control" />
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Menarca: </label>
				<input name="menarca" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-8">
				<label for="titulo">RM(Rit. Menstrual): </label>
				<input name="RM" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-8">
				<label for="titulo">IRS(Inicio Relaciones Sexuales): </label>
				<input name="IRS" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-8">
				<label for="titulo">Nro Parejas: </label>
				<input name="nroParejas" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-8">
				<label for="titulo">Flujo Genital: </label>
				<input name="flujoGenital" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-8">
				<label for="titulo">Gestas: </label>
				<input name="gestas" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-8">
				<label for="titulo">Partos: </label>
				<input name="partos" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-8">
				<label for="titulo">Cesáreas: </label>
				<input name="cesareas" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-8">
				<label for="titulo">Abortos: </label>
				<input name="abortos" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-8">
				<label for="titulo">Descripcion: </label>
				<input name="descripcionGinecologicos" type="text" value="" class="form-control"/>
			</div>
	</div>
	
			<br>
			<input id = "enviarForm" class="btn btn-success form-group" value="Guardar" type="submit" />
			
			</form>
	
	<div id = "respuesta"></div>
		<div id = "respuesta2"></div>
	
</body>
<c:import url="/WEB-INF/views/jsp/menu/includeScripts.jsp" />
<%-- <c:import url="/WEB-INF/views/jsp/menu/footer.jsp"/> --%>

</html>