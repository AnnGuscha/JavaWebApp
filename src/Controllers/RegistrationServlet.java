package controllers;

import commands.Role;
import entity.User;
import services.ServiceLocator;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    private static String getDefaultPage(User user) {
        switch (Role.values()[user.getRole()]) {
            case ADMIN:
                return "/admin/index";
            case PROFESSOR:
                return "/professor";
            case STUDENT:
                return "/student";
            default:
                return "hello.jsp";
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String pwd = request.getParameter("password");
        User user = userService.find(login);
        if (user == null) {
            user = new User(login, pwd);
            userService.insert(user);
            HttpSession session = request.getSession();
            session.setAttribute("userId", user.getId());
            session.setAttribute("user", user.getLogin());
            session.setAttribute("role", user.getRole());
            session.setMaxInactiveInterval(30 * 60);
            response.sendRedirect(getDefaultPage(user));
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/Registration.jsp");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Enter another login.</font>");
            rd.include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/Registration.jsp");
        rd.include(request, response);
    }
}