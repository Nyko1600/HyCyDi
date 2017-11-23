function validarFormulario(){
	jQuery.validator.messages.required = 'Este campo es obligatorio.';
	
	$("#searchByName").validate();
 
	$("#botonByName").click(function(){
	   var validado = $("#searchByName").valid();
	   if(validado){
	     alert('El formulario es correcto.');
	   }
	    });
 
 }
 $(document).ready(function(){
    validarFormulario();
 });