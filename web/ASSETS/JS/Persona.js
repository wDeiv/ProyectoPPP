$(document).ready(function () {
    listarPersona();
    
});
function listarPersona() {
    $.get('Persona', {'opc': 1}, function (data) {
        let x = JSON.parse(data);
        $(".table tbody tr").remove();
        for (var i = 0; i < x.length; i++) {
            $("#tablavista").append("<tr><td>" + (i + 1) +
                    "</td><td>" + x[i].idpersona +
                    "</td><td>" + x[i].nombres +
                    "</td><td>" + x[i].apellidos +
                    "</td><td>" + x[i].codigo +
                    "</td><td>" + x[i].dni +
                    "</td><td>" + x[i].correo +
                    "</td><td>" + x[i].telefono +
                    "</td><td>" + x[i].usuario +
                    "</td><td>" + x[i].clave +
                    "</td><td>" + x[i].estado +
                    "</td><td><button onclick ='editar(" + x[i].idpersona + 
                    ")' class='btn btn-danger btn-sm'>Editar</button>" + "  " +
                    "<button onclick ='eliminar(" + x[i].idpersona + 
                    ")' class='btn btn-danger btn-sm'>Eliminar</button>" +
                    "</td></tr>");
        }
    });
}
$("#agregar").click(function () {
    let nombres = $("#nombres").val();
    let apellidos = $("#apellidos").val();
    let codigo = $("#codigo").val();
    let dni = $("#dni").val();
    let correo = $("#correo").val();
    let telefono = $("#telefono").val();
    let usuario = $("#usuario").val();
    let clave = $("#clave").val();
    
    $.post('Persona',{'opc': 2, 'nombres': nombres, 'apellidos': apellidos, 'codigo': codigo, 'dni': dni, 'correo': correo, 'telefono': telefono, 'usuario': usuario, 'clave': clave},function (data) {
        console.log("Respuesta del servidor:", data);
        listarPersona();
    }).fail(function (error){
       console.error("EROR", error); 
    });
});

