/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.com.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author angel
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class LoginDTO {
    private int idpersona;
    private String usuario;
    private String estado;
    private int idrol;
    private String rol;
    private int idcarrera;
    private String carrera;
}
