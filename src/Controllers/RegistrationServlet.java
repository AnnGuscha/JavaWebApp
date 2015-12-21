package Controllers;

import Entity.User;
import Services.ServiceLocator;
import Services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Anna on 12/21/2015.
 */
@WebServlet(
        name = "RegistrationServlet",
        urlPatterns = {"/registr"}
)

public class RegistrationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserService userService = ServiceLocator.getUserService();

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        // get request parameters for userID and password
        String login = request.getParameter("login");
        String pwd = request.getParameter("password");
        User user = userService.find(login);
        if (user == null) {
            user = new User(login, pwd);
            userService.insert(user);
            Cookie loginCookie = new Cookie("user", login);
            //setting cookie to expiry in 30 mins
            loginCookie.setMaxAge(30 * 60);
            response.addCookie(loginCookie);
            response.sendRedirect("/index");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Views/Registration.jsp");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Enter another login.</font>");
            rd.include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/Views/Registration.jsp");
        rd.include(request, response);
    }
}