$(document).ready(function () {
    listarProducto();
});

function listarProducto() {
    $.get('PersonaEst', {'opc': 1}, function (data) {
        let x = JSON.parse(data);
        $(".table tbody tr").remove();
        for (var i = 0; i < x.length; i++) {
            $("#tablavista").append("<tr><td>" + (i + 1) +
                    "</td><td>" + x[i].idpersona +
                    "</td><td>" + x[i].nombres +
                    "</td><td>" + x[i].apellidos +
                    "</td><td>" + x[i].codigo +
                    "</td><td>" + x[i].correo +
                    "</td><td>" + x[i].carrera +
                    "</td></tr>");
        }
    });
}


