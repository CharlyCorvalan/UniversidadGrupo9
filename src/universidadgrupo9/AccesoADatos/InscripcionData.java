
package universidadgrupo9.AccesoADatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sun.java2d.loops.FillSpans;
import universidadgrupo9.Entidades.Alumnos;
import universidadgrupo9.Entidades.Inscripcion;
import universidadgrupo9.Entidades.Materia;


public class InscripcionData {
    
    private Connection con=null;
    private MateriaData mat;
    private AlumnoData alum;
    private ArrayList<Inscripcion> ins=new ArrayList<>();
    private ArrayList<Materia> materia =new ArrayList<>();
    private ArrayList<Alumnos> alumno=new ArrayList<>();

    public InscripcionData() {
        con=Conexion.getConexion();
        
    }

    public void guardarInscripcion (Inscripcion ins){
     
        try {
            String insAlum="INSERT INTO `inscripcion`(`nota`, `idAlumno`, `idMateria`)"
                    + " VALUES (?,?,?)";
            PreparedStatement ps=con.prepareStatement(insAlum,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, ins.getNota());
            ps.setInt(2, ins.getAlumno().getIdAlumno());
            ps.setInt(3, ins.getMateria().getIdMateria());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                ins.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripcion realizada con exito!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo inscribir al alumno. "+ex);
        }
       
    }
    
    public ArrayList <Inscripcion> obtenerInscripciones(){
        String sql="select idInscripcion , nota , idMateria , idAlumno from inscripcion ";
        try {
           PreparedStatement  ps = con.prepareStatement(sql);
            ResultSet resultado=ps.executeQuery();
        while(resultado.next()){
            System.out.println(resultado.getInt("idInscripcion")+" / "+resultado.getInt("idMateria"));
            Inscripcion inscrip=new Inscripcion();
             Alumnos alu=new Alumnos();
             Materia matete=new Materia();
            inscrip.setIdInscripcion(resultado.getInt("idInscripcion"));
            inscrip.setNota(resultado.getInt("nota"));
            int idAl=resultado.getInt("idAlumno");
            alu.setIdAlumno(idAl);
            inscrip.setAlumno(alu);
            int idMAt=resultado.getInt("idMateria");
            matete.setIdMateria(idMAt);
            inscrip.setMateria(matete);
            ins.add(inscrip);           
        } 
        ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede acceder a la tabla inscripcion");
        }
               return ins;
    }
    
    public ArrayList<Materia> InscripcionPorAlum(int idAlum){  
        String cons="SELECT materia.idMateria , nombre , año FROM materia JOIN inscripcion ON "
               + "(materia.idMateria=inscripcion.idMateria) WHERE idAlumno =?";
        try {
            PreparedStatement ps=con.prepareStatement(cons);
            ps.setInt(1, idAlum);
            ResultSet resultado=ps.executeQuery();
            while(resultado.next()){
                Materia mate=new Materia();
                mate.setIdMateria(resultado.getInt("idMateria"));
                mate.setNombre(resultado.getString("nombre"));
                mate.setAñoMateria(resultado.getInt("año"));
                materia.add(mate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materia;
    }
    public ArrayList<Materia> NoInscripcionPorAlum(int idAlum){
        
       String cons="SELECT * FROM materia where estado=1 AND idMateria not in  "
               + "(SELECT idMateria from inscripcion WHERE idAlumno =?)";
        try {
            PreparedStatement ps=con.prepareStatement(cons);
            ps.setInt(1, idAlum);
           ResultSet num= ps.executeQuery();
           while(num.next()){
               Materia materiaNo=new Materia(); 
               materiaNo.setIdMateria(num.getInt("idMateria"));
               materiaNo.setNombre(num.getString("nombre"));
               materiaNo.setAñoMateria(num.getInt("año"));
               materia.add(materiaNo);
           }
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla" +ex);
        }
        for (Materia in : materia) {
            System.out.println(in.getIdMateria());
        }
        return materia;
  
    }
    
    public void AnularInscripcionAlum(int idAlumno, int idMateria){
        String sql="DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
             ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int filas=ps.executeUpdate();
            if(filas>0){
                JOptionPane.showMessageDialog(null,"inscripcion borrada exitosamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion, no se pudo borrar la inscripcion "+ex);
        }
        
    }
    
    public ArrayList<Inscripcion> InscripcionPorID(int idAlumno){
        String sql="SELECT inscripcion.idMateria, materia.nombre, nota FROM inscripcion join materia on inscripcion.idMateria"
                + "=materia.idMateria WHERE inscripcion.idAlumno=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Inscripcion insc=new Inscripcion();
                Materia mate=new Materia();
                
               mate.setIdMateria(rs.getInt("idMateria"));
               mate.setNombre(rs.getString("nombre"));
               insc.setNota(rs.getDouble("nota"));
               insc.setMateria(mate);
               ins.add(insc);
               
               
               
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error no se pudo conectar a la base de datos "+ex);
        }
        
       return ins;
    }
   
    public void ActualizarNota(int idAlumno, int idMateria, double nota){
        String sql="UPDATE inscripcion SET nota=? WHERE idAlumno=? AND idMateria=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int filas=ps.executeUpdate();
            if(filas==1){
               JOptionPane.showMessageDialog(null, "Nota actualizada con exito!"); 
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error no se pudo conectar a la base de datos "+ex);
        }
        
    }
    public  ArrayList<Alumnos> obtenerAlumnosPorMateria(int idMateria){
        String sql="Select alumno.idAlumno, dni, alumno.Apellido, alumno.Nombre FROM alumno JOIN inscripcion "
                + "ON (inscripcion.idAlumno=alumno.idAlumno) WHERE inscripcion.idMateria=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet resultado=ps.executeQuery();
            while(resultado.next()){
                Alumnos al=new Alumnos();
                al.setIdAlumno(resultado.getInt("idAlumno"));
                al.setDni(resultado.getInt("dni"));
                al.setApellido(resultado.getString("apellido"));
                al.setNombre(resultado.getString("nombre"));
                alumno.add(al);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
        return alumno;
    }
}

