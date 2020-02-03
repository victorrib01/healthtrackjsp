<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Dashboard - HealthTrack</title>
<%@ include file="resources/jsp/head.jsp"%>
</head>
<body>
	<div class="flex-dashboard">
		<%@ include file="resources/jsp/sidebar.jsp"%>
		<main id="main">
			<%@ include file="resources/jsp/header.jsp" %>
			<div class="main-content">
				<div class="perfil-box">
					<div class="perfil">
						<div class="perfil-img">
							<img src="./resources/img/profileIcon.png" alt="profileIcon">
						</div>
						<div></div>
						<!-- <div class="perfil-form">
							<form>
								<div class="custom-file">
									<input type="file" class="custom-file-input" id="customFile">
									<label class="custom-file-label" for="customFile">Choose
										file</label>
								</div>
								<div class="form-group">
									<label for="name">Nome completo: </label> <input type="text"
										class="form-control" id="name" placeholder="Nome completo">
								</div>
								<div class="form-group">
									<label for="email">E-mail: </label> <input type="email"
										class="form-control" id="email" placeholder="E-mail">
								</div>
								<div class="form-group">
									<label for="dataNasc">Data de Nascimento: </label> <input
										type="date" class="form-control" id="dateNasc">
								</div>
								<div class="form-group">
									<label for="sexo">Sexo:</label> <select class="form-control"
										id="sexo">
										<option>Feminino</option>
										<option>Masculino</option>
									</select>
								</div>
								<div class="form-group">
									<label for="senha">Senha: </label> <input type="password"
										class="form-control" id="senha">
								</div>
								<button type="submit" class="btn btn-primary">Salvar</button>
							</form>
						</div>
 -->					</div>
				</div>
			</div>
		</main>
	</div>
	<%@ include file="resources/jsp/footer.jsp"%>
</body>
</html>