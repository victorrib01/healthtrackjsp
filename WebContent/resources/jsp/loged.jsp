<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<header>
  	<a href="dashboard.jsp"><i class="fas fa-home"></i>Home</a>
<!--   <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> -->
<!--     <span class="navbar-toggler-icon"></span> -->
<!--   </button> -->

  <div >
    <c:if test="${empty user }">
	    <span class="navbar-text text-danger" style="margin-right:10px" >
	        ${erro }
	  	</span>	
	    <form class="form-inline my-2 my-lg-0" action="login" method="post">
	    	  <input class="form-control mr-sm-2" type="text" name="email" placeholder="E-mail">
	      <input class="form-control mr-sm-2" type="password" name="senha" placeholder="Senha">
	      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Entrar</button>
	    </form>
    </c:if>
    <c:if test="${not empty user }">
    		<span class="navbar-text">
	    		${user }
	    		<a href="login" class="btn my-2 my-sm-0"><i class="fas fa-door-closed"></i>Sair</a>
	  	</span>	
    </c:if>
  </div>
</header>