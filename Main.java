import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        System.out.println("HOLA!");
        connect();
    }

    public static void connect() {
        Connection connection = null;
        try {
            // Cargar explícitamente el controlador MySQL (opcional)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Configuración de la conexión a la base de datos
            String url = "jdbc:mysql://localhost:3306/sistema";
            String username = "root";
            String password = "1234";

            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexión exitosaaaa!");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
