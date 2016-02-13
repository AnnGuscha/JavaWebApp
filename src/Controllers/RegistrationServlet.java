package controllers;

import entity.Student;
import entity.User;
import manager.Locale;
import manager.Role;
import services.ServiceException;
import services.ServiceLocator;
import services.UserService;
import util.DefaultUtil;

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

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String pwd = request.getParameter("password");
        String locale = request.getParameter("locale");
        try {
            User user = userService.find(login);
            if (user == null) {
                user = new User(login, pwd, locale);
                userService.insert(user);
                user = userService.find(login, pwd);
                Student student = new Student();
                student.setUserId(user.getId());
                ServiceLocator.getStudentService().insert(student);
                HttpSession session = request.getSession();
                session.setAttribute("userId", user.getId());
                session.setAttribute("user", user.getLogin());
                session.putValue("role", Role.getRole(user.getRole()));
                session.putValue("locale", Locale.valueOf(user.getLocale().toUpperCase()));
                session.setMaxInactiveInterval(30 * 60);
                response.sendRedirect(DefaultUtil.getDefaultPage(user));
            } else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/Registration.jsp");
                PrintWriter out = response.getWriter();
                out.println("<font color=red>Enter another login.</font>");
                rd.include(request, response);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/Registration.jsp");
        rd.include(request, response);
    }
}