/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo9.AccesoADatos;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.awt.List;
import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.mariadb.jdbc.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadgrupo9.Entidades.Alumnos;

public class AlumnoData {

    private Connection con = null;
private ArrayList<Alumnos> alumnos = new ArrayList<>();
    public AlumnoData() {
        con = Conexion.getConexion();
    }

    public void guardarAlumno(Alumnos alumno) {
        String sql = "insert into alumno(dni,apellido,nombre,fechaNac,estado)"
                + "values(?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isActivo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno agregado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos");
        }

    }

    public void modificarAlumno(Alumnos alumno) {
        String sql = "update alumno set dni=? , apellido=? , nombre=?  ,fechaNac=?, estado=? "
                + "where idAlumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isActivo());
            ps.setInt(6, alumno.getIdAlumno());
//            ResultSet resultado=ps.executeQuery();
//            while (resultado.next()) {
//                JOptionPane.showMessageDialog(null,"Alumno modificado");
//                
//            }
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alumno modificado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
    }

    public void eliminarAlumno(int id) {
        String sql = "UPDATE alumno SET estado=0 WHERE idAlumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alumno eliminado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");

        }

    }

    public ArrayList<Alumnos> listarAlumnos() {
       
        
        try {
            String sql = "SELECT * FROM alumno WHERE estado = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumnos alumno = new Alumnos();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                alumno.setActivo(rs.getBoolean("estado"));
                alumnos.add(alumno);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno " + ex.getMessage());
        }
        return alumnos;
    }
    public Alumnos buscarPorDni (int dni){
        Alumnos alu=new Alumnos();
        String sql="select idAlumno , dni, apellido, nombre ,fechaNac, estado from alumno where dni = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet resultado=ps.executeQuery();
            while(resultado.next()){
                alu.setIdAlumno(resultado.getInt("idAlumno"));
                alu.setDni(resultado.getInt("dni"));
                alu.setApellido(resultado.getString("apellido"));
                alu.setNombre(resultado.getString("nombre"));
                alu.setFechaNac(resultado.getDate("fechaNac").toLocalDate());
                alu.setActivo(resultado.getBoolean("estado")); 
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede acceder a la tabla alumnos"+ex);
        }
        
        return alu;
    }
}
