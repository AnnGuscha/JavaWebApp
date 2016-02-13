package controllers.admin.web.mark;

import entity.Course;
import manager.ManagerFactory;
import org.apache.log4j.Logger;
import services.CourseService;
import services.ServiceException;
import services.ServiceLocator;
import util.SessionUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
    private static final Logger log = Logger.getLogger(MarkCreateController.class);
    CourseService courseService = ServiceLocator.getCourseService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Course> listCourses = null;
        try {
            listCourses = courseService.getAll();
        } catch (ServiceException e) {
            log.error("Can not find entity",e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }

        request.setAttribute(LIST_COURSES_ATTRIBUTE_NAME, listCourses);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADMIN_MARK_CREATE_JSP);
        dispatcher.forward(request, response);
    }
}