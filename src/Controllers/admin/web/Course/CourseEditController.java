package controllers.admin.web.course;

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
    private static final Logger log = Logger.getLogger(CourseEditController.class);
    CourseService markService = ServiceLocator.getCourseService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String rawParam = request.getPathInfo();
        int idParam = Integer.parseInt(rawParam.split("/")[1]);

        //get object from dao
        Course course = null;
        try {
            course = markService.find(idParam);
        } catch (ServiceException e) {
            log.error("Can not find entity",e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADMIN_COURSE_EDIT_JSP);
        request.setAttribute(COURSE_ATTRIBUTE_NAME, course);
        dispatcher.forward(request, response);
    }
}