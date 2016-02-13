package controllers.admin.api.user;

import entity.User;
import manager.ManagerFactory;
import org.apache.log4j.Logger;
import services.ServiceException;
import services.ServiceLocator;
import services.UserService;
import util.SessionUtil;

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
        name = "UserEditApiController",
        urlPatterns = {"/api/admin/user/edit"}
)

public class UserEditApiController extends HttpServlet {
    private static final Logger log = Logger.getLogger(UserEditApiController.class);
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
            log.error("Can not update entity", e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }

        response.sendRedirect("/admin/user");
    }
}