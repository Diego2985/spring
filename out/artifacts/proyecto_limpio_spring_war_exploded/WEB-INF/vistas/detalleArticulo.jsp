<%@ include file = "partial/header.jsp" %>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
<div class="row container-fluid mt-3 mb-3">
    <div class="col-6 text-center">
        <img src="images/disfraz-1.jpg">
    </div>
    <div class="col-4">
        <h1>Disfraz de superman</h1>
        <h3 class="mt-3">$1500</h3>
        <button class="btn mt-5" style="background-color: #a4ebf3">Comprar</button>
    </div>
</div>
<div>
    <hr>
    <h2 class="text-center">Articulos recomendados</h2>
    <%@ include file = "articulos.jsp" %>
</div>
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<%@ include file = "partial/footer.jsp" %>
</body>
</html>