package hw4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static String JDBC = "jdbc:mysql://127.0.0.1:3306/library";
    private static String USERNAME = "root";
    private static String PASSWORD = "Chervinskaya1997";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(JDBC, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Can`t connect to DB");
        }
    }
}
