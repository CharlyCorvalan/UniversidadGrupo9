/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package universidadgrupo9;

import java.sql.*;
import java.time.LocalDate;
import universidadgrupo9.AccesoADatos.AlumnoData;
import universidadgrupo9.AccesoADatos.Conexion;
import universidadgrupo9.AccesoADatos.InscripcionData;
import universidadgrupo9.AccesoADatos.MateriaData;
import universidadgrupo9.Entidades.Alumnos;
import universidadgrupo9.Entidades.Inscripcion;
import universidadgrupo9.Entidades.Materia;
import universidadgrupo9.Vistas.MenuPrincipal;
public class UniversidadGrupo9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });

        
    }
    
}
