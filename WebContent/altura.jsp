<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Gerenciamento de Altura - HealthTrack</title>
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
						<h2>Gerenciamento de Altura</h2>
					</div>
					<div class="panel-row">
                        <button class="panel panel-50" onclick="window.location.href='cadastrarAltura.jsp'"><i class="far fa-edit"></i>Cadastrar
                            Altura</button>
                        <button class="panel panel-50" id="vizualizarAltura" onclick="window.location.href='vizualizarAltura.jsp'"><i class="far fa-list-alt"></i>Vizualizar
                            Altura</button>
                    </div>
				</div>
			</div>
		</main>
	</div>
	<%@ include file="resources/jsp/footer.jsp"%>
</body>
</html>