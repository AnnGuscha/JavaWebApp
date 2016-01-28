package controllers.admin.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anna on 12/20/2015.
 */

@WebServlet(
        name = "AdminController",
        urlPatterns = {"/admin/index"}
)

public class AdminController extends HttpServlet {

    public static final String ADMIN_INDEX_JSP = "/views/admin/index.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADMIN_INDEX_JSP);
        dispatcher.forward(request, resp);
    }
}
