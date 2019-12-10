<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<a href="dashboard.jsp"><i class="fas fa-home"></i>Home</a>
	<div id="header">
	<c:if test="${not empty user }">
		<span class="navbar-text"> ${user } <a href="login"
			class="btn my-2 my-sm-0"><i class="fas fa-door-closed"></i>Sair</a>
		</span>
	</c:if>
</div>
</header>