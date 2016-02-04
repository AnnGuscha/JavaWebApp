package controllers.admin.api.user;

import entity.User;
import services.ServiceException;
import services.ServiceLocator;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anna on 12/13/2015.
 */
@WebServlet(
        name = "UserEditApiController",
        urlPatterns = {"/api/admin/user/edit"}
)

public class UserEditApiController extends HttpServlet {

    UserService userService = ServiceLocator.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("idUser"));
        int role = Integer.parseInt(request.getParameter("role"));
        String password = request.getParameter("password");
        String locale = request.getParameter("locale");
        String login = request.getParameter("login");

        //choice model or entity
        User user = new User(id, login, password, role, locale);
        try {
            userService.update(user);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/admin/user");
    }
}