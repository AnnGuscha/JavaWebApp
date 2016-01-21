package Controllers;

import Commands.Role;
import Entity.User;
import Infrastructure.ServletRole;
import Services.ServiceLocator;
import Services.UserService;

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
 * Created by Anna on 12/20/2015.
 */

@WebServlet(
        name = "LoginServlet",
        urlPatterns = {"/login"}
)
@ServletRole(role = Role.Anonymous)
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserService userService = ServiceLocator.getUserService();

    private static String getDefaultPage(User user) {
        switch (Role.values()[user.getRole()]) {
            case Admin:
                return "/index";
            case Professor:
                return "/professor_home";
            case Student:
                return "/student_home";
            default:
                return "hello,jsp";
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        // get request parameters for userID and password
        String login = request.getParameter("login");
        String pwd = request.getParameter("password");
        User user = userService.find(login, pwd);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("userId", user.getId());
            session.setAttribute("user", user.getLogin());
            session.setAttribute("role", user.getRole());
            session.setMaxInactiveInterval(30 * 60);
//            Cookie loginCookie = new Cookie("user", login);
//            loginCookie.setMaxAge(30 * 60);
//            response.addCookie(loginCookie);
            response.sendRedirect(getDefaultPage(user));
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Views/Authentication.jsp");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Either login name or password is wrong.</font>");
            rd.include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/Views/Authentication.jsp");
        rd.include(request, response);
    }
}