

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
    response.setHeader("Pragma", "no-cache");
    response.addHeader("Cache-Control", "must-revalidate");
    response.addHeader("Cache-Control", "no-cache");
    response.addHeader("Cache-Control", "no-store");
    response.setDateHeader("Expires", 0);
    String user = null;
    String rol = null;
    String carrera = null;
    HttpSession sesion = request.getSession();
    if (sesion.getAttribute("usuario") == null) {
%>
<jsp:forward page="index.jsp">
    <jsp:param name="error" value="Usted debe autenticarse..."/>
</jsp:forward>
<%
} else {
    user = (String) sesion.getAttribute("usuario");
    rol = (String) sesion.getAttribute("rol");
    carrera = (String) sesion.getAttribute("carrera");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="ASSETS/CSS/bootstrap.min.css"/>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light shadow-sm">
    <div class="container-fluid">
        <a class="navbar-brand fw-bold" href="#">SISTEMA ACADEMICO</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Dropdown
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <%=user%>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-end">
                        <li><a class="dropdown-item" href="#"><%=rol%></a></li>
                        <li><a class="dropdown-item" href="#"><%=carrera%></a></li>
                        <li><a class="dropdown-item" href="Logout">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container w-75 mt-5">
    <h1 class="text-center fw-bold mb-4">LISTA DE ESTUDIANTES</h1>
    <table class="table table-striped table-hover">
        <thead class="table-dark">
            <tr>
                <th class="fw-semibold" scope="col">#</th>
                <th class="fw-semibold" scope="col">ID</th>
                <th class="fw-semibold" scope="col">NOMBRES</th>
                <th class="fw-semibold" scope="col">APELLIDOS</th>
                <th class="fw-semibold" scope="col">CODIGO</th>
                <th class="fw-semibold" scope="col">CORREO</th>
                <th class="fw-semibold" scope="col">CARRERA</th>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <script src="ASSETS/JS/jquery-3.7.1.min.js"></script>
        <script src="ASSETS/JS/ListaEst.js"></script>
    </body>
</html>
<%
    }
%>
