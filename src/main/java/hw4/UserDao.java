package hw4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private final static String JDBC_URL = "jdbc:mysql://localhost:3306/library";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "Chervinskaya1997";
    private static final String INSERT_INTO_USERS =
            "INSERT INTO users(first_name, last_name, email, password) VALUES (?, ?, ?, ?)";
    private static Connection connection;

    public void  insert(String firstName, String lastName, String email, String password) throws SQLException {
        connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        PreparedStatement preparedStatement =
                connection.prepareStatement(INSERT_INTO_USERS);
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, password);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

    public static User getUserByEmail (String email) throws SQLException {
        User user = new User();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user where email = ?");
        preparedStatement.setString(1, email);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            user.setFirstName(resultSet.getString(1));
            user.setLastName(resultSet.getString(2));
            user.setEmail(resultSet.getString(3));
            user.setPassword(resultSet.getString(4));
            user.setId(resultSet.getInt(5));
        }

        preparedStatement.close();
        connection.close();
        return user;
    }

//    public static int update (User user) throws SQLException {
//        PreparedStatement preparedStatement = connection.prepareStatement("update user set first_name = ?, " +
//                "last_name = ?, email = ?, password = ? where id = ?");
//        preparedStatement.setString(1, user.getFirstName());
//        preparedStatement.setString(2, user.getLastName());
//        preparedStatement.setString(3, user.getEmail());
//        preparedStatement.setString(4, user.getPassword());
//        preparedStatement.setInt(5, user.getId());
//        int executeUpdate = preparedStatement.executeUpdate();
//
//        connection.close();
//        return executeUpdate;
//    }
//
//    public static int deleteById (int id) throws SQLException {
//        PreparedStatement preparedStatement = connection.prepareStatement("delete from user where id = ?");
//        preparedStatement.setInt(1, id);
//        int executeUpdate = preparedStatement.executeUpdate();
//
//        connection.close();
//        return executeUpdate;
//    }
//

//
//    public static List<User> getAllUsers () throws SQLException {
//        List <User> users = new ArrayList<>();
//
//        PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
//        ResultSet resultSet = preparedStatement.executeQuery();
//        User user = new User();
//        while (resultSet.next()){
//            user.setFirstName(resultSet.getString(1));
//            user.setLastName(resultSet.getString(2));
//            user.setEmail(resultSet.getString(3));
//            user.setPassword(resultSet.getString(4));
//            user.setId(resultSet.getInt(5));
//            users.add(user);
//        }
//        connection.close();
//        return users;
//    }
}
