package controllers.admin.web.listStudents;

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
        name = "ListStudentsCreateController",
        urlPatterns = {"/admin/liststudents/create"}
)

public class ListStudentsCreateController extends HttpServlet {
    public static final String ADMIN_LISTSTUDENTS_CREATE_JSP = "/views/admin/liststudents/Create.jsp";
    private static final Logger log = Logger.getLogger(ListStudentsCreateController.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADMIN_LISTSTUDENTS_CREATE_JSP);
        dispatcher.forward(request, response);
    }
}