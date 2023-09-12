/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package universidadgrupo9;

import java.sql.*;
import java.time.LocalDate;
import universidadgrupo9.AccesoADatos.AlumnoData;
import universidadgrupo9.AccesoADatos.Conexion;
import universidadgrupo9.AccesoADatos.MateriaData;
import universidadgrupo9.Entidades.Alumnos;
import universidadgrupo9.Entidades.Materia;
public class UniversidadGrupo9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Connection con=Conexion.getConexion();
//        Materia materia=new Materia(1,"Matematicas 2",2,true);
//        Materia lengua= new Materia(2,"Lengua 2",2,true);
//        Materia historia=new Materia(3,"Historia 2",2,true);
//        Materia historia1=new Materia(4,"Historia 1",1,true);
//        MateriaData mate=new MateriaData();
////        mate.agregarMateria(materia);
////            mate.agregarMateria(historia1);
////        mate.modificarMateria(materia);
////          mate.eliminarMateria(1);
////            mate.buscarMateriaXid(1);
//            mate.buscarMateriasXaño(2);

Alumnos juan=new Alumnos(1,123456,"Luna","lucas pedro",LocalDate.of(1980,4, 12),true);

AlumnoData alu=new AlumnoData();
//alu.guardarAlumno(juan);
//alu.modificarAlumno(juan);
//alu.eliminarAlumno(1);   
    }
    
}
