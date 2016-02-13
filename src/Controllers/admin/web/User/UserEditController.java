package controllers.admin.web.user;

import entity.User;
import manager.ManagerFactory;
import org.apache.log4j.Logger;
import services.CourseService;
import services.ServiceException;
import services.ServiceLocator;
import services.UserService;
import util.SessionUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
    private static final Logger log = Logger.getLogger(UserEditController.class);
    UserService userService = ServiceLocator.getUserService();
    CourseService courseService = ServiceLocator.getCourseService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rawParam = request.getPathInfo();
        int idParam = Integer.parseInt(rawParam.split("/")[1]);

        //get object from dao
        User user = null;
        try {
            user = userService.find(idParam);
        } catch (ServiceException e) {
            log.error("Can not find entity",e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADMIN_USER_EDIT_JSP);
        request.setAttribute(USER_ATTRIBUTE_NAME, user);
        dispatcher.forward(request, response);
    }
}