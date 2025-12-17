package logica;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import logica.EmpleadoDAO;

public class App {

    public static void main(String[] args) throws SQLException {
        int opcion;
        EmpleadoDAO eD = new EmpleadoDAO(); //inicializo la clase
        Scanner sc = new Scanner (System.in);
        System.out.println("Bienvenido al programa gestor de Empleados");
        
        do {
            System.out.println("Menú:");
            System.out.println("\t1 - Insertar nuevo empleado");
            System.out.println("\t2 - Mostrar empleados");
            System.out.println("\t3 - Cambiar contraseña empleado");
            System.out.println("\t4 - Modificar empleado");
            System.out.println("\t5 - Eliminar empleado");
            System.out.println("\t6 - Exit");
            System.out.println("Introduce nº: ");
            opcion=sc.nextInt();
            sc.nextLine();
            
            switch(opcion){
                case 1:
                    System.out.println("Introduce el nombre de usuario: ");
                    String userName=sc.nextLine();
                    System.out.println("Introduce la contraseña de usuario: ");
                    String password=sc.nextLine();
                    System.out.println("Introduce el nombre del empleado: ");
                    String name=sc.nextLine();
                    System.out.println("Introduce el telefono del empleado: ");
                    String phone=sc.nextLine();
                    System.out.println("Introduce el departamento del empleado: ");
                    String departamento=sc.nextLine();
                    
                    eD.insertarUsuario(new Empleado (userName,password,name,phone,departamento));
                    break;
                    
                case 2:
                    
                    List<Empleado> empleados = eD.mostrarEmpleados(); // creamos nueva lista de empleados
                    if (empleados.isEmpty()){
                        System.out.println("No hay empleados registrados");
                    }
                    else {
                        System.out.println("lista empleados");
                        for(Empleado empleado:empleados){
                            System.out.println(empleado.toString());
                        }
                    }
                    break;
                    
                case 3:
                    System.out.println("Introduce el id del empleado: ");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introduce nueva contraseña: ");
                    String newPassword=sc.nextLine();
                    eD.cambiarPassword(id, newPassword);
                    break;
                    
                case 4:
                    System.out.println("Introduce el id del empleado: ");
                    id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introduce el nuevo nombre de usuario: ");
                    userName=sc.nextLine();
                    System.out.println("Introduce el nuevo nombre del empleado: ");
                    name=sc.nextLine();
                    System.out.println("Introduce el nuevo telefono del empleado: ");
                    phone=sc.nextLine();
                    System.out.println("Introduce el nuevo departamento del empleado: ");
                    departamento=sc.nextLine();
                    eD.modificarDatos(id, userName,name,phone,departamento); 
                    break;
                    
                case 5:
                    System.out.println("Introduce el id del empleado: ");
                    id=sc.nextInt();
                    sc.nextLine();
                    eD.eliminarEmpleado(id);
                    break;
                
                case 6:
                    break;
                    
                default:
                    System.out.println("orden inexistente");
                    break;
            }
            
        }while(opcion!=6);
        System.out.println("Fin del programa");
    }
    
}
