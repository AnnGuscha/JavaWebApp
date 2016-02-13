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
 * Created by Anna on 12/18/2015.
 */

@WebServlet(
        name = "StudentCoursesController",
        urlPatterns = {"/student/courses"}
)

public class StudentCoursesController extends HttpServlet {
    public static final String STUDENT_STUDENT_COURSES_JSP = "/views/student/StudentCourses.jsp";
    private static final Logger log = Logger.getLogger(StudentCoursesController.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(STUDENT_STUDENT_COURSES_JSP);
        dispatcher.forward(request, resp);
    }
}