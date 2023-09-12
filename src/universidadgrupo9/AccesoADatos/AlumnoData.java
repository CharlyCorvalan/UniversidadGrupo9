/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo9.AccesoADatos;

 import java.sql.*;
import java.sql.Date;
import org.mariadb.jdbc.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadgrupo9.Entidades.Alumnos;
public class AlumnoData {
 private Connection con=null;
 public AlumnoData(){
     con=Conexion.getConexion();
 }
 
 public void guardarAlumno(Alumnos alumno){
  String sql="insert into alumno(dni,apellido,nombre,fechaNac,estado)"
          + "values(?,?,?,?,?)";   
  
     try {
         PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
         ps.setInt(1,alumno.getDni());
         ps.setString(2,alumno.getApellido());
         ps.setString(3,alumno.getNombre());
         ps.setDate(4,Date.valueOf(alumno.getFechaNac()));
         ps.setBoolean(5,alumno.isActivo());
         ps.executeUpdate();
        ResultSet rs= ps.getGeneratedKeys();
        if(rs.next()){
            alumno.setIdAlumno(rs.getInt(1));
            JOptionPane.showMessageDialog(null,"Alumno agregado");
        }
        ps.close();
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null,"Error al acceder a la tabla alumnos");
     }
  
 }
     
 public void modificarAlumno(Alumnos alumno){
  String sql="UPDATE alumno SET dni=?,apellido=?,nombre=?,fechaNac=?"
          +"WHERE idAlumno=?";
     try {
         PreparedStatement ps=con.prepareStatement(sql);
         ps.setInt(1,alumno.getDni());
         ps.setString(2,alumno.getApellido());
         ps.setString(3,alumno.getNombre());
         ps.setDate(4,Date.valueOf(alumno.getFechaNac()));
         ps.setInt(5,alumno.getIdAlumno());
         int exito=ps.executeUpdate();
         if(exito==1){
             JOptionPane.showMessageDialog(null,"Alumno modificado");
         }
         
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null,"Error al acceder a la tabla alumno");
        
     }
  
          
 } 
 public void eliminarAlumno(int id){
     String sql="UPDATE alumno SET estado=0 WHERE idAlumno=?";
     try {
         PreparedStatement ps=con.prepareStatement(sql);
         ps.setInt(1, id);
        int exito= ps.executeUpdate();
        if(exito==1){
            JOptionPane.showMessageDialog(null,"Alumno eliminado");
        }
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null,"Error al acceder a la tabla alumno");
         
     }
     
 }
}
