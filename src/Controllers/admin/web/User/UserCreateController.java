package controllers.admin.web.User;

import entity.User;
import services.ServiceLocator;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Anna on 12/13/2015.
 */

@WebServlet(
        name = "UserCreateController",
        urlPatterns = {"/admin/user/create"}
)

public class UserCreateController extends HttpServlet {

    public static final String ADMIN_USER_CREATE_JSP = "/views/admin/user/Create.jsp";
    public static final String LIST_USERS_ATTRIBUTE_NAME = "listUsers";
    UserService userService = ServiceLocator.getUserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = userService.getAll();

        request.setAttribute(LIST_USERS_ATTRIBUTE_NAME, users);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADMIN_USER_CREATE_JSP);
        dispatcher.forward(request, resp);
    }
}