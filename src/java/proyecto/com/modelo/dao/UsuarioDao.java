/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyecto.com.modelo.dao;

import java.util.List;
import proyecto.com.modelo.dto.LoginDTO;
import proyecto.com.modelo.dto.PersonaDTO;
import proyecto.com.modelo.dto.PersonaEstudianteDTO;
import proyecto.com.modelo.entity.Usuario;

/**
 *
 * @author angel
 */
public interface UsuarioDao {
    public List<LoginDTO> login(String usuario, String clave);
    public int crearPersona(Usuario p);
    public int editarPersona(Usuario p);
    public int eliminarPersona(int id);
    public PersonaDTO listarPersona(int id_carrera);
    public void bloquear(String usuario);
    public List<PersonaEstudianteDTO> listar();    
    public List<Usuario> listarPerso();
}
