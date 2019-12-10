<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login - Health Track</title>
<%@ include file="resources/jsp/head.jsp"%>
</head>
<body>
	<main>
		<div class="container h-100">
			<div class="d-flex justify-content-center">
				<div class="user_card">
					<div class="logo_container">
						<img src="resources/img/logo.png" class="brand_logo" alt="Logo">
						<span>HealthTrack</span>
					</div>
					<div class="d-flex justify-content-center form_container">
						<form action="login" method="post">
							<div class="input-group mb-3">
								<input type="text" name="email" class="form-control input_user"
									placeholder="E-mail" required>
							</div>
							<div class="input-group mb-2">
								<input type="password" name="senha"
									class="form-control input_pass" placeholder="Senha" required>
							</div>
							<div class="d-flex justify-content-center mt-3 login_container">
								<button class="btn btn-lg btn-primary btn-block login_btn"
									type="submit">Login</button>
							</div>
						</form>
					</div>
					<div class="mt-4">
						<div class="d-flex justify-content-center links">
							Não possui conta? <a href="register.jsp" class="ml-2">Cadastrar-se</a>
						</div>
						<div class="d-flex justify-content-center links">
							<a href="orgot-password.jsp">Esqueceu sua senha?</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<%@ include file="resources/jsp/footer.jsp"%>
</body>
</html>