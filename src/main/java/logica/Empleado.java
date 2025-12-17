
package logica;

public class Empleado {
    
    private int id;
    private String userName;
    private String password;
    private String name;
    private String phone;
    private String departamento;

    public Empleado(String userName, String password, String name, String phone, String departamento) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.departamento = departamento;
    }
    
    public Empleado(String userName, String name, String phone, String departamento) {
        this.userName = userName;
        this.name = name;
        this.phone = phone;
        this.departamento = departamento;
    }
        public Empleado(int id,String userName, String name, String phone, String departamento) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.phone = phone;
        this.departamento = departamento;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", userName=" + userName +
                ", name=" + name + ", phone=" + phone + ", departamento=" + departamento + '}';
    }
    
}
