<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/jsp/menu/tags.jsp" />
<html>
<c:import url="/WEB-INF/views/jsp/menu/header.jsp" />
<c:url value="/resources/css/login.css" var="loginCss" />
<link rel="stylesheet" href="${loginCss}">
<script type="text/javascript">
	$(function() {

		$('#login-form-link').click(function(e) {
			$("#login-form").delay(100).fadeIn(100);
			$("#register-form").fadeOut(100);
			$('#register-form-link').removeClass('active');
			$(this).addClass('active');
			e.preventDefault();
		});
		$('#register-form-link').click(function(e) {
			$("#register-form").delay(100).fadeIn(100);
			$("#login-form").fadeOut(100);
			$('#login-form-link').removeClass('active');
			$(this).addClass('active');
			e.preventDefault();
		});

	});
</script>
<body>
	<c:import url="/WEB-INF/views/jsp/menu/topMenu.jsp" />
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">Login</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form name='f' class="form-group text-center" action="j_spring_security_check" method='POST' style="display: block;">
									<div class="form-group">
										<input type='text' name='j_username' value='' class="form-control" placeholder="Email">
									</div>
									<div class="form-group">
										<input type='password' name='j_password' class="form-control" placeholder="Contraseña" />
									</div>
									<div class="form-group text-center"> 
									<input type="checkbox" tabindex="3" class="" name="remember" id="remember"> 
									<label for="remember">	Remember Me</label>
									</div>


									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input name="submit" class="btn btn-success" type="submit"
													value="Acceder" />
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>





</body>
<c:import url="/WEB-INF/views/jsp/menu/includeScripts.jsp" />

</html>