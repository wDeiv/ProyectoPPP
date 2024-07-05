/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

document.addEventListener("DOMContentLoaded", function() {
    function showAlert(message) {
        if (message) {
            alert(message);
        }
    }
    var errorMessageDiv = document.getElementById("error-message");
    var errorMessage = errorMessageDiv.getAttribute("data-error");
    showAlert(errorMessage);
});
