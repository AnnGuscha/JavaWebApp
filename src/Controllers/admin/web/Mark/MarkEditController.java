package controllers.admin.web.mark;

import entity.Course;
import entity.Mark;
import manager.ManagerFactory;
import org.apache.log4j.Logger;
import services.CourseService;
import services.MarkService;
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
        name = "MarkEditController",
        urlPatterns = {"/admin/mark/edit/*"}
)


public class MarkEditController extends HttpServlet {
    public static final String ADMIN_MARK_EDIT_JSP = "/views/admin/mark/Edit.jsp";
    public static final String MARK_ATTRIBUTE_NAME = "mark";
    public static final String LIST_COURSES_ATTRIBUTE_NAME = "listCourses";
    private static final Logger log = Logger.getLogger(MarkEditController.class);
    MarkService markService = ServiceLocator.getMarkService();
    CourseService courseService = ServiceLocator.getCourseService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rawParam = request.getPathInfo();
        int idParam = Integer.parseInt(rawParam.split("/")[1]);

        //get object from dao
        Mark mark = null;
        List<Course> listCourses=null;
        try {
            mark = markService.find(idParam);
            listCourses = courseService.getAll();
        } catch (ServiceException e) {
            log.error("Can not find entity",e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADMIN_MARK_EDIT_JSP);
        request.setAttribute(MARK_ATTRIBUTE_NAME, mark);
        request.setAttribute(LIST_COURSES_ATTRIBUTE_NAME, listCourses);
        dispatcher.forward(request, response);
    }
}