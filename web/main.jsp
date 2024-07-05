

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
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">SISTEMA ACADEMICO</a>
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
                </div>
                <div class="collapse navbar-collapse d-flex justify-content-end m-2" id="navbarNavDropdown">
                    <ul class="navbar-nav me-5">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                <%=user%>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#"><%=rol%></a></li>
                                <li><a class="dropdown-item" href="#"><%=carrera%></a></li>
                                <li><a class="dropdown-item" href="Logout">Logout</a></li>
                            </ul>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>
            <div class="d-flex flex-column align-items-center justify-content-center gap-1 m-4 fw-semibold">            
            <h1>LISTA DE ESTUDIANTES</h1>
            <div id="formulario" class="formulario w-100 d-flex justify-content-between align-items-end gap-2">
                <div class="d-flex flex-column">
                    <label>NOMBRES:</label>
                    <input type="text" name="nombres" id="nombres" class="border border-dark-subtle rounded p-1" style="width: 250px;">
                </div>
                <div class="d-flex flex-column">
                    <label>APELLIDOS:</label>
                    <input type="text" name="apellidos" id="apellidos" class="border border-dark-subtle rounded p-1" style="width: 150px;">
                </div>
                <div class="d-flex flex-column">
                    <label>CODIGO:</label>
                    <input type="text" name="codigo" id="codigo" class="border border-dark-subtle rounded p-1" style="width: 90px;">
                </div>
                <div class="d-flex flex-column">
                    <label>DNI:</label>
                    <input type="text" name="dni" id="dni" class="border border-dark-subtle rounded p-1" style="width: 90px;">
                </div>
                <div class="d-flex flex-column">
                    <label>CORREO:</label>
                    <input type="text" name="correo" id="correo" class="border border-dark-subtle rounded p-1" style="width: 180px;">
                </div>
                <div class="d-flex flex-column">
                    <label>TELEFONO:</label>
                    <input type="text" name="telefono" id="telefono" class="border border-dark-subtle rounded p-1" style="width: 120px;">
                </div>
                <div class="d-flex flex-column">
                    <label>USUARIO:</label>
                    <input type="text" name="usuario" id="usuario" class="border border-dark-subtle rounded p-1" style="width: 90px;">
                </div>
                <div class="d-flex flex-column">
                    <label>CLAVE:</label>
                    <input type="text" name="clave" id="clave" class="border border-dark-subtle rounded p-1" style="width: 90px;">
                </div>
                <input type="button" id="agregar" value="AGREGAR" class="fw-semibold btn btn-success h-75">
            </div>
            <table class="table w-100 mt-3 data_table" id="tablavista">
                <thead>
                    <tr>
                        <th class="fw-semibold" scope="col">#</th>
                        <th class="fw-semibold" scope="col">ID</th>
                        <th class="fw-semibold" scope="col">NOMBRES</th>
                        <th class="fw-semibold" scope="col">APELLIDOS</th>
                        <th class="fw-semibold" scope="col">CODIGO</th>
                        <th class="fw-semibold" scope="col">DNI</th>
                        <th class="fw-semibold" scope="col">CORREO</th>
                        <th class="fw-semibold" scope="col">TELEFONO</th>
                        <th class="fw-semibold" scope="col">USUARIO</th>
                        <th class="fw-semibold" scope="col">CLAVE</th>
                        <th class="fw-semibold" scope="col">ESTADO</th>
                        <th class="fw-semibold" scope="col">OPCIONES</th>
 
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
            
            <div id="formulario" class="formulario w-100 d-flex justify-content-between align-items-end gap-2">
                <div class="d-flex flex-column">
                    <label>ROL:</label>
                    <input type="text" name="nombres" id="nombres" class="border border-dark-subtle rounded p-1" style="width: 250px;">
                </div>
                <input type="button" id="agregar" value="AGREGAR" class="fw-semibold btn btn-success h-75">
            </div>    
            <table class="table w-100 mt-3 data_table" id="tablavista">
                <thead>
                    <tr>
                        <th class="fw-semibold" scope="col">#</th>
                        <th class="fw-semibold" scope="col">ID</th>
                        <th class="fw-semibold" scope="col">ROL</th>
                        <th class="fw-semibold" scope="col">ESTADO</th>
                        <th class="fw-semibold" scope="col">OPCIONES</th>
 
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <script src="ASSETS/JS/jquery-3.7.1.min.js"></script>
        <script src="ASSETS/JS/Persona.js"></script>
    </body>
</html>
<%
    }
%>
