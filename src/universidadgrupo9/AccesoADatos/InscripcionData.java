
package universidadgrupo9.AccesoADatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadgrupo9.Entidades.Inscripcion;
import universidadgrupo9.Entidades.Materia;


public class InscripcionData {
    
    private Connection con=null;
    private MateriaData mat;
    private AlumnoData alum;

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
    
    public void ListarInscricion(){
        
        
    }
    
    public ArrayList<Materia> InscripcionPorAlum(int idAlum){
        Materia materia=new Materia();
        ArrayList<Materia> mat =new ArrayList<>();
       String cons="SELECT 'idMateria', nombre , año FROM materia JOIN inscripcion ON "
               + "(materia.idMateria=inscripcion.idMateria) WHERE idAlumno = ?";
        try {
            PreparedStatement ps=con.prepareStatement(cons);
            ps.setInt(1, idAlum);
           ResultSet num= ps.executeQuery();
           if(num.next()){
               materia.setIdMateria(num.getInt("idMateria"));
               materia.setNombre(num.getString("nombre"));
               materia.setAñoMateria(num.getInt("año"));
               mat.add(materia);
           }
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se ah conectado con exito a la base de datos " +ex);
        }
        return mat;
    }
    
}

