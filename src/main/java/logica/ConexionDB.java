
package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionDB {
    
    private static final String URL = "jdbc:mysql://localhost:3308/db_empleados";
    private static final String user= "root";
    private static final String password = "";
    
    public static Connection conectar(){ // devuelve la API de JDBC. Interfaz que representa una conexión activa con la DB. 
        try{
            return DriverManager.getConnection(URL,user,password); //establece la conexion con la DB.
        }
        catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    
}
