package universidadgrupo9.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadgrupo9.Entidades.Materia;

public class MateriaData {

    //Se declara una variable de tipo Connection sin conexion
    private Connection con = null;
    //ArrayList necesaria para el desarrollo de varios metodos
    private ArrayList<Materia> materia = new ArrayList<>();

    //Constructor (vacio) de MateriaData  el cual llama al metodo estatico de clase Conexion
    public MateriaData() {
        con = Conexion.getConexion();
    }
    //Metodo necesario para insertar una nueva materia en la base de datos
    public void agregarMateria(Materia mat) {
        //Prepara la sentencia a enviar
        String materia = "insert into materia (nombre, año, estado)"
                + "values (?,?,?)";
        try {
            //Establece la conexion con la base de datos y prepara el envio de la sentencia
            PreparedStatement ps = con.prepareStatement(materia, PreparedStatement.RETURN_GENERATED_KEYS);
            //Reemplaza los valores '?'
            ps.setString(1, mat.getNombre());
            ps.setInt(2, mat.getAñoMateria());
            ps.setBoolean(3, mat.isActivo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                mat.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia cargada");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla materia" + ex);
        }
    }

    public void modificarMateria(Materia mat) {
        String materia = "update  materia set nombre = ?, año=?, estado=? where idMateria =? ";
        try {
            PreparedStatement ps = con.prepareStatement(materia);
            ps.setString(1, mat.getNombre());
            ps.setInt(2, mat.getAñoMateria());
            ps.setBoolean(3, mat.isActivo());
            ps.setInt(4, mat.getIdMateria());
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Exito al modificar la materia");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla materia" + ex);
        }
    }

    public void eliminarMateria(int x) {
        String materia = "update materia set estado =0 where idMateria =? ";
        try {
            PreparedStatement ps = con.prepareStatement(materia);
            ps.setInt(1, x);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia eliminada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla materia" + ex);
        }

    }

    public Materia buscarMateriaXid(int id) {
        String materia = "select idMateria,nombre, año, estado from materia where idMateria =?";
        Materia materiaID = new Materia();
        try {
            PreparedStatement ps = con.prepareStatement(materia);
            ps.setInt(1, id);
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                materiaID.setIdMateria(resultado.getInt("idMateria"));
                materiaID.setNombre(resultado.getString("nombre"));
                materiaID.setAñoMateria(resultado.getInt("año"));
                materiaID.setActivo(resultado.getBoolean("estado"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla materia" + ex);
        }
        return materiaID;
    }

    public ArrayList<Materia> buscarMateriasXaño(int año) {
        String mate = "select idMateria , nombre, año, estado from materia where año=?";
        Materia materiaA = new Materia();
        try {
            PreparedStatement ps = con.prepareStatement(mate);
            ps.setInt(1, año);
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                materiaA.setIdMateria(resultado.getInt("idMateria"));
                materiaA.setNombre(resultado.getString("nombre"));
                materiaA.setAñoMateria(resultado.getInt("año"));
                materiaA.setActivo(resultado.getBoolean("estado"));

                materia.add(materiaA);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla materia" + ex);
        }
        return materia;
    }

    public ArrayList<Materia> listarMAterias() {
        String lista = "select *from materia where estado=1";
        try {
            PreparedStatement ps = con.prepareStatement(lista);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia mate = new Materia();
                mate.setIdMateria(rs.getInt("idMateria"));
                mate.setNombre(rs.getString("nombre"));
                mate.setAñoMateria(rs.getInt("año"));
                mate.setActivo(rs.getBoolean("estado"));
                materia.add(mate);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede acceder a la tabla materia" + ex);
        }
        return materia;
    }

    public Materia buscarPorNombre(String nombre) {
        String sql = "Select * from materia where nombre like ?";
        Materia buscaNombre = new Materia();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                buscaNombre.setIdMateria(resultado.getInt("idMateria"));
                buscaNombre.setNombre(resultado.getString("nombre"));
                buscaNombre.setAñoMateria(resultado.getInt("año"));
                buscaNombre.setActivo(resultado.getBoolean("estado"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla materia" + ex);
        }
        return buscaNombre;
    }
}
