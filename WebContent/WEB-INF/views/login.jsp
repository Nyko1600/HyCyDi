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
							
								<form name='f' class="form-group text-center" action="<c:url value='j_spring_security_check'/>" method='POST' style="display: block;">
									<div class="form-group">
										<input type='text' name='username' class="form-control" placeholder="Email">
									</div>
									<div class="form-group">
										<input type='password' name='password' class="form-control" placeholder="Contraseña" />
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
