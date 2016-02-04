package controllers.admin.api.user;

import entity.User;
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
        name = "UserCreateApiController",
        urlPatterns = {"/api/admin/user/create"}
)

public class UserCreateApiController extends HttpServlet {

    UserService userService = ServiceLocator.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int role = Integer.parseInt(request.getParameter("role"));
        String password = request.getParameter("password");
        String locale = request.getParameter("locale");
        String login = request.getParameter("login");

        //choice model or entity
        User user = new User(login, password, role, locale);
        userService.insert(user);

        response.sendRedirect("/admin/user");
    }
}
