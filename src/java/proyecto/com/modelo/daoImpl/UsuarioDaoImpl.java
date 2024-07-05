/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.com.modelo.daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import proyecto.com.modelo.dto.LoginDTO;
import proyecto.com.modelo.dto.PersonaDTO;
import proyecto.com.modelo.entity.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import proyecto.com.modelo.dto.PersonaEstudianteDTO;
import proyecto.com.modelo.config.Conexion;
import proyecto.com.modelo.dao.UsuarioDao;

/**
 *
 * @author angel
 */
public class UsuarioDaoImpl implements UsuarioDao {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;

    @Override
    public List<LoginDTO> login(String usuario, String clave) {
        List<LoginDTO> lista = new ArrayList<>();
        String SQL = "SELECT p.id_persona, p.usuario, p.estado, r.id_rol, r.rol, c.id_carrera, c.nombre as carrera FROM persona p "
                + "JOIN rolpersona rp ON p.id_persona = rp.id_persona "
                + "JOIN rol r ON rp.id_rol = r.id_rol "
                + "JOIN carrerapersona cp ON p.id_persona = cp.id_persona "
                + "JOIN carrera c ON cp.id_carrera = c.id_carrera "
                + "WHERE p.usuario = ? and p.clave = ?";
        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            while (rs.next()) {
                LoginDTO dTO = new LoginDTO();
                dTO.setIdpersona(rs.getInt("id_persona"));
                dTO.setUsuario(rs.getString("usuario"));
                dTO.setEstado(rs.getString("estado"));
                dTO.setIdrol(rs.getInt("id_rol"));
                dTO.setRol(rs.getString("rol"));
                dTO.setIdcarrera(rs.getInt("id_carrera"));
                dTO.setCarrera(rs.getString("carrera"));
                lista.add(dTO);
            }
        } catch (SQLException e) {
            System.out.println("Login: " + e);
        }
        return lista;
    }

    @Override
    public int crearPersona(Usuario p) {
        int x = 0;
        String SQL = "INSERT INTO PERSONA(ID_PERSONA, NOMBRES, APELLIDOS, USUARIO, CLAVE, ESTADO) "
                + "VALUES(sq_persona.nextval, ?, ?, ?, ?, ?, ?, ?, ?, A)";
        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);

            ps.setString(1, p.getNombres());
            ps.setString(2, p.getApellidos());
            ps.setString(7, p.getUsuario());
            ps.setString(8, p.getClave());
            ps.setString(9, p.getEstado());

            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
        return x;
    }

    @Override
    public int editarPersona(Usuario p) {
        int x = 0;
        String SQL = "UPDATE PERSONA SET NOMBRES=?, APELLIDOS=?, USUARIO=?, CLAVE=?, ESTADO=? WHERE ID_PERSONA=?";
        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);

            ps.setString(1, p.getNombres());
            ps.setString(2, p.getApellidos());
            ps.setString(2, p.getUsuario());
            ps.setString(3, p.getClave());
            ps.setString(4, p.getEstado());
            ps.setInt(5, p.getIdpersona());

            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
        return x;
    }

    @Override
    public int eliminarPersona(int id) {
        int x = 0;
        String SQL = "DELETE FROM PERSONA WHERE ID_PERSONA=?";
        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);

            ps.setInt(1, id);

            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
        return x;
    }

    @Override
    public void bloquear(String usuario) {
        String SQL = "UPDATE PERSONA SET estado ='I' WHERE usuario=?";
        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            
            ps.setString(1, usuario);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
    }

    @Override
    public List<PersonaEstudianteDTO> listar() {
        List<PersonaEstudianteDTO> personaEs = new ArrayList<>();
        String SQL = "SELECT p.id_persona, p.nombres, p.apellidos, p.codigo, p.correo, c.nombre as carrera FROM persona p "
                + "JOIN rolpersona rp ON p.id_persona = rp.id_persona "
                + "JOIN rol r ON rp.id_rol = r.id_rol "
                + "JOIN carrerapersona cp ON p.id_persona = cp.id_persona "
                + "JOIN carrera c ON cp.id_carrera = c.id_carrera "
                + "WHERE r.id_rol=4";
        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);

            rs = ps.executeQuery();
            while (rs.next()) {
                PersonaEstudianteDTO estudianteDTO = new PersonaEstudianteDTO();
                estudianteDTO.setIdpersona(rs.getInt("id_persona"));
                estudianteDTO.setNombres(rs.getString("nombres"));
                estudianteDTO.setApellidos(rs.getString("apellidos"));
                estudianteDTO.setCodigo(rs.getString("codigo"));
                estudianteDTO.setCorreo(rs.getString("correo"));
                estudianteDTO.setCarrera(rs.getString("carrera"));
                personaEs.add(estudianteDTO);
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
        return personaEs;
    }

    @Override
    public PersonaDTO listarPersona(int id_carrera) {
        PersonaDTO pdto = new PersonaDTO();
        String SQL = "SELECT p.id_persona, p.nombres , p.apellidos, p.usuario, p.clave, p.estado FROM persona p "
                + "JOIN rolpersona rp ON p.id_persona = rp.id_persona "
                + "JOIN rol r ON rp.id_rol = r.id_rol "
                + "JOIN carrerapersona cp ON p.id_persona = cp.id_persona "
                + "JOIN carrera c ON cp.id_carrera = c.id_carrera "
                + "WHERE r.id_rol=4 AND c.id_carrera=?";
        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            
            ps.setInt(1, id_carrera);
            rs = ps.executeQuery();
            while (rs.next()) {
                pdto.setIdpersona(rs.getInt("id_persona"));
                pdto.setNombres(rs.getString("nombres"));
                pdto.setApellidos(rs.getString("apellidos"));
                pdto.setUsuario(rs.getString("usuario"));
                pdto.setClave(rs.getString("clave"));
                pdto.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Login: " + e);
        }
        return pdto;
    }

    @Override
    public List<Usuario> listarPerso() {
        List<Usuario> personas = new ArrayList<>();
        String SQL = "SELECT *FROM PERSONA";
        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario p = new Usuario();
                p.setIdpersona(rs.getInt("id_persona"));
                p.setNombres(rs.getString("nombres"));
                p.setApellidos(rs.getString("apellidos"));
                p.setUsuario(rs.getString("usuario"));
                p.setClave(rs.getString("clave"));
                p.setEstado(rs.getString("estado"));
                personas.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Login: " + e);
        }
        return personas;
    }

}
