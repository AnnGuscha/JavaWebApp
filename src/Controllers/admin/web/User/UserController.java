package controllers.admin.web.User;

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
        name = "UserController",
        urlPatterns = {"/admin/user"}
)

public class UserController extends HttpServlet {

    public static final String ADMIN_USER_TABLE_JSP = "/views/admin/user/Table.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADMIN_USER_TABLE_JSP);
        dispatcher.forward(request, resp);
    }

}