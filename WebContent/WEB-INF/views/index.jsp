<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/jsp/menu/tags.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="/WEB-INF/views/jsp/template/head.jsp" />
<title>Hospital Malargue</title>
<body>
<c:import url="/WEB-INF/views/jsp/template/header.jsp" />



 <!--========================================================
                            CONTENT
  =========================================================-->

<main>
	<div class="main container"> <!-- Contendedor de los Post-->
		<div class="row ">
			<a href=""><h3 class="title">Noticias Hospital Malarg�e</h3></a>

		</div>
		<div class="row col-md-12">
			
				<div class="post clearfix col-md-4"><!--clearfix para no tener problemas con css, post desarmado-->
					<a href="#" class="thumb">
						<img class="img-thumbnail" src="${pageContext.request.contextPath}/resources/images/hospital-Malargue-1.jpg" alt="">
						<h5 class="post-title">
							<a href="#">Estoy con vida gracias al buen desempe�o de los profesionales del hospital</a>
						</h5>
					</a>
					
				</div>

				<div class="post clearfix col-md-4"><!--clearfix para no tener problemas con css, post desarmado-->
					<a href="#" class="thumb">
						<img class="img-thumbnail" src="${pageContext.request.contextPath}/resources/images/Payamedicos.jpg" alt="">
						<h5 class="post-title">
							<a href="#">Payam�dicos Mendoza realiz� una charla en el Hospital Malarg�e</a>
						</h5>
					
					</a>
				</div>
				<div class="post clearfix col-md-4"><!--clearfix para no tener problemas con css, post desarmado-->
					<a href="#" class="thumb">
						<img class="img-thumbnail" src="${pageContext.request.contextPath}/resources/images/Donacion-de-computadoras-de.jpg" alt="">
						<h5 class="post-title">
							<a href="#">Mediante una donaci�n, buscan agilizar servicios en el hospital</a>
						</h5>
					
					</a>
				</div>
				
		

		</div>
<div class="row col-md-12">
			
				<div class="post clearfix col-md-4"><!--clearfix para no tener problemas con css, post desarmado-->
					<a href="#" class="thumb">
						<img class="img-thumbnail" src="${pageContext.request.contextPath}/resources/images/Quirofano.jpg" alt="">
						<h5 class="post-title">
							<a href="#">Hospital Regional Malarg�e cuenta con m�s servicios</a>
						</h5>
					</a>
					
				</div>

				<div class="post clearfix col-md-4"><!--clearfix para no tener problemas con css, post desarmado-->
					<a href="#" class="thumb">
						<img class="img-thumbnail" src="${pageContext.request.contextPath}/resources/images/Ministro-de-salud-junto-al-intendente.jpg" alt="">
						<h5 class="post-title">
							<a href="#">El Ministro de Salud habl� sobre concentrar la salud en el Hospital Malarg�e</a>
						</h5>
					
					</a>
				</div>
				<div class="post clearfix col-md-4"><!--clearfix para no tener problemas con css, post desarmado-->
					<a href="#" class="thumb">
						<img class="img-thumbnail" src="${pageContext.request.contextPath}/resources/images/hospital-Malargue-1.jpg" alt="">
						<h5 class="post-title">
							<a href="#">Una ni�a de 7 a�os sufri� graves quemaduras</a>
						</h5>
					
					</a>
				</div>
				
		

		</div>
		
	</div>

	</main>
	<c:import url="/WEB-INF/views/jsp/menu/includeScripts.jsp" />
	
</body>
</html>