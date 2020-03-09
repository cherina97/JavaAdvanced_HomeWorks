package hw4;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserDao userDao = new UserDao();

        Optional <User> user = userDao.getUserByEmail(email);
        if (!user.isPresent()){
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }
        User user1 = user.get();

        if (user1.getPassword().equals(password)){
            req.setAttribute("firstName", user1.getFirstName());
            req.setAttribute("lastName", user1.getLastName());
            req.getRequestDispatcher("cabinet.jsp").forward(req, resp);
        }

        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}

