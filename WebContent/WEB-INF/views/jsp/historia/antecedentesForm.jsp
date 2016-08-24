<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:import url="/WEB-INF/views/jsp/menu/tags.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<c:import url="/WEB-INF/views/jsp/menu/header.jsp" />
	<script>
	
		function activarFUM() {
		    document.getElementById("FUM").disabled = false;
		    document.getElementById("FUM").required = true;
		}
		function activarFPP() {
		     document.getElementById("FPP").disabled = false;
		     document.getElementById("FUM").required = true;
		}
		
		function desactivarFUM() {
	    document.getElementById("FUM").disabled = true;
	    document.getElementById("FUM").required = false;
	    }
		
		function desactivarFPP() {
		    document.getElementById("FPP").disabled = true;
		    document.getElementById("FPP").required = false;
		    }
	
	
	
	</script>
<body onload="desactivarFPP();desactivarFUM()">
	<c:import url="/WEB-INF/views/jsp/menu/topMenu.jsp" />
<div class="page-header alert alert-success">
	<h1 class="text-center">Antecedentes Medicos</h1>
	</div>
	<br>

	<form id="antecedentes" class="container well" action="${pageContext.request.contextPath}/ficha/antecedentes/save" method="POST">
	<legend class="col-md-12 alert alert-info">Habitos Tóxicos</legend>	
	
	<div class="row">	
		<div class="form-group col-md-12">
		<!-- TOXICOS-->	
<!-- 		<label for="titulo">id_ant: </label> -->
 		<input name="id_antecedentes" type="hidden" value="${id_antecedentes}" class="form-control"/>  
<!-- 		<label for="titulo">id_ficha: </label> -->
			<input name="id_ficha" type="hidden" value="${id_ficha}" class="form-control"/> 
<!-- 			<label for="titulo">id_habitos: </label> -->
  			<input name="id_habitos" value="0" type="hidden" class="form-control"/> 
 		</div>
 	</div>
 	<div class="row">
 		
			<div class="form-inline col-md-3">
			<label for="alcohol" class="control-label" >Alcohol:  </label>
			<input type="checkbox" id="alcohol" value="SI" name="alcohol" class="checkbox">		
 			<input type="hidden" id="alcohol" value="NO" name="alcohol">		
 				
 				</div>
 		<div class="form-inline col-md-3">
 			<label for="tabaco">Tabaco: </label>
			<input  id="tabaco" name="tabaco" type="checkbox" class="checkbox" value="SI"/>
			<input type="hidden" id="tabaco" value="NO" name="tabaco">
		</div>
		<div class="form-inline col-md-3">
			<label for="drogas">Drogas: </label>
			<input id="drogas" name="drogas"  type="checkbox" class="checkbox" value="SI"/>
			<input type="hidden" id="drogas" value="NO" name="drogas">
 		</div>
 		
 		<div class="form-inline col-md-3">
 		<label for="infusiones">Infusiones: </label>
			<input id="infusiones" name="infusiones" type="checkbox" class="checkbox" value="SI"/>
			<input type="hidden" id="infusiones" name="infusiones" value="NO">
		</div>
	</div>	
	<hr>
	<div class="row">
		<div class="form-group col-md-4">
		<label for="titulo">Otros: </label>
		<input name="otrosHabitos" type="text" value="${otros}" class="form-control"/>
		</div>
		<div class="form-group col-md-8">
				<label for="titulo">Descripción: </label>
<!-- 		<textarea name="descripcion" class="form-control" rows="3" ></textarea> -->
 		<input name="descripcionHabitos" id="descripcion" type="text" value="${descripcion}" class="form-control"/> 
		</div>
	</div>
   <br>
   
		<legend class="col-md-12 alert alert-info">Antecedentes Familiares</legend>	
		
		<div class="row">		
		<!-- FAMILIARES-->
			<div class="form-group col-md-12">
