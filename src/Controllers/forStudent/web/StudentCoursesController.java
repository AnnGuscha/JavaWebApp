package Controllers.forStudent.web;

import Services.ServiceLocator;
import Services.StudentService;

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
        urlPatterns = {"/student_courses"}
)

public class StudentCoursesController extends HttpServlet {
    StudentService studentService = ServiceLocator.getStudentService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        String nextJSP = "/Views/forStudent/StudentCourses.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, resp);
    }
}