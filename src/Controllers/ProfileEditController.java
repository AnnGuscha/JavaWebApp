package controllers;

import controllers.professor.web.ProfessorEditController;
import entity.User;
import manager.ManagerFactory;
import org.apache.log4j.Logger;
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
 * Created by Anna on 2/2/2016.
 */
@WebServlet(
        name = "ProfileEditController",
        urlPatterns = {"/profile/edit"}
)
public class ProfileEditController extends HttpServlet {
    public static final String PROFILE_EDIT_JSP = "/views/ProfileEdit.jsp";
    public static final String USER_ATTRIBUTE_NAME = "user";
    private static final Logger log = Logger.getLogger(ProfessorEditController.class);
    UserService userService = ServiceLocator.getUserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = SessionUtil.getUserId(request);

        User user = null;
        try {
            user = userService.find(userId);
        } catch (ServiceException e) {
            log.error("Can not find entity",e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PROFILE_EDIT_JSP);
        request.setAttribute(USER_ATTRIBUTE_NAME, user);
        dispatcher.forward(request, response);
    }
}