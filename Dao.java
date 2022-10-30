import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Dao {
    public static void connectDB(){

        String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "password";
        try {
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            System.out.println("Successfully connected");

            connection.close();
        } catch (SQLException e) {
            System.out.println("error connecting to database");
            throw new RuntimeException(e);
        }
    }
}