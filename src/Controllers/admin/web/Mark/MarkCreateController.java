package controllers.admin.web.Mark;

import entity.Course;
import services.CourseService;
import services.ServiceLocator;

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
        urlPatterns = {"/admin/mark/create"}
)

public class MarkCreateController extends HttpServlet {

    public static final String ADMIN_MARK_CREATE_JSP = "/views/admin/mark/Create.jsp";
    public static final String LIST_COURSES_ATTRIBUTE_NAME = "listCourses";
    CourseService courseService = ServiceLocator.getCourseService();

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        List<Course> listCourses = courseService.getAll();

        request.setAttribute(LIST_COURSES_ATTRIBUTE_NAME, listCourses);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADMIN_MARK_CREATE_JSP);
        dispatcher.forward(request, resp);
    }
}