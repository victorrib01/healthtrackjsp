<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Gerenciamento de Alimentação - HealthTrack</title>
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
						<h2>Gerenciamento de Alimentação</h2>
					</div>
					<div class="panel-row">
						<button class="panel panel-50" onclick="window.location.href='cadastrarAlimentacao.jsp'">
							<i class="far fa-edit"></i>Cadastrar Alimentação
						</button>
						<button class="panel panel-50" onclick="window.location.href='vizualizarAlimentacao.jsp'">
							<i class="far fa-list-alt"></i>Vizualizar Alimentação
						</button>
					</div>
				</div>
			</div>
		</main>
	</div>
	<%@ include file="resources/jsp/footer.jsp"%>
</body>
</html>