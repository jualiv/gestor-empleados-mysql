
package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    
    
    public void insertarUsuario(Empleado empleado) throws SQLException{
        String sql = "INSERT INTO empleados (userName,password,name,phone,departamento) VALUES (?,?,?,?,?)";// evitar inyecciones SQL
        try (Connection con = ConexionDB.conectar()){
            PreparedStatement stmt = con.prepareStatement(sql);/* este objeto transforma el Sting en algo que pueda entender la BDD
            Ayuda a tener mejor proteccion y que no haya inyeccion. */
            stmt.setString(1,empleado.getUserName());
            stmt.setString(2,empleado.getPassword());
            stmt.setString(3,empleado.getName());
            stmt.setString(4,empleado.getPhone());
            stmt.setString(5,empleado.getDepartamento());
            
            stmt.executeUpdate(); // Ejecutar consultas INSERT,UPDATE,DELETE
            System.out.println("Empleado insertado correctame"); // mala practica
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public List<Empleado> mostrarEmpleados() throws SQLException{
        List <Empleado> empleados = new ArrayList <>();
        String sql = "SELECT id, userName, name, phone, departamento FROM empleados"; // no podemos mostrar contraseñas
        try(Connection con = ConexionDB.conectar()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql); //Objeto ResulSet es un objeto contenedor de los resultados de una consulta SQL.
            while(rs.next()){//Cursor que recorre las filas, hasta que no haya mas que devuelve FALSE. 
                int id=rs.getInt(1);// el indice 1 corresponde al id
                String userName=rs.getString(2); //userName
                String name=rs.getString(3);
                String phone=rs.getString(4);
                String departamento=rs.getString(5);
                empleados.add(new Empleado(id,userName,name, phone,departamento));
            }      
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return empleados;
    }
    
    public void modificarDatos(int id, String userName,String name,String phone,String departamento){
        String sqlSelect = "SELECT id FROM empleados WHERE id=?";
        String sqlUpdate = "UPDATE empleados SET userName = ?, name = ?, phone = ?, departamento=? WHERE id = ?";
        try (Connection con= ConexionDB.conectar()){
            PreparedStatement stm = con.prepareStatement(sqlSelect);
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            //hacemos la consulta y si encontramos un valor en el rs, quiere decir que rs.next = true. 
            if(rs.next()){

                PreparedStatement stmt = con.prepareStatement(sqlUpdate);

                stmt.setString(1,userName);
                stmt.setString(2,name);
                stmt.setString(3,phone);
                stmt.setString(4,departamento);
                stmt.setInt(5,id);

                stmt.executeUpdate();
                System.out.println("datos modificados al empleado, id: " + id);
            }
            else{
                System.out.println("No existe el empleado con id: "+ id);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void cambiarPassword (int id, String newPassword) throws SQLException{
        String sqlSelect = "SELECT id FROM empleados WHERE id=?";
        String sqlUpdate = "UPDATE empleados SET password = ? WHERE id = ?";
        try (Connection con= ConexionDB.conectar()){
            PreparedStatement stm = con.prepareStatement(sqlSelect);
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            //hacemos la consulta y si encontramos un valor en el rs, quiere decir que rs.next = true. 
            if(rs.next()){
                PreparedStatement stmt = con.prepareStatement(sqlUpdate);
                stmt.setString(1,newPassword);
                stmt.setInt(2,id);
                stmt.executeUpdate();
                System.out.println("contraseña cambiada al empleado, id: "+id);
            }
            else{
                System.out.println("No existe el empleado con id: "+ id);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void eliminarEmpleado(int id){
        String sqlSelect = "SELECT id FROM empleados WHERE id=?";
        String sqlUpdate = "DELETE FROM empleados WHERE id = ?";
        try (Connection con= ConexionDB.conectar()){
            PreparedStatement stm = con.prepareStatement(sqlSelect);
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            //hacemos la consulta y si encontramos un valor en el rs, quiere decir que rs.next = true. 
            if(rs.next()){
                PreparedStatement stmt = con.prepareStatement(sqlUpdate);
                stmt.setInt(1,id);
                stmt.executeUpdate();
                System.out.println("empleado con id: "+id+", eliminado.");
            }
            else{
                System.out.println("No existe el empleado con id: "+ id);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
