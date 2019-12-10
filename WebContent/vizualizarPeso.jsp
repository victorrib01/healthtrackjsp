<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Pesos - HealthTrack</title>
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
						<h2>Lista de Pesos</h2>
					</div>
					<div class="container">
						<h1>Pesos</h1>
						<c:if test="${not empty msg }">
							<div class="alert alert-success">${msg}</div>
						</c:if>
						<c:if test="${not empty erro }">
							<div class="alert alert-danger">${erro}</div>
						</c:if>
						<table class="table table-striped">
							<tr>
								<th>Peso</th>
								<th>Data de Criação</th>
								<th>Data de Alteração</th>
								<th></th>
							</tr>
							<c:forEach items="${peso }" var="p">
								<tr>
									<td>${p.peso}</td>
									<td>${p.quantidade}</td>
									<td>${p.valor}</td>
									<td><fmt:formatDate value="${p.dataFabricacao.time }"
											pattern="dd/MM/yyyy" /></td>
									<td>${p.categoria.nome}</td>
									<td><c:url value="produto" var="link">
											<c:param name="acao" value="abrir-form-edicao" />
											<c:param name="codigo" value="${p.codigo }" />
										</c:url> <a href="${link}" class="btn btn-primary btn-xs">Editar</a>
										<button type="button" class="btn btn-danger btn-xs"
											data-toggle="modal" data-target="#excluirModal"
											onclick="codigoExcluir.value = ${p.codigo}">Excluir
										</button></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				<div class="content" id="ajax-content"></div>
			</div>
		</main>
	</div>
	<%@ include file="resources/jsp/footer.jsp"%>
</body>
</html>