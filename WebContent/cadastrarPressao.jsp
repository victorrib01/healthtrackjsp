<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Cadastrar Pressão Arterial - HealthTrack</title>
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
						<h2>Cadastrar Pressão Arterial</h2>
					</div>
					<form id="cadastrarPressao">
						<div class="form-group">
							<label for="peso">Data:</label> <input type="text"
								class="form-control" id="dataPressao">
						</div>
						<div class="form-group">
							<label for="peso">Sistólica (mmHg):</label> <input type="text"
								class="form-control" id="pSistolica">
						</div>
						<div class="form-group">
							<label for="peso">Diastólica (mmHg):</label> <input type="text"
								class="form-control" id="pDiastolica">
						</div>
						<div class="form-group">
							<label for="tipoAlimentacao">Medicamentos</label> <select
								class="form-control" id="Medicamentos">
								<option>Sim</option>
								<option>Não</option>
							</select>
						</div>
						<div class="form-group">
							<label for="peso">Pulsação (bpm):</label> <input type="text"
								class="form-control" id="pulsacao">
						</div>
						<button type="submit" class="btn btn-primary">Cadastrar</button>
						<button type="reset" class="btn btn-danger btn_back"
							onclick=window.location.href='pressaoArterial.jsp'>Voltar</button>
					</form>
				</div>
			</div>
		</main>
	</div>
	<%@ include file="resources/jsp/footer.jsp"%>
</body>
</html>