package controllers.admin.web.User;

import services.ServiceLocator;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anna on 12/23/2015.
 */

@WebServlet(
        name = "UserDeleteController",
        urlPatterns = {"/admin/user/delete/*"}
)

public class UserDeleteController extends HttpServlet {

    UserService userService = ServiceLocator.getUserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rawParam = request.getPathInfo();
        int idParam = Integer.parseInt(rawParam.split("/")[1]);

        userService.delete(idParam);
        response.sendRedirect("/admin/user");
    }
}