package hw4;

import java.sql.*;
import java.util.Optional;

public class UserDao {

    private Connection connection;
    private static final String insert_into_user =
            "insert into user (first_name, last_name, email, password) values (?, ?, ?, ?)";
    private static final String select_from_user =
            "select * from user WHERE email = ?";

    public void insert(String firstName, String lastName, String email, String password) throws SQLException {
        connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(insert_into_user);

        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, password);

        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    public Optional<User> getUserByEmail(String email) {
        connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(select_from_user);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            Optional <User> user = Optional.of(User.of(resultSet));

            connection.close();
            preparedStatement.close();
            resultSet.close();

            return user;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Can`t get a user my email");
        }
    }
}
