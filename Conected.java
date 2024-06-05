import java.sql.Connection;
import java.sql.DriverManager;

public class Conected {
    public static void main(String[] args) {
    System.out.println("HOLA!");
    connect();
}

public static void connect() {
    Connection conn = null;
    String driver="com.mysql.jdbc.Driver";
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("driver cargado con éxito");
        // Establecer la conexión con la base de datos
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema?useUnicode=true%useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");
        if (conn != null) {
            System.out.println("Conexión exitosa!");
        }
    } catch (Exception e) {
        System.out.println("Ha ocurrido un error: " + e.getMessage());
    } finally {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
}
