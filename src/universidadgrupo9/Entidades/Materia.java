
package universidadgrupo9.Entidades;


public class Materia {
    //establecemos los atributos de la clase
    private int idMateria;
    private String nombre;
    private int añoMateria;
    private boolean activo;

    public Materia() {
        // constructor vacio,Puede ser utilizado para crear una instancia de Materia 
    }

    public Materia(String nombre, int añoMateria, boolean activo) {
        //Este constructor recibe tres parámetros  y se utiliza para crear una instancia de Materia
        //inicializando estos atributos con los valores proporcionados.
        this.nombre = nombre;
        this.añoMateria = añoMateria;
        this.activo = activo;
    }

    public Materia(int idMateria, String nombre, int añoMateria, boolean activo) {
        // Este constructor recibe cuatro parámetros  y se utiliza para crear una instancia de Materia 
        //inicializando todos los atributos, incluyendo el identificador único idMateria
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.añoMateria = añoMateria;
        this.activo = activo;
    }

    public int getIdMateria() {
        // getter y setter ,permiten acceder y modificar los valores de los atributos desde fuera de la clase de manera controlada.
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAñoMateria() {
        return añoMateria;
    }

    public void setAñoMateria(int añoMateria) {
        this.añoMateria = añoMateria;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        //proporciona una representación en cadena de la materia para su visualización.
        return  idMateria + "-" + nombre ;
    }
    
    
}
