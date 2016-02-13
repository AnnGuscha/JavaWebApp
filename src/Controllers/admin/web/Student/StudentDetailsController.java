package controllers.admin.web.student;

import entity.Student;
import manager.ManagerFactory;
import org.apache.log4j.Logger;
import services.ServiceException;
import services.ServiceLocator;
import services.StudentService;
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
 * Created by Anna on 12/23/2015.
 */
@WebServlet(
        name = "StudentDetailsController",
        urlPatterns = {"/admin/student/details/*"}
)
public class StudentDetailsController extends HttpServlet {
    public static final String ADMIN_STUDENT_DETAILS_JSP = "/views/admin/student/Details.jsp";
    public static final String STUDENT_ATTRIBUTE_NAME = "student";
    private static final Logger log = Logger.getLogger(StudentDetailsController.class);
    StudentService studentService = ServiceLocator.getStudentService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rawParam = request.getPathInfo();
        int idParam = Integer.parseInt(rawParam.split("/")[1]);

        //get object from dao
        Student student = null;
        try {
            student = studentService.find(idParam);
        } catch (ServiceException e) {
            log.error("Can not find entity",e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADMIN_STUDENT_DETAILS_JSP);
        request.setAttribute(STUDENT_ATTRIBUTE_NAME, student);
        dispatcher.forward(request, response);
    }
}
