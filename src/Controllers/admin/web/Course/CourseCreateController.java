package controllers.admin.web.course;

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
        name = "CourseCreateController",
        urlPatterns = {"/admin/course/create"}
)

public class CourseCreateController extends HttpServlet {
    public static final String ADMIN_COURSE_CREATE_JSP = "/views/admin/course/Create.jsp";
    private static final Logger log = Logger.getLogger(CourseCreateController.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADMIN_COURSE_CREATE_JSP);
        dispatcher.forward(request, resp);
    }
}