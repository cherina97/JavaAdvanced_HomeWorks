package hw3;

import hw3.Dao.AuthorsDao;
import hw3.Dao.BooksDao;
import netscape.javascript.JSUtil;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        AuthorsDao authorsDao = new AuthorsDao();
        authorsDao.insert("Bredley", "Scooter", null, "LA");
        authorsDao.insert("Mike", "Karson", null, "USA");
        authorsDao.update("Pavlo", "Pavlo", null, "Russia", 3);
        authorsDao.delete("Mike");
        List<Authors> authorsList = authorsDao.getAll();
        for (int i = 0; i < authorsList.size(); i++) {
            System.out.println(authorsList.get(i));
        }

        System.out.println();
        BooksDao booksDao = new BooksDao();
        List<Books> booksList = booksDao.getAll();
        for (int i = 0; i < booksList.size(); i++) {
            System.out.println(booksList.get(i));
        }

    }
}