<!-- 			<label for="titulo">Id_familar: </label> -->
<%-- 			<input name="id_familiares" type="text" value="${familiares.getId_familiares()}" class="form-control"/>  --%>
			</div>
		</div>
		<div class="row">
			<div class="form-inline col-md-3">
				<label for="diabetes">Diabetes: </label>
				<input name="diabetes" id="diabetes" type="checkbox" value="SI" class="checkbox"/>
				<input type="hidden" id="_diabetes" name="diabetes" value="NO">
			</div>
			<div class="form-inline col-md-3">
				<label for="hipertension">Hipertensión Arterial: </label>
				<input name="hipertension" id="hipertension" type="checkbox" value="SI" class="checkbox"/>
				<input type="hidden" value="NO" id="hipertension" name="hipertension">
			</div>
			<div class="form-inline col-md-3">
				<label for="tuberculosis">Tuberculosis: </label>
				<input name="tuberculosis" id="tuberculosis" type="checkbox" value="SI" class="checkbox" />
				<input type="hidden" id="tuberculosis" name="tuberculosis" value="NO">
			</div>
			<div class="form-inline col-md-3">
				<label for="gemelarFamiliar">Gemelar: </label>
				<input name="gemelarFamiliar" id="gemelarFamiliar" type="checkbox" value="SI" class="checkbox"/>
				<input type="hidden" value="NO" id="_gemelarFamiliar" name="gemelarFamiliar">
			</div>
		</div>
		<hr>
	<div class="row">
			<div class="form-group col-md-12">
				<label for="titulo">Otros: </label>
				<input name="otrosFamiliar" type="text" value="" class="form-control"/>
			</div>
	</div>		
	 <br>
	<legend class="col-md-12 alert alert-info">Antecedentes Fisiologicos</legend>
		<div class="row">
		<!-- Fisiologicos-->
			<div class="form-group col-md-12">
<!-- 			<label for="titulo">Id_fisiologicos: </label> -->
<%-- 			<input name="id_familiares" type="text" value="${familiares.getId_familiares()}" class="form-control"/>  --%>
			</div>
		</div>
		<div class="row">
			<div class="form-inline col-md-3">
				<label for="dipsia">Dipsia: </label>
				<input id="dipsia" name="dipsia" type="checkbox" value="SI" class="checkbox"/>
				<input type="hidden" value="NO" id="dipsia" name="dipsia">
			</div>
			<div class="form-inline col-md-3">
				<label for="diuresis">Diuresis: </label>
				<input id="diuresis" name="diuresis" type="checkbox" value="SI" class="checkbox" />
				<input type="hidden" value="NO" id="diuresis" name="diuresis">
			</div>
			<div class="form-inline col-md-3">
				<label for="catarsis">Catarsis: </label>
				<input id="catarsis" name="catarsis" type="checkbox" value="SI" class="checkbox"/>
				<input type="hidden" value="NO" name="catarsis">
			</div>
			<div class="form-inline col-md-3">
				<label for="somnia">somnia: </label>
				<input id="somnia" name="somnia" type="checkbox" value="SI" class="checkbox"/>
				<input type="hidden" value="NO" name="somnia">
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<label for="titulo">Alimentacion: </label>
				<input name="alimentacion" type="text" value="" class="form-control"/>
			</div>
		</div>
			<div class="row">
			<div class="form-group col-md-12">
				<label for="titulo">Otros: </label>
				<input name="otrosFisiologicos" type="text" value="" class="form-control"/>
			</div>
	</div>	
	<hr>	
	<legend class="col-md-12 alert alert-info">Antecedentes Patológicos</legend>
		<div class="row">
		<!-- Patológicos-->
			<div class="form-group col-md-12">
