
package universidadgrupo9.Entidades;


public class Inscripcion {
    private int idInscripcion;
    private Alumnos alumno;
    private Materia materia;
    private double nota;

    public Inscripcion() {
    }

    public Inscripcion(double nota, Alumnos alumno, Materia materia ) {
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
        
    }

    public Inscripcion(int idInscripcion,double nota, Alumnos alumno, Materia materia ) {
        this.idInscripcion = idInscripcion;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

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
        String insc= idInscripcion+" "+alumno.getApellido()+" "+alumno.getNombre()+" "+materia.getNombre()+" "+nota;
        return insc;
    }
    
    
    
}
