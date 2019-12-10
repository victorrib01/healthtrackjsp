<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Esqueceu a senha - HealthTrack</title>
<%@ include file="resources/jsp/head.jsp"%>
</head>
<body>
	<div class="forgotpass-parent">
		<div class="forgotpass">
			<div class="forgotpass-title">
				<img src="resources/img/logo.png" alt="logo">
				<h2>HealthTrack</h2>
			</div>
			<form>
				<div class="form-group">
					<label for="height">Email</label> <input type="text"
						class="form-control" id="height" placeholder="seuemail@email.com">
				</div>
				<button type="submit" class="btn btn-primary btn_submit">Recuperar
					senha</button>
				<button type="reset" class="btn btn-danger btn_back"
					onclick="goBack()">Voltar</button>
			</form>
		</div>
	</div>
	<%@ include file="resources/jsp/footer.jsp"%>
</body>
</html>