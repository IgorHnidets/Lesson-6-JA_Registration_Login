package JDBC;

import JDBC.dao.impl.UserDaoImpl;
import JDBC.entiti.User;
import JDBC.services.UserService;
import JDBC.services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService;
    public RegistrationServlet() {
       userService =  new UserServiceImpl(new UserDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");

        User user = new User(first_name,last_name,email,pass);
        System.out.println(user);
        userService.save(user);

        resp.sendRedirect("login.jsp");


    }

}

