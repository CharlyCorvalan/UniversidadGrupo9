
 
package universidadgrupo9.Entidades;

import java.time.LocalDate;


public class Alumnos {
    // declaramos los siguientes atributos , para poder instanciar un objecto 
    private int idAlumno, dni;
    private String nombre , apellido;
    private LocalDate fechaNac;
    private boolean activo;
//creamos el siguiente constructor vacio, que nos permiten crear objectos sin datos guardados
    public Alumnos() {
    }
//en el siguiente constructor lo inicializamos con todos sus parametros
    public Alumnos(int idAlumno, int dni, String apellido, String nombre, LocalDate fechaNac, boolean activo) {
        this.idAlumno = idAlumno;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.activo = activo;
    }
//en este constructor inicializamos todos menos el atributo de idAlumno
    public Alumnos(int dni, String apellido , String nombre , LocalDate fechaNac, boolean activo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.activo = activo;
    }
//generamos los getter and setter correspondientes, que nos permiten  traer los valores de los atributos, que tengamos en la clase
    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
//toString se utiliza para obtener una representacion 
    @Override
    public String toString() {
        return idAlumno +" "  +dni+" " +  nombre +" "+  apellido;
    }
    
    
}
