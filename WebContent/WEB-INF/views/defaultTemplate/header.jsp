<div class="navbar-wrapper">
      <div class="container-fluid">
        <nav class="navbar navbar-default navbar-static-top">
          <div class="container-fluid">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">Sistema Hospital</a>
            </div>
            <sec:authorize>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
              <li class="dropdown">
                  <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Historia Clinica<span class="caret"></span></a>
                  <ul class="dropdown-menu">
                  <li><a href='<c:url value="/historia/historiaClinica"/>'>Crear Historia Clínica</a></li>
					 <li><a href='<c:url value="/historia/historiaList"/>' >Listar Historias Clínicas</a></li>
				 	<li><a href='<c:url value="/consultas/listarConsultas"/>' >Consultas Médicas</a></li>
				 	
                  </ul>
                </li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Usuarios<span class="caret"></span></a>
                  <ul class="dropdown-menu">
                  <li><a href='<c:url value="/usuarios/administradorList"/>'>Administrador</a></li>
					 <li><a href='<c:url value="/usuarios/profesionalList"/>' >Profesional</a></li>
				 	 <li><a href='<c:url value="/usuarios/pacienteList"/>' >Paciente</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href='<c:url value="/usuarios/usuariosList"/>' >Todos los Usuarios</a></li>
                    
                  </ul>
                </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                	 <li><a href='<c:url value="/logout"/>'>Logout</a></li>
                </ul>
            	 
             </div>
           </sec:authorize>
            	
          </div>
        </nav>

      </div>
    </div>