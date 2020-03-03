package hw3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private final static String JDBC_URL = "jdbc:mysql://localhost:3306/library";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "Chervinskaya1997";

    public static Connection getConnection(){

        try {
            return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Can`t connect to BD");
        }
    }

}
