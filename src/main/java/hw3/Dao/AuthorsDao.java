package hw3.Dao;

import hw3.Authors;
import hw3.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorsDao {

    private Connection connection;
    public static final String SELECT_FROM_AUTHORS = "SELECT * FROM authors";
    public static final String INSERT_INTO_AUTHORS =
            "INSERT INTO authors (name_of_author, sername_of_author, email_of_author, adress) " +
                    "values (?, ?, ?, ?)";
    private static final String UPDATE_BY_ID = "update authors set name_of_author=?, sername_of_author = ?, " +
            "email_of_author = ?, adress = ? where id = ?";
    private static final String DELETE_BY_NAME = "delete from authors where name_of_author = ?";

    public AuthorsDao() {
        this.connection = ConnectionUtil.getConnection();
    }

    public List<Authors> getAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_FROM_AUTHORS);

            List<Authors> authors = new ArrayList<>();
            while (resultSet.next()) {
                authors.add(Authors.of(resultSet));
            }
            return authors;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Can`t create a Statement");
        }
    }

    public int insert(String name, String surname, String email, String address) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_AUTHORS,
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setObject(1, name);
        preparedStatement.setObject(2, surname);
        preparedStatement.setObject(3, email);
        preparedStatement.setObject(4, address);

        preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        generatedKeys.next();
        return generatedKeys.getInt(1);
    }

    public void update(String name, String surname, String email, String address, int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, surname);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, address);
        preparedStatement.setInt(5, id);
        preparedStatement.executeUpdate();
    }

    public void delete (String name) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_NAME);
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();
    }
}
