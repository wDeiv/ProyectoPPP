

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="ASSETS/CSS/bootstrap.min.css"/>
    </head>
    <body class="d-flex justify-content-center align-items-center vh-100"">
        <div class="container d-flex flex-column align-items-center border border-2 p-4 rounded shadow" style="background-color: #f8f9fa; max-width: 400px;">
                <img src="ASSETS/IMAGES/ICON.png" class="w-50 mb-4" />
                <form action="Login" method="post" class="w-100">
            <div class="form-group mb-3">
                <label class="mb-1 fw-bold" for="usuario">USUARIO:</label>
                <input type="text" class="form-control" id="usuario" name="usuario" placeholder="Ingresar usuario">
            </div>
                <div class="form-group mb-3">
                <label class="mb-1 fw-bold" for="clave">CONTRASEÑA:</label>
                <input type="password" class="form-control" id="clave" name="clave" placeholder="Ingresar contraseña">
            </div>
                    <button type="submit" class="btn btn-primary w-100">INICIAR SESION</button>
                </form>
            <div id="error-message" class="mt-3 text-danger" data-error="<%= request.getAttribute("error")%>"></div>
        </div>
            <script src="ASSETS/JS/Login.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
