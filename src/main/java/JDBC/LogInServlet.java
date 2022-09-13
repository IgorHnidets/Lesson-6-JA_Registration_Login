package JDBC;

import JDBC.dao.impl.UserDaoImpl;
import JDBC.exceptions.IncorectCredentialException;
import JDBC.models.UserCredentials;
import JDBC.services.UserService;
import JDBC.services.impl.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LogInServlet extends HttpServlet {

    private final UserService userService;

    public LogInServlet(){
        userService = new UserServiceImpl(new UserDaoImpl());
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserCredentials userCredentials = new UserCredentials(req.getParameter("email"),req.getParameter("pass"));

        System.out.println(userCredentials);
        try {
            userService.login(userCredentials);
            resp.sendRedirect("index.jsp");
        } catch (IncorectCredentialException e) {
            e.printStackTrace();
            resp.sendRedirect("/login.jsp?error");
        }


    }
}
