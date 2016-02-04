package controllers.admin.web.User;

import entity.User;
import services.CourseService;
import services.ServiceLocator;
import services.UserService;

import javax.servlet.RequestDispatcher;
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
        name = "UserEditController",
        urlPatterns = {"/admin/user/edit/*"}
)


public class UserEditController extends HttpServlet {

    public static final String ADMIN_USER_EDIT_JSP = "/views/admin/user/Edit.jsp";
    public static final String USER_ATTRIBUTE_NAME = "user";
    UserService userService = ServiceLocator.getUserService();
    CourseService courseService = ServiceLocator.getCourseService();

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String rawParam = request.getPathInfo();
        int idParam = Integer.parseInt(rawParam.split("/")[1]);

        //get object from dao
        User user = userService.find(idParam);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADMIN_USER_EDIT_JSP);
        request.setAttribute(USER_ATTRIBUTE_NAME, user);
        dispatcher.forward(request, resp);
    }
}