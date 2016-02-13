package controllers.student.web;

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
 * Created by Anna on 12/16/2015.
 */
@WebServlet(
        name = "StudentHomeController",
        urlPatterns = {"/student"}
)

public class StudentHomeController extends HttpServlet {
    public static final String STUDENT_STUDENT_HOME_JSP = "/views/student/StudentHome.jsp";
    public static final String STUDENT_ATTRIBUTE_NAME = "student";
    private static final Logger log = Logger.getLogger(StudentHomeController.class);
    StudentService studentService = ServiceLocator.getStudentService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = SessionUtil.getUserId(request);

        Student curStudent = null;
        try {
            curStudent = studentService.findByUserId(userId);
        } catch (ServiceException e) {
            log.error("Can not find entity",e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(STUDENT_STUDENT_HOME_JSP);
        request.setAttribute(STUDENT_ATTRIBUTE_NAME, curStudent);
        dispatcher.forward(request, response);
    }

}