<!-- 			<label for="titulo">Id_patologicos: </label> -->
<%-- 			<input name="id_patologicos" type="text" value="${familiares.getId_familiares()}" class="form-control"/>  --%>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-6">
				<label for="titulo">Infancia: </label>
				<input name="infancia" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-6">
				<label for="titulo">Adulto: </label>
				<input name="adulto" type="text" value="" class="form-control"/>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="form-inline col-md-3">
				<label for="DBT">Diabetes: </label>
				<input id="DBT" name="DBT" type="checkbox" value="SI" class="checkbox" />
				<input type="hidden" value="NO" name="DBT">
			</div>
			<div class="form-inline col-md-3">
				<label for="HTA">Hipertensión Arterial: </label>
				<input id="HTA" name="HTA" type="checkbox" value="SI" class="checkbox"/>
				<input type="hidden" value="NO" name="HTA">
			</div>
			<div class="form-inline col-md-3">
				<label for="TBC">Tuberculosis: </label>
				<input id="TBC" name="TBC" id="TBC" type="checkbox" value="SI" class="checkbox"/>
				<input type="hidden"value="NO" name="TBC">
			</div>
			<div class="form-inline col-md-3">
				<label for="gemelarPatologico">Gemelar: </label>
				<input id="gemelarPatologico" name="gemelarPatologico" type="checkbox" value="SI" class="checkbox"/>
				<input type="hidden" value="NO" name="gemelarPatologico">
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="form-group col-md-6">
				<label for="titulo">Quirurgicos: </label>
				<input name="quirurgicos" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-6">
				<label for="titulo">Traumatologicos: </label>
				<input name="traumatologicos" type="text" value="" class="form-control"/>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-6">
				<label for="titulo">Alergicos: </label>
				<input name="alergicos" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-6">
				<label for="titulo">Otros: </label>
				<input name="otrosPatologicos" type="text" value="" class="form-control"/>
			</div>
	</div>
	
	<legend class="col-md-12 alert alert-info">Antecedentes Ginecologicos</legend>
		<div class="row">
		<!-- Ginecologicos-->
			<div class="form-group col-md-12">
<!-- 			<label for="titulo">id_Ginecologicos: </label> -->
<%-- 			<input name="id_ginecologicos" type="text" value="${familiares.getId_familiares()}" class="form-control"/>  --%>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-2">
				<label for="FUM">Última Menstruación: </label>
				<input id="FUM" name="FUM" type="date" class="form-control" pattern="(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\d\d"/>
			</div>
			<div class="form-group col-md-4">
					<label for="fechaFUM">Activar/Desactivar: </label>
					<input id="fechaFUM" type="checkbox" class="checkbox" checked="checked" onClick="if(this.checked) desactivarFUM();else activarFUM()"/>
				</div>
			<div class="form-group col-md-2">
				<label for="FPP">Primer Parto: </label>
				<input id="FPP" name="FPP" type="date" class="form-control" pattern="(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\d\d"/>
			</div>
				<div class="form-group col-md-4">
					<label for="fechaFPP">Activar/Desactivar: </label>
					<input id="fechaFPP" type="checkbox" class="checkbox" checked="checked" onClick="if(this.checked) desactivarFPP();else activarFPP()"/>
				</div>
		</div>
			<hr>
		<div class="row">
			
			<div class="form-group col-md-2">
				<label for="titulo">Edad Gestacional: </label>
				<input name="edadGestacional" type="number" value="0" class="form-control" />
			</div>
			<div class="form-group col-md-2">
				<label for="titulo">Menarca: </label>
				<input name="menarca" type="number" value="0" class="form-control"/>
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">RM(Rit. Menstrual): </label>
				<input name="RM" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">IRS(Inicio Relaciones Sexuales): </label>
				<input name="IRS" type="number" value="0" class="form-control"/>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-2">
				<label for="titulo">Nro Parejas: </label>
				<input name="nroParejas" type="number" value="0" class="form-control"/>
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Flujo Genital: </label>
				<input name="flujoGenital" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-2">
				<label for="titulo">Gestas: </label>
				<input name="gestas" type="number" value="0" class="form-control"/>
			</div>
			<div class="form-group col-md-2">
				<label for="titulo">Partos: </label>
				<input name="partos" type="number" value="0" class="form-control"/>
			</div>
			<div class="form-group col-md-2">
				<label for="titulo">Cesáreas: </label>
				<input name="cesareas" type="number" value="0" class="form-control"/>
			</div>
			
		</div>
		<div class="row">
			<div class="form-group col-md-2">
				<label for="titulo">Abortos: </label> <input name="abortos"
					type="number" value="0" class="form-control" />
			</div>
			<div class="form-group col-md-10">
				<label for="titulo">Descripción: </label> 
				<input	name="descripcionGinecologicos" type="text" value="" class="form-control" />
			</div>
		</div>

		<div class="form-group col-md-12 text-center">
			<input id = "enviarForm" class="btn btn-success " value="Guardar" type="submit"/>
			</div>
		
			</form>
	

</body>
<c:import url="/WEB-INF/views/jsp/menu/includeScripts.jsp" />
<%-- <c:import url="/WEB-INF/views/jsp/menu/footer.jsp"/> --%>

</html>