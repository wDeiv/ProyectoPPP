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

public class PersonaDTO {
    private int idpersona;
    private String nombres;
    private String apellidos;
    private String usuario;
    private String clave;
    private String estado;
    private String id_rol;
    private int id_carrera;
}