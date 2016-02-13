package controllers.admin.web.mark;

import org.apache.log4j.Logger;

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
        name = "MarkController",
        urlPatterns = {"/admin/mark"}
)

public class MarkController extends HttpServlet {
    public static final String ADMIN_MARK_TABLE_JSP = "/views/admin/mark/Table.jsp";
    private static final Logger log = Logger.getLogger(MarkController.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADMIN_MARK_TABLE_JSP);
        dispatcher.forward(request, resp);
    }

}