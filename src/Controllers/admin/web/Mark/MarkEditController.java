package controllers.admin.web.Mark;

import entity.Course;
import entity.Mark;
import services.CourseService;
import services.MarkService;
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
        name = "MarkEditController",
        urlPatterns = {"/admin/mark/edit/*"}
)


public class MarkEditController extends HttpServlet {

    public static final String ADMIN_MARK_EDIT_JSP = "/views/admin/mark/Edit.jsp";
    public static final String MARK_ATTRIBUTE_NAME = "mark";
    public static final String LIST_COURSES_ATTRIBUTE_NAME = "listCourses";
    MarkService markService = ServiceLocator.getMarkService();
    CourseService courseService = ServiceLocator.getCourseService();

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String rawParam = request.getPathInfo();
        int idParam = Integer.parseInt(rawParam.split("/")[1]);

        //get object from dao
        Mark mark = markService.find(idParam);
        List<Course> listCourses = courseService.getAll();

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADMIN_MARK_EDIT_JSP);
        request.setAttribute(MARK_ATTRIBUTE_NAME, mark);
        request.setAttribute(LIST_COURSES_ATTRIBUTE_NAME, listCourses);
        dispatcher.forward(request, resp);
    }
}