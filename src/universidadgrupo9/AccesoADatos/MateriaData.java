
package universidadgrupo9.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadgrupo9.Entidades.Materia;


public class MateriaData {
    private Connection con=null;

    public MateriaData() {
        con=Conexion.getConexion();
    }
    
    public void agregarMateria (Materia mat){
        String materia="insert into materia (nombre, año, estado)"
                + "values (?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(materia,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, mat.getNombre());
            ps.setInt(2, mat.getAñoMateria());
            ps.setBoolean(3, mat.isActivo());
            ps.executeUpdate();
            ResultSet rs =ps.getGeneratedKeys();
            if(rs.next()){
                mat.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia cargada");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla materia"+ex);
        }
    }
    public void modificarMateria (Materia mat){
        String materia="update  materia set nombre = ?, año=? where idMateria =? ";
        try {
            PreparedStatement ps=con.prepareStatement(materia);
            ps.setString(1, mat.getNombre());
            ps.setInt(2, mat.getAñoMateria());
            ps.setInt(3, mat.getIdMateria());
            int resultado =ps.executeUpdate();
            if(resultado ==1){
            JOptionPane.showMessageDialog(null, "Exito al modificar la materia");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla materia"+ex);
        }
    }
    public void eliminarMateria (int x){
        String materia="update materia set estado =0 where idMateria =? ";
        try {
            PreparedStatement ps=con.prepareStatement(materia);
            ps.setInt(1, x);
            int exito =ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Materia eliminada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla materia"+ex);
        }
        
    }
    public void buscarMateriaXid(int id){
        String materia="select idMateria,nombre, año, estado from materia where idMateria =?";
        try {
            PreparedStatement ps=con.prepareStatement(materia);
            ps.setInt(1, id);
            ResultSet resultado =ps.executeQuery();
            while(resultado.next()){
                System.out.println("idMateria: "+resultado.getInt("idMateria"));
                System.out.println("Nombre: "+resultado.getString("nombre"));
                System.out.println("Año: "+resultado.getInt("año"));
                System.out.println("Estado: "+resultado.getBoolean("estado"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla materia"+ex);
        }
        
    }
    public void buscarMateriasXaño (int año){
        String materia="select idMateria , nombre, año, estado from materia where año=?";
        try {
            PreparedStatement ps=con.prepareStatement(materia);
            ps.setInt(1, año);
            ResultSet resultado =ps.executeQuery();
            while(resultado.next()){
                System.out.println("iDMateria: "+resultado.getInt("idMateria"));
                System.out.println("Nombre: "+resultado.getString("nombre"));
                System.out.println("Año: "+resultado.getInt("año"));
                System.out.println("Estado: "+resultado.getBoolean("estado"));
                System.out.println("=============================================");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla materia"+ex);
        }
        
    }
    
}
