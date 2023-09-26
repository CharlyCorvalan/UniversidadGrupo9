
package universidadgrupo9.Entidades;


public class Inscripcion {
    // se declaran los atributos de la clase 
    private int idInscripcion;
    private Alumnos alumno;
    private Materia materia;
    private double nota;

    public Inscripcion() {
        ////creamos el siguiente constructor vacio, que nos permiten crear objectos sin datos guardados
    }

    public Inscripcion(double nota, Alumnos alumno, Materia materia ) {
        // se utiliza para crear una instancia de la clase Inscripcion 
        // y establecer sus atributos (nota, alumno, materia) con los valores proporcionados como parámetros.
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
        
    }

    public Inscripcion(int idInscripcion,double nota, Alumnos alumno, Materia materia ) {
        // Este constructor permite crear objetos (Inscripcion) con información específica sobre la inscripción,
        //la calificación, y las relaciones con el alumno y la materia correspondientes.
        this.idInscripcion = idInscripcion;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }
//generamos los getter and setter ,se utilizan para acceder a los atributos de la clase Inscripcion, y modificar esos atributos 
    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
   
    public String toString() {
        // lo utilizamos para obtener una representación legible de una instancia de Inscripcion
        String insc= idInscripcion+" "+alumno.getApellido()+" "+alumno.getNombre()+" "+materia.getNombre()+" "+nota;
        return insc;
    }
    
    
    
}
