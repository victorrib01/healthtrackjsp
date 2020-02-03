<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
							</tr>
							<c:forEach items="${pesos}" var="p">
								<tr>
									<td>${p.peso}</td>
									<td><fmt:formatDate value="${p.dataPeso.time }"
											pattern="dd/MM/yyyy" /></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</main>
	</div>
	<%@ include file="resources/jsp/footer.jsp"%>
</body>
</html>