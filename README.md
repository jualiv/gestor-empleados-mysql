<div align="center">

**Gestor Empleados JDBC MySQL**  
*Java + MySQL + JDBC*

[![GitHub](https://img.shields.io/badge/GitHub-jualiv-181717?logo=github)](https://github.com/jualiv)

</div>

## 📋 Descripción

Aplicación Java de consola para la gestión de empleados con base de datos MySQL mediante JDBC. Implementa operaciones **CRUD** completas (Crear, Leer, Actualizar, Eliminar) sobre la tabla `empleados`.

### ✨ Características
- ✅ Conexión a MySQL con JDBC
- ✅ Operaciones CRUD completas
- ✅ Gestión de empleados desde consola
- ✅ Manejo de errores SQL
- ✅ Código limpio y documentado

### 🛠️ Tecnologías
Java 21+ | JDBC | MySQL | XAMPP

### 📁 Estructura del proyecto
gestor-empleados-jdbc-mysql/
├── README.md
├── src/
│ └── main/
│ └── java/
│ └── GestorEmpleadosApp.java

### 🚀 Uso rápido

1. **Configura XAMPP** y arranca Apache + MySQL
2. **Crea la base de datos**:
CREATE DATABASE gestor_empleados;
USE gestor_empleados;

CREATE TABLE empleados (
id INT AUTO_INCREMENT PRIMARY KEY,
userName VARCHAR(20),
password VARCHAR(20),
name VARCHAR(25),
phone VARCHAR(20),
departamento VARCHAR(30)
);

3. **Configura la conexión** en el código (usuario/contraseña de MySQL)
4. **Ejecuta** `Main.java` o la clase principal
5. **Usa el menú** de consola para gestionar empleados

### 📊 Operaciones CRUD implementadas
- **C**rear: `INSERT INTO empleados`
- **R**ead: `SELECT * FROM empleados`
- **U**pdate: `UPDATE empleados`
- **D**elete: `DELETE FROM empleados`

### 📝 Ejemplo de uso
Listar empleados

Crear empleado

Actualizar empleado

Eliminar empleado

Salir

---

**👨‍💻 Desarrollado por [Ivan Juárez](https://github.com/jualiv)**  
