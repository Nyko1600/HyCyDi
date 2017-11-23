<div class="nav-side-menu navbar-custom custom-menu">
    <div class="brand">Menu</div>
    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
        <div class="menu-list">
            <ul id="menu-content" class="menu-content collapse out">
                <li>
                  <a href="#">
                  <i class="fa fa-dashboard fa-lg"></i> Panel de Control
                  </a>
                </li>
		        <li  data-toggle="collapse" data-target="#users" class="collapsed">
                  <a href="#"><i class="fa fa-users fa-lg"></i> Users <span class="arrow"></span></a>
                </li>
                <ul class="sub-menu collapse" id="users">
                    
					<li><a href="#"><i class="fa fa-plus fa-lg"></i>Nuevo Usuario</a></li>
                    <li><a href="${pageContext.request.contextPath}/usuarios/administradorList"><i class="fa fa-user fa-lg"></i>Administrador</a></li>
                    <li><a href="${pageContext.request.contextPath}/usuarios/profesionalList"><i class="fa fa-user-md fa-lg"></i>Profesionales</a></li>
                    <li><a href="${pageContext.request.contextPath}/usuarios/pacienteList"><i class="fa fa-user fa-lg"></i>Pacientes</a></li>
                    <li><a href="${pageContext.request.contextPath}/usuarios/usuariosList"><i class="fa fa-users fa-lg"></i>Todos los Usuarios</a></li>
                </ul>
                <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_PROFESIONAL')">
	                <li  data-toggle="collapse" data-target="#products" class="collapsed">
	                  <a href="#"><i class="fa fa-h-square fa-lg"></i> Historia Clínica <span class="arrow"></span></a>
	                </li>
	                <ul class="sub-menu collapse" id="products">
	                    <li><a href="${pageContext.request.contextPath}/historia/historiaClinica"><i class="fa fa-plus fa-lg"></i>Crear Historia Clinica</a></li>
	                    <li><a href="${pageContext.request.contextPath}/historia/historiaList"><i class="fa fa-list fa-lg"></i>Listar Historia Clinica</a></li>
	                </ul>
	                <li data-toggle="collapse" data-target="#consultas" class="collapsed">
	                  <a href="#"><i class="fa fa-user-md fa-lg"></i> Consulas Médicas <span class="arrow"></span></a>
	                </li>  
	                <ul class="sub-menu collapse" id="consultas">
	                    <li><a href="${pageContext.request.contextPath}/consultas/listarConsultas"><i class="fa fa-medkit fa-lg"></i>Consulta Médica</a></li>
	                </ul>        
              	</sec:authorize>
            </ul>
     </div>
</div>