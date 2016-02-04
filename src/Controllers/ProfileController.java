package controllers;

import entity.User;
import services.ServiceLocator;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Anna on 2/2/2016.
 */
@WebServlet(
        name = "ProfileController",
        urlPatterns = {"/profile"}
)
public class ProfileController extends HttpServlet {

    public static final String PROFILE_JSP = "/views/Profile.jsp";
    public static final String USER_ATTRIBUTE_NAME = "user";
    UserService userService = ServiceLocator.getUserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int userId = 0;
        if (session.getAttribute("user") == null) {
            resp.sendRedirect("/login");
        } else userId = Integer.parseInt(session.getAttribute("userId").toString());

        User user = userService.find(userId);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PROFILE_JSP);
        request.setAttribute(USER_ATTRIBUTE_NAME, user);
        dispatcher.forward(request, resp);
    }
}