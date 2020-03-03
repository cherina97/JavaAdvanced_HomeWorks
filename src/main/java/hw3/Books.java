package hw3;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Books {

    private int id;
    private String title;
    private String description;
    private int price;
    private long isbn;
    private int category_id;

    public static Books of(ResultSet resultSet) throws SQLException {
        Books books = new Books();
        books.setId(resultSet.getInt("id"));
        books.setTitle(resultSet.getString("title"));
        books.setDescription(resultSet.getString("description"));
        books.setPrice(resultSet.getInt("price"));
        books.setIsbn((int) resultSet.getLong("isbn"));
        books.setCategory_id(resultSet.getInt("category_id"));

        return books;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", isbn=" + isbn +
                ", category_id=" + category_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
