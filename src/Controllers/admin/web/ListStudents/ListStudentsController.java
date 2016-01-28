package controllers.admin.web.ListStudents;

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
        name = "ListStudentsController",
        urlPatterns = {"/admin/liststudents"}
)

public class ListStudentsController extends HttpServlet {

    public static final String ADMIN_LISTSTUDENTS_TABLE_JSP = "/views/admin/liststudents/Table.jsp";

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADMIN_LISTSTUDENTS_TABLE_JSP);
        dispatcher.forward(request, resp);
    }

}