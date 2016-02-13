package controllers.admin.web.student;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anna on 12/9/2015.
 */
@WebServlet(
        name = "StudentController",
        urlPatterns = {"/admin/student"}
)

public class StudentController extends HttpServlet {
    public static final String ADMIN_STUDENT_TABLE_JSP = "/views/admin/student/Table.jsp";
    private static final Logger log = Logger.getLogger(StudentController.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADMIN_STUDENT_TABLE_JSP);
        dispatcher.forward(request, resp);
    }

}

