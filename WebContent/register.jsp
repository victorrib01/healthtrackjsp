<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro - HealthTrack</title>
<%@ include file="resources/jsp/head.jsp"%>
</head>
<body>
	<div class="register-parent">
		<div class="register">
			<div class="register-title">
				<img src="resources/img/logo.png" alt="logo">
				<h2>HealthTrack</h2>
			</div>
			<form method="post" action="register">
				<div class="form-group">
					<label for="name">Nome</label> 
					<input type="text" class="form-control" id="nome" placeholder="Nome Completo" name="nome">
				</div>
				<div class="form-group">
					<label for="dataNasc">Data de Nascimento: </label> 
					<input type="date" class="form-control" id="dataNasc" name="dataNasc">
				</div>
				<div class="form-group">
					<label for="genre">Gênero</label> 
					<select class="form-control" id="sexo" name="sexo">
						<option value="F">Feminino</option>
						<option value="M">Masculino</option>
						<option value="N">Não Informar</option>
					</select>
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Email</label> 
					<input type="email"	class="form-control" id="email" placeholder="Email" name="email">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Senha</label> 
					<input type="password" class="form-control" id="senha" placeholder="Senha" name = "senha">
				</div>
				<button type="submit" class="btn btn-primary btn_submit">Registrar-se</button>
				<button type="reset" class="btn btn-danger btn_back"
					onclick="window.location.href='index.jsp'">Voltar</button>
			</form>
		</div>
	</div>
	<%@ include file="resources/jsp/footer.jsp"%>
</body>
</html>