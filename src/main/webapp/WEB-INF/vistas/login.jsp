<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="partial/headers.jsp"%>
<html>
<head>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<!--
   if(request.getParameter("btn_ingresar")!= null){
       String email = request.getParameter("email");
       String password = request.getParameter("password");
   } %>-->
<div class = "container">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
        <%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
        <%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto --%>
        <form:form action="login.jsp" method="POST" modelAttribute="usuario">
        <h3 class="form-signin-heading">Iniciar Sesion</h3>
            <hr class="colorgraph"><br>

            <%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
            <form:input path="email" id="email" type="email" class="form-control" name="email" required="required"/>
            <form:input path="password" type="password" id="password" class="form-control" name="password" required="required"/>
            <button class="btn btn-lg btn-primary btn-block" Type="Submit" name="btn_ingresar"/>Ingresar</button>
        </form:form>
        <a class="btnEmpezar" href="${ pageContext.request.contextPath}/registro">Registrarse</a>
        <%--Bloque que es placeholder="email" visible si el elemento error no está vacío	--%>
        <c:if test="${not empty error}">
            <h4><span>${error}</span></h4>
            <br>
        </c:if>
    </div>
</div>

<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<%@include file="partial/footer.jsp"%>
</body>
</html>
