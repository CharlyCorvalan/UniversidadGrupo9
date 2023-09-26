
package universidadgrupo9.AccesoADatos;

import java.sql.*;

import javax.swing.JOptionPane;


public class Conexion {
    //Declaramos las variables necesarias para establecer la conexion a base de datos
    //Modo static para ser llamadas desde cualquier parte del proyecto
    //Modo final para no ser modificadas
    private static final String URL="jdbc:mariadb://localhost:3306/";
    private static final String DB="universidad-Prueba";
    private static final String USUARIO="root";
    private static final String PASSWORD  ="";
    //Se declara una variable de la clase Connection
    private static Connection connection;
    
    //Constructor de conexion
    public Conexion() {      
    }
    //Metodo publico y estatico de conexion, puede ser llamado desde cualquier parte del proyecto
    public static Connection getConexion(){
        //Se comprueba de que no haya una conexion en curso
        if(connection==null){
            try {
                //Se cargan los drivers necesarios para establecer la conexion a la base de datos
                Class.forName("org.mariadb.jdbc.Driver");
                //Clase Connection necesita de los siguientes parametros para establecer conexion
                connection=DriverManager.getConnection(URL+DB, USUARIO, PASSWORD);
                JOptionPane.showMessageDialog(null, "Conexion exitosa a "+DB);
            } catch (ClassNotFoundException ex) {
                //Comprobacion de una correcta carga de drivers
                JOptionPane.showMessageDialog(null, "Error al cargar los drivers"+ex);
            } catch (SQLException ex) {
                //Comprobacion de correcta ejecucion de la clase Connection
                JOptionPane.showMessageDialog(null, "Error al conectarse"+ex);
            }
        }
        return connection;
    }
    
}
