package Controllers.forAdmin.api.Course;

import Entity.Course;
import Infrastructure.CourseService;
import Infrastructure.ServiceLocator;

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
        name = "CourseCreateApiController",
        urlPatterns = {"/api/course/create"}
)

public class CourseCreateApiController extends HttpServlet {

    CourseService courseService = ServiceLocator.getCourseService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idProfessor = Integer.parseInt(request.getParameter("idProfessor"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        //choice model or entity
        Course newCourse = new Course(name, idProfessor, description);
        courseService.insert(newCourse);

        response.sendRedirect("/course");
    }
}
