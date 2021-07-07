<%--
  Created by IntelliJ IDEA.
  User: lucas
  Date: 24/5/2021
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="row container-fluid d-flex align-items-center mt-3">
    <div class="col-6 col-sm-3 d-flex justify-content-center">
        <div class="card text-center d-flex justify-content-center" >
            <img
                    src="images/disfraz-1.jpg"
                    class="img-fluid"
                    alt="..."
                    max-height="200"
            />
            <div class="card-body">
                <h5 class="card-title">Superman</h5>
                <h4 class="text-center" id="precio"><span>$1500.00</span></h4><br>
                <div class="container text-center">
                <button class="btn" style="background-color: #a4ebf3">Agregar al carrito</button>
                <button href="${ pageContext.request.contextPath}/detalleArticulo" class="btn mt-5" style="background-color: #a4ebf3">Comprar</button>
             <!--<a href="${pageContext.request.contextPath}/reservar-turno" class="btn btn-lg btn-primary mt-4">Reservar Turno</a>-->
                </div>
            </div>
        </div>
    </div>
    <div class="col-6 col-sm-3 d-flex justify-content-center">
        <div class="card text-center d-flex justify-content-center" >
            <img
                    src="images/disfraz-2.jpg"
                    class="img-fluid"
                    alt="..."
                    max-height="200"
            />
            <div class="card-body">
                <h5 class="card-title">Pirata</h5>
                <h4 class="text-center" id="precio"><span>$1200.00</span></h4><br>
                <div class="container text-center">
                <button class="btn" style="background-color: #a4ebf3">Agregar al carrito</button>
                <button class="btn" style="background-color: #a4ebf3" href="${ pageContext.request.contextPath}/detalleArticulo">Comprar</button>
            </div>
            </div>
        </div>
    </div>
    <div class="col-6 col-sm-3 d-flex justify-content-center">
        <div class="card text-center d-flex justify-content-center">
            <img
                    src="images/ropa-1.jpg"
                    class="img-fluid"
                    alt="..."
                    max-height="200"
            />
            <div class="card-body">
                <h5 class="card-title">Enterizo</h5>
                <h4 class="text-center" id="precio"><span>$2400.00</span></h4><br>
                <div class="container text-center">
                    <button class="btn " style="background-color: #a4ebf3">Agregar al carrito</button>
                   <!-- <button class="btn " style="background-color: #a4ebf3" ${ pageContext.request.contextPath}/detalleArticulo">Comprar</button>-->
                    <a class="btn-mdb-color" href="${ pageContext.request.contextPath}/detalleArticulo" role="button">Comprar</a>
                </div>
            </div>
        </div>
    </div>
    <div class="col-6 col-sm-3 d-flex justify-content-center">
        <div class="card text-center d-flex justify-content-center">
            <img
                    src="images/ropa-2.jpg"
                    class="img-fluid"
                    alt="..."
                    max-height="200"
            />
            <div class="card-body">
                <h5 class="card-title">Chaleco militar</h5>
                <h4 class="text-center" id="precio"><span>$3000.00</span></h4><br>
                <div class="container text-center">
                    <button class="btn" style="background-color: #a4ebf3">Agregar al carrito</button>
                    <button class="btn" style="background-color: #a4ebf3" ${ pageContext.request.contextPath}/detalleArticulo">Comprar</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
