package Controllers.forAdmin.web.Mark;

import Entity.Course;
import Entity.Mark;
import Infrastructure.CourseService;
import Infrastructure.MarkService;
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
        name = "MarkEditController",
        urlPatterns = {"/mark/edit/*"}
)


public class MarkEditController extends HttpServlet {
    MarkService markService = ServiceLocator.getMarkService();
    CourseService courseService = ServiceLocator.getCourseService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String rawParam = request.getPathInfo();
        int idParam = Integer.parseInt(rawParam.split("/")[1]);

        //get object from dao
        Mark mark = markService.find(idParam);
        List<Course> listCourses = courseService.getAll();
        //create model

        String nextJSP = "/Views/forAdmin/Mark/Edit.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        request.setAttribute("mark", mark);
        request.setAttribute("listCourses", listCourses);
        dispatcher.forward(request, resp);
    }
}