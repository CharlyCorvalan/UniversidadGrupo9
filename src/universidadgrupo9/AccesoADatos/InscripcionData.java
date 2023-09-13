
package universidadgrupo9.AccesoADatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadgrupo9.Entidades.Inscripcion;


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
    
    public void InscripcionPorAlum(int idAlum){
        
        
    }
    
}

