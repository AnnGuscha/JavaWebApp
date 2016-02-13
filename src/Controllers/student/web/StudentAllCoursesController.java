package controllers.student.web;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anna on 12/17/2015.
 */
@WebServlet(
        name = "StudentAllCoursesController",
        urlPatterns = {"/student/allcourses"}
)

public class StudentAllCoursesController extends HttpServlet {
    public static final String STUDENT_ALL_COURSES_JSP = "/views/student/AllCourses.jsp";
    private static final Logger log = Logger.getLogger(StudentAllCoursesController.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(STUDENT_ALL_COURSES_JSP);
        dispatcher.forward(request, resp);
    }
}
