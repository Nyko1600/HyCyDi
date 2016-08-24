<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:import url="/WEB-INF/views/jsp/menu/tags.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<c:import url="/WEB-INF/views/jsp/menu/header.jsp" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">

jQuery(document).ready(
	function($) {
			
	$("#btn-enviar").click(function(event) {

		var data={};
		data["id_ficha"] = $("#id_ficha").val();
		data["id_habitos"] = $("#id_habitos").val();
		data["alcohol"] = $("#alcohol").val();
		data["tabaco"] = $("#tabaco").val();
		data["drogas"] = $("#drogas").val();
		data["infusiones"] = $("#infusiones").val();
		data["otros"] = $("#otros").val();
		data["descripcion"] = $("#descripcion").val();


		
		var jsonData = JSON.stringify( JSONObject );
					alert(jsonData);
					
				$.ajax({
			             type: "POST",
			             contentType: "application/json",
			             url: "/antecedentes/save",
			             data: JSON.stringify(data),
			             dataType: 'json',
			             
			             success: function (data) {
			            	 alert("JSON: " + data);
			                
			             },
			             error: function (e) {
			                 $("#btn-save").prop("disabled", false);
			               
			             }
				});
		});  
});



</script>

<body>
	<c:import url="/WEB-INF/views/jsp/menu/topMenu.jsp" />

	<h1 class="text-center">Antecedentes Medicos</h1>
	<br>
<!-- 	commandName="antecedentesForm" -->
<%-- 	<form:form id="habitos" class="container" method="post" commandName="antecedentesForm" onsubmit="return comprobar()"> --%>
			
			<div class="form-group col-md-12">
 			<input name="id_ficha" type="text" value="${id_ficha}" class="form-control col-md-3" /> 
			<input name="id_habitos" type="text" value="${id_habitos}" class="form-control col-md-3"/>
			<input name="id_antecedentes" type="text" value="${id_antecedente}" class="form-control"/>
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Alcohol: </label>
				<input name="alcohol" id="alcohol" type="text" value="${alcohol}" class="form-control"/>
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Tabaco: </label>
				<input name="tabaco" type="text" value="${tabaco}" class="form-control col-md-3"/>
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Drogas: </label>
				<input name="drogas" type="text" value="${drogas}" class="form-control col-md-3"/>
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Infusiones: </label>
				<input name="infusiones" type="text" value="${infusiones}" class="form-control col-md-3"/>
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Otros: </label>
				<input name="otros" type="text" value="${otros}" class="form-control col-md-3"/>
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Descripción: </label>
				<input name="descripcion" id="descripcion" type="text" value="" class="form-control col-md-3"/>
			</div>
			<br>
			<div class="row text-center col-md-12">
 				<input id="btn-enviar" name="btn-enviar" class="btn btn-success form-group" type="button" value="ENVIAR"/> 
			</div>
			 
<%-- 		</form:form> --%>
	
	
	<div id="personFormResponse" class="success"> </div>
</body>



<c:import url="/WEB-INF/views/jsp/menu/includeScripts.jsp" />
<%-- <c:import url="/WEB-INF/views/jsp/menu/footer.jsp"/> --%>

</html>