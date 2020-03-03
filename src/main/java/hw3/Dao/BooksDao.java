package hw3.Dao;

import hw3.Books;
import hw3.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BooksDao {

    private static Connection connection;
    public static final String SELECT_FROM_BOOKS = "SELECT * FROM books";

    public BooksDao() {
        this.connection = ConnectionUtil.getConnection();
    }

    public List<Books> getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_FROM_BOOKS);

        List <Books> booksList = new ArrayList<>();
        while (resultSet.next()){
            booksList.add(Books.of(resultSet));
        }
        return booksList;
    }
}
