package controllers.admin.web.Course;

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

/**
 * Created by Anna on 12/13/2015.
 */

@WebServlet(
        name = "CourseEditController",
        urlPatterns = {"/admin/course/edit/*"}
)


public class CourseEditController extends HttpServlet {
    public static final String COURSE_ATTRIBUTE_NAME = "course";
    public static final String ADMIN_COURSE_EDIT_JSP = "/views/admin/course/Edit.jsp";
    CourseService markService = ServiceLocator.getCourseService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        String rawParam = request.getPathInfo();
        int idParam = Integer.parseInt(rawParam.split("/")[1]);

        //get object from dao
        Course course = markService.find(idParam);

        //create model

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADMIN_COURSE_EDIT_JSP);
        request.setAttribute(COURSE_ATTRIBUTE_NAME, course);
        dispatcher.forward(request, resp);
    }
}