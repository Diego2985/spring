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
<%@ include file = "partial/header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Veterinaria</title>
    </head>
    <body>
        <div class="container row d-flex justify-content-center">
            <div class="col-5">
                <form:form action="reservar-turno" method="POST" modelAttribute="turno">
                    <h3 class="form-signin-heading text-center">Complete el formulario</h3>
                    <hr class="colorgraph"><br>

                    <label>Seleccione fecha y hora:</label><br>
                    <form:input type="datetime-local" path="fecha" id="fecha" /><br><br>

                    <label>Seleccione servicios:</label><br>
                    <form:checkboxes items="${turno.servicios}" path="servicios"
                                     itemLabel="nombre" itemValue="nombre" delimiter="<br/>" />

<%--                    <c:forEach var="list" items="${turno.servicios}" >--%>
<%--                        <input type="checkbox" value="${list.nombre}"--%>
<%--                                     id="${list.id}" name="${list.nombre}"/><br>--%>
<%--                    </c:forEach>--%>

                    <h4 class="text-center"><span>$500</span></h4><br>

                    <button class="btn btn-lg btn-primary btn-block" type="submit"/>Reservar</button>
                </form:form>

                <c:if test="${not empty error}">
                    <h6><span>${error}</span></h6>
                    <br>
                </c:if>
            </div>
        </div>

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <%@ include file = "partial/footer.jsp" %>
    </body>
</html>
