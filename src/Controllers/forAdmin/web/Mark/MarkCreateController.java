package Controllers.forAdmin.web.Mark;

import Entity.Course;
import Infrastructure.CourseService;
import Infrastructure.ServiceLocator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Anna on 12/13/2015.
 */

@WebServlet(
        name = "MarkCreateController",
        urlPatterns = {"/mark/create"}
)

public class MarkCreateController extends HttpServlet {

    CourseService courseService = ServiceLocator.getCourseService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        String nextJSP = "/Views/forAdmin/Mark/Create.jsp";
        List<Course> listCourses = courseService.getAll();

        request.setAttribute("listCourses", listCourses);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, resp);
    }
}