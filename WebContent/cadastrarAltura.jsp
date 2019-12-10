<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Cadastrar Altura - HealthTrack</title>
<%@ include file="resources/jsp/head.jsp"%>
</head>
<body>
	<div class="flex-dashboard">
		<%@ include file="resources/jsp/sidebar.jsp"%>
		<main id="main">
			<%@ include file="resources/jsp/header.jsp"%>
			<div class="main-content">
				<div class="main-content">
					<div class="main-content-title">
						<h2>Cadastrar Altura</h2>
					</div>
					<c:if test="${not empty msg }">
						<div class="alert alert-success">${msg}</div>
					</c:if>
					<c:if test="${not empty erro }">
						<div class="alert alert-danger">${erro}</div>
					</c:if>
					<form id="cadastrarAltura" action="altura" method="post">
						<input type="hidden" value="cadastrar" name="acao">
						<div class="form-group">
							<label for="altura">Nova altura:</label> 
							<input type="text" class="form-control" id="id-altura" name="altura">
						</div>
						<input value="Cadastrar" type="submit" class="btn btn-primary">
						<button type="reset" class="btn btn-danger btn_back"
							onclick=window.location.href='altura.jsp'>Voltar</button>
					</form>
				</div>
			</div>
		</main>
	</div>
	<%@ include file="resources/jsp/footer.jsp"%>
</body>
</html>