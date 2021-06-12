<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: nicolasduarte
  Date: 07/06/2021
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "partial/header.jsp" %>
<!DOCTYPE html>
<html>
    <head>

    </head>
    <body>
        <div class="row d-flex">
            <form action="${pageContext.request.contextPath}/reservar-turno">
                <button type="submit" class="btn btn-lg btn-primary btn-block">
                    Reservar Turno
                </button>
            </form>
        </div>

        <div class="row container-fluid d-flex align-items-center mt-3">
            <div class="card-turno d-flex col-8" >
                <img
                        src="<c:url value="/images/pelu-1.jpeg"/>"
                        class="img-fluid"
                        alt="..."
                        height="200px"
                        width="200px"
                />
                <div class="card-body">
                    <h5 class="card-title">Baño</h5>
                    <h5 class="card-title">Fecha: 12 de Junio a las 16:00 hs</h5>
                    <h5 class="card-title">Estado: Pendiente</h5>
                    <button class="btn" style="background-color: #a4ebf3" href="#">Ver más</button>
                </div>
            </div>

            <div class="col-4 text-right">
                <h3 class="card-title">$500</h3>
            </div>
        </div><hr>

        <div class="row container-fluid d-flex align-items-center mt-3">
            <div class="card-turno d-flex col-8" >
                <img
                        src="<c:url value="/images/pelu-1.jpeg"/>"
                        class="img-fluid"
                        alt="..."
                        height="200px"
                        width="200px"
                />
                <div class="card-body">
                    <h5 class="card-title">Baño</h5>
                    <h5 class="card-title">Fecha: 12 de Junio a las 16:00 hs</h5>
                    <h5 class="card-title">Estado: Pendiente</h5>
                    <button class="btn" style="background-color: #a4ebf3" href="#">Ver más</button>
                </div>
            </div>

            <div class="col-4 text-right">
                <h3 class="card-title">$500</h3>
            </div>
        </div><hr>

        <div class="row container-fluid d-flex align-items-center mt-3">
            <div class="card-turno d-flex col-8" >
                <img
                        src="<c:url value="/images/pelu-1.jpeg"/>"
                        class="img-fluid"
                        alt="..."
                        height="200px"
                        width="200px"
                />
                <div class="card-body">
                    <h5 class="card-title">Baño</h5>
                    <h5 class="card-title">Fecha: 12 de Junio a las 16:00 hs</h5>
                    <h5 class="card-title">Estado: Pendiente</h5>
                    <button class="btn" style="background-color: #a4ebf3" href="#">Ver más</button>
                </div>
            </div>

            <div class="col-4 text-right">
                <h3 class="card-title">$500</h3>
            </div>
        </div>

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <%@ include file = "partial/footer.jsp" %>
    </body>
</html>
