/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.com.modelo.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import proyecto.com.modelo.dao.RolDao;
import proyecto.com.modelo.entity.Rol;
import proyecto.com.modelo.config.Conexion;

/**
 *
 * @author angel
 */
public class RolDaoImpl implements RolDao{
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;

    @Override
    public int crearPersona(Rol r) {
        int x = 0;
        String SQL = "INSERT INTO ROL(ID_ROL, ROL, ESTADO(sq_rol.nextval,?, A)";
        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            
            ps.setString(1, r.getNombre());
            ps.setString(2, r.getEstado());
            
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
        return x;
    }

    @Override
    public int editarPersona(Rol r) {
        int x = 0;
        String SQL = "UPDATE ROL SET ROL=?, ESTADO=A";
        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            
            ps.setString(1, r.getNombre());
            ps.setString(2, r.getEstado());
            
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
        return x;
    }

    @Override
    public int eliminarPersona(String estado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Rol> listarRol() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
