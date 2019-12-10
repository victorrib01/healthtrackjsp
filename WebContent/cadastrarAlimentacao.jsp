<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Cadastrar Alimenta��o - HealthTrack</title>
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
						<h2>Cadastrar Alimenta��o</h2>
					</div>
					<form id="cadastrarAlimentacao">
						<div class="form-group">
							<label for="dataAlimentacao">Nova data:</label> <input
								type="text" class="form-control" id="data" name="dataAlimento">
						</div>
						<div class="form-group">
							<label for="tipoAlimentacao">Tipo de Alimenta��o:</label> <select
								class="form-control" id="tipoAlimentacao" name="tipoAlimentacao">
								<option>Caf� da manh�</option>
								<option>Almo�o</option>
								<option>Jantar</option>
								<option>Lanche da manh�</option>
								<option>Lanche da tarde</option>
								<option>Lanche da noite</option>
							</select>
						</div>
						<div class="form-group">
							<label for="nomeAlimento">Nome do Alimento:</label> <input
								type="text" class="form-control" id="nomealimento"
								name="nomeAlimento">
						</div>
						<div class="form-group">
							<label for="quantidadeAlimento">Quantidade:</label> <input
								type="text" class="form-control" id="quantidade"
								name="quantidadeAlimento">
						</div>
						<div class="form-group">
							<label for="calorias">Calorias:</label> <input type="text"
								class="form-control" id="calorias" name="calorias">
						</div>
						<button type="submit" class="btn btn-primary">Cadastrar</button>
						<button type="reset" class="btn btn-danger btn_back"
							onclick=window.location.href='alimentacao.jsp'>Voltar</button>
					</form>
				</div>
			</div>
		</main>
	</div>
	<%@ include file="resources/jsp/footer.jsp"%>
</body>
</html>