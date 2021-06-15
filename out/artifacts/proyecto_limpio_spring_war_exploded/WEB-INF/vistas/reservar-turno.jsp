<%--
  Created by IntelliJ IDEA.
  User: nicolasduarte
  Date: 08/06/2021
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ include file = "partial/header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Veterinaria</title>
    </head>
    <body>
        <div class="container row d-flex justify-content-center">
            <div class="col-5">
                <form:form action="reservar-turno" method="POST" modelAttribute="datosTurno">
                    <br><br>

                    <h3 class="form-signin-heading text-center">Complete el formulario</h3>
                    <hr class="colorgraph"><br>

                    <label class="text-dark">Seleccione fecha:</label><br>
                    <form:input type="date" id="fecha" min="${datosTurno.fechaDesde}" max="${datosTurno.fechaHasta}" path="fecha"/>

                    <br><br>

<%--                    <div class="dropdown">--%>
<%--                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
<%--                            Seleccione hora--%>
<%--                        </button>--%>
<%--                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">--%>
<%--                            <a class="dropdown-item" href="#">Action</a>--%>
<%--                            <a class="dropdown-item" href="#">Another action</a>--%>
<%--                            <a class="dropdown-item" href="#">Something else here</a>--%>
<%--                        </div>--%>
<%--                    </div>--%>

                    <form:select path="horaSeleccionada">
                        <form:option value="" label="Seleccione hora"/>
                        <form:options items="${datosTurno.horas}" />
                    </form:select>

                    <br><br>

                    <label class="text-dark">Seleccione servicios:</label><br>
                    <form:checkboxes items="${datosTurno.servicios}" path="serviciosSeleccionados"
                                     itemLabel="nombre" itemValue="id" delimiter="<br/>" />

                    <h4 class="text-center"><span>$${datosTurno.precio}</span></h4><br>

                    <button class="btn btn-lg btn-primary btn-block" type="submit"/>Reservar</button>
                </form:form>

                <c:if test="${not empty error}">
                    <h6><span class="text-danger">${error}</span></h6>
                    <br>
                </c:if>
            </div>
        </div>

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
        <script src="${pageContext.request.contextPath}/https://unpkg.com/@popperjs/core@2"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>


        <%@ include file = "partial/footer.jsp" %>
    </body>
</html>
