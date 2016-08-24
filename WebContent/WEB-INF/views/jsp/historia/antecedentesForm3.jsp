<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:import url="/WEB-INF/views/jsp/menu/tags.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<c:import url="/WEB-INF/views/jsp/menu/header.jsp" />
<script type="text/javascript">

/* 
 $('#habitos').submit(function(e) {
	    // will pass the form data using the jQuery serialize function
	    $.post('${pageContext.request.contextPath}/antecedentes/save', $(this).serialize(), 
 		  function(response) {
     $('#personFormResponse').text(response);
	    });
    
   e.preventDefault(); // prevent actual form submit and page reload
	  });
 
	  // Save Person AJAX Form Submit
	  $('#familiares').submit(function(e) {
   // will pass the form data using the jQuery serialize function
   $.post('${pageContext.request.contextPath}/antecedentes/save', $(this).serialize(), 
 		  function(response) {
     $('#personFormResponses').text(response);
   });
    
   e.preventDefault(); // prevent actual form submit and page reload
	 });
 */
		function comprobar()
		{
			
			var id_ficha=document.forms["habitos"].elements[0].value;
			var id_habitos=document.forms["habitos"].elements[1].value;
			var alcohol = document.forms["habitos"].elements[2].value;
			var tabaco = document.forms["habitos"].elements[3].value;
			var drogas = document.forms["habitos"].elements[4].value;
			var infusiones = document.forms["habitos"].elements[5].value;
			var otros = document.forms["habitos"].elements[6].value;
			var descripcion = document.forms["habitos"].elements[7].value;
			
			alert("Todo: "+id_ficha + "\n" + id_habitos + "\n" + alcohol + "\n" + 
					tabaco + "\n" + drogas + "\n" + infusiones + "\n" +otros + "\n" + descripcion);
			
			var habitos ={
					id_ficha: id_ficha,
					id_habitos: id_habitos,
					alcohol:alcohol,
					tabaco: tabaco,
					drogas: drogas,
					infusiones: infusiones,
					otros: otros,
					descripcion: descripcion					
			}
			
			
						
			$.ajax({
	            type: "POST",
	            url: "HabitoSubmit",
	            data: JSON.stringify(habitos),
	            contentType: 'application/json; charset=utf-8',
	            dataType : 'json',
	            success: function(data) {
	              if(data.status == 'OK') alert('Person has been added');
	              else alert('Failed adding person: ' + data.status + ', ' + data.errorMessage);
	            }
	           
	        });
		}


</script>

<body>
	<c:import url="/WEB-INF/views/jsp/menu/topMenu.jsp" />

	<h1 class="text-center">Antecedentes Medicos</h1>
	<br>
	<div id="popUpHabitos">
		<form:form id="habitos" class="container" method="POST" commandName="antecedentesForm" onsubmit="return comprobar()">
			<input name="id_ficha" type="text" value="${id_ficha}" />
			<form:input path="id_habitos" type="text" />
			<form:input path="alcohol" id="alcohol" type="text" value="${alcohol}" />
			<form:input path="tabaco" type="text" value="${tabaco}" />
			<form:input path="drogas" type="text" value="${drogas}" />
			<form:input path="infusiones" type="text" value="${infusiones}" />
			<form:input path="otros" type="text" value="${otros}" />
			<form:input path="descripcion" id="descripcion" type="text" value="" />
			<br>
			<div class="row text-center">
				<input id="SubmitAnt" class="btn btn-success form-group"
					type="submit" value="Guardar" />
			</div>
		</form:form>
		
	</div>
	
	<div id="popUpFamiliares">
		<form:form id="familiares" class="container" method="POST" commandName="familiaresForm">
			<div class="form-group col-md-12">
			<input name="id_ficha" type="text" value="${id_ficha}" />
			<form:input path="id_familiares" type="text" value=""/>
			<form:input path="id_antecedentes" type="text" value=""/>
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Diabetes: </label>
				<form:input path="diabetes" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Hiper Tensión Arterial: </label>
				<form:input path="hipertension" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Tuberculosis: </label>
				<form:input path="tuberculosis" type="text" value="" class="form-control" />
			</div>
			<div class="form-group col-md-4">
				<label for="titulo">Gemelar: </label>
				<form:input path="gemelar" type="text" value="" class="form-control"/>
			</div>
			<div class="form-group col-md-8">
				<label for="titulo">Otros: </label>
				<form:input path="otros" type="text" value="" class="form-control"/>
			</div>
			
			<br>
			<div class="row text-center col-md-12">
 				<input class="btn btn-success form-group" type="submit" value="Guardar" onclick="EnviarFormularios()"/> 
			</div>
			 <div id="personFormResponse" class="success"> </div>
			</form:form>
	</div>

</body>
<c:import url="/WEB-INF/views/jsp/menu/includeScripts.jsp" />
<%-- <c:import url="/WEB-INF/views/jsp/menu/footer.jsp"/> --%>

</html>