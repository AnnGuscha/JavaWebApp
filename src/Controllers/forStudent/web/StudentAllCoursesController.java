package Controllers.forStudent.web;

import Infrastructure.ServiceLocator;
import Infrastructure.StudentService;

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
        urlPatterns = {"/student_allcourses"}
)

public class StudentAllCoursesController extends HttpServlet {
    StudentService studentService = ServiceLocator.getStudentService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        String nextJSP = "/Views/forStudent/AllCourses.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, resp);
    }

}
