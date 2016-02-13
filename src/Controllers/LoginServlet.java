package controllers;

import entity.User;
import infrastructure.ServletRole;
import manager.Locale;
import manager.ManagerFactory;
import manager.Role;
import services.ServiceException;
import services.ServiceLocator;
import services.UserService;
import util.DefaultUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Anna on 12/20/2015.
 */

@WebServlet(
        name = "LoginServlet",
        urlPatterns = {"/login"}
)
@ServletRole(role = Role.ANONYMOUS)
public class LoginServlet extends HttpServlet {

    private UserService userService = ServiceLocator.getUserService();

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // get request parameters for userID and password
        String login = request.getParameter("login");
        String pwd = request.getParameter("password");
        try {
            User user = userService.find(login, pwd);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("userId", user.getId());
                session.setAttribute("user", user.getLogin());
                session.putValue("role", Role.getRole(user.getRole()));
                session.putValue("locale", Locale.valueOf(user.getLocale().toUpperCase()));
                if(request.getParameter("isRem")==null)
                    session.setMaxInactiveInterval(30 * 60);
//            Cookie loginCookie = new Cookie("user", login);
//            loginCookie.setMaxAge(30 * 60);
//            response.addCookie(loginCookie);
                response.sendRedirect(DefaultUtil.getDefaultPage(user));
            } else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/Authentication.jsp");
                PrintWriter out = response.getWriter();
                out.println("<font color=red>"+ ManagerFactory.getMessageManager().getObject("error.login")+"</font>");
                rd.include(request, response);
            }
        }catch (ServiceException e){
            PrintWriter out = response.getWriter();
            out.println("<font color=red>"+ManagerFactory.getMessageManager().getObject("error.app")+"</font>");
        }
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/Authentication.jsp");
        rd.include(request, response);
//        try {
//            User user = userService.find("admin", "1");
//            if (user != null) {
//                HttpSession session = request.getSession(true);
//                session.setAttribute("userId", user.getId());
//                session.setAttribute("user", user.getLogin());
//                session.putValue("role", Role.getRole(user.getRole()));
//                session.putValue("locale", Locale.valueOf(user.getLocale().toUpperCase()));
//                response.sendRedirect(DefaultUtil.getDefaultPage(user));
//            } else {
//                RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/Authentication.jsp");
//                PrintWriter out = response.getWriter();
//                out.println("<font color=red>"+ ManagerFactory.getMessageManager().getObject("error.login")+"</font>");
//                rd.include(request, response);
//            }
//        }catch (ServiceException e){
//            PrintWriter out = response.getWriter();
//            out.println("<font color=red>"+ManagerFactory.getMessageManager().getObject("error.app")+"</font>");
//        }
   }
}