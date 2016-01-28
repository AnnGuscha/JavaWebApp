package controllers.admin.web.Course;

import services.CourseService;
import services.ServiceLocator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anna on 12/23/2015.
 */

@WebServlet(
        name = "CourseDeleteController",
        urlPatterns = {"/admin/course/delete/*"}
)

public class CourseDeleteController extends HttpServlet {

    CourseService courseService = ServiceLocator.getCourseService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rawParam = request.getPathInfo();
        int idParam = Integer.parseInt(rawParam.split("/")[1]);

        courseService.delete(idParam);
        response.sendRedirect("/admin/course");
    }
}