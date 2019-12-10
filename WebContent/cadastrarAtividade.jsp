<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Cadastrar Atividade F�sica - HealthTrack</title>
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
						<h2>Cadastrar Atividade F�sica</h2>
					</div>
					<form id="cadastrarAtividade">
						<div class="form-group">
							<label for="atividade">Data:</label> <input type="text"
								class="form-control" id="data" name="dataAtividade">
						</div>
						<div class="form-group">
							<label for="tipoAtividade">Tipo de Atividade:</label> <select
								class="form-control" id="tipoAlimentacao" name="tipoAlimentacao">
								<option>Caminhada</option>
								<option>Corrida</option>
								<option>Ciclismo</option>
								<option>Marcha</option>
								<option>Esteira</option>
								<option>Bicicleta Ergométrica</option>
							</select>
						</div>
						<div class="form-group">
							<label for="atividade">Duração do exercício:</label> <input
								type="text" class="form-control" id="nomealimento"
								name="duracaoAtividade">
						</div>
						<div class="form-group">
							<label for="atividade">Distância:</label> <input type="text"
								class="form-control" id="quantidade" name="distancia">
						</div>
						<div class="form-group">
							<label for="atividade">Calorias perdidas:</label> <input
								type="text" class="form-control" id="calorias"
								name="caloriasperdidas">
						</div>
						<button type="submit" class="btn btn-primary">Cadastrar</button>
						<button type="reset" class="btn btn-danger btn_back"
							onclick=window.location.href='atividade.jsp'>Voltar</button>
					</form>
				</div>
			</div>
		</main>
	</div>
	<%@ include file="resources/jsp/footer.jsp"%>
</body>
</html>