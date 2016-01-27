package controllers.admin.web.Student;

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
        urlPatterns = {"/student"}
)

public class StudentController extends HttpServlet {
    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        String nextJSP = "/views/admin/student/Table.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, resp);
    }

}
