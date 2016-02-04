package controllers;

import entity.User;
import manager.Locale;
import manager.ManagerFactory;
import services.ServiceException;
import services.ServiceLocator;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Anna on 2/2/2016.
 */
@WebServlet(
        name = "ProfileEditApiController",
        urlPatterns = {"/api/profile/edit"}
)
public class ProfileEditApiController extends HttpServlet {

    UserService userService = ServiceLocator.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        int role = Integer.parseInt(request.getParameter("role"));
        String password = request.getParameter("password");
        String locale = request.getParameter("locale");
        String login = request.getParameter("login");

        User user = new User(id, login, password, role, locale);
        try {
            userService.update(user);
            HttpSession session = request.getSession();
            session.putValue("locale", Locale.valueOf(user.getLocale().toUpperCase()));
        } catch (ServiceException e) {
            PrintWriter out = response.getWriter();
            out.println("<font color=red>"+ ManagerFactory.getMessageManager().getObject("error.app")+"</font>");
            e.printStackTrace();
        }

        response.sendRedirect("/profile");
    }
}