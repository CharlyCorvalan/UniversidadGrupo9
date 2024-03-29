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
        //Preparar sentencia para mandar a mysql
        ///El metodo guarda un alumno, tomando los datos del mismo, desde el alumno que 
        ///llega por parametro.
        String sql = "insert into alumno(dni,apellido,nombre,fechaNac,estado)"
                + "values(?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //se pasan los parametros del "?"
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isActivo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            //se recorre las posiciones del ResulSet
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
        //El metodo modifica un o los datos de un alumno que llega por parametro
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
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alumno modificado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
    }

    public void eliminarAlumno(int id) {
        //El metodo elimina un alumno que llega por parametro el cual esta representado por un INT 
        //que llega por parametro.
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
       //El metodo Lista los alumnos conformados destro de un ArrayList en el cual, como condicion
       //Esta dada en base a su "estado=1"(true o activos)
        
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
        //El metodo busca un alumno por su DNI, el cual esta pasado por paramero con un INTdni
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
        //El mismo metodo Setea los datos del alumno y los guarda en el objeto "alu" creado en el mismo metodo
        //para luego devolverlo en el return
        return alu;
    }
    public Alumnos buscarPorId(int id){
        //El metodo busca un alumno por medio de su ID, el cual esta pasado por parametro
    Alumnos alum=new Alumnos();
    String sql="Select  idAlumno , dni, apellido, nombre ,fechaNac, estado from alumno where dni = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultado=ps.executeQuery();
            while(resultado.next()){
                alum.setIdAlumno(resultado.getInt("idAlumno"));
                alum.setDni(resultado.getInt("dni"));
                alum.setApellido(resultado.getString("apellido"));
                alum.setNombre(resultado.getString("nombre"));
                alum.setFechaNac(resultado.getDate("fechaNac").toLocalDate());
                alum.setActivo(resultado.getBoolean("estado")); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Al igual que el metodo buscarPorDni(), el metodo guarda los datos del alumno en el objeto "alum"
        //Y los retorna por medio del return
    return alum;
    }
}
