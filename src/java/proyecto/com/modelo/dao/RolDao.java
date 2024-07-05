/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyecto.com.modelo.dao;

import java.util.List;
import proyecto.com.modelo.entity.Rol;

/**
 *
 * @author angel
 */
public interface RolDao {
    public int crearPersona(Rol r);
    public int editarPersona(Rol r);
    public int eliminarPersona(String estado);
    public List<Rol> listarRol();
}
