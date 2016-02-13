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
 * Created by Anna on 12/9/2015.
 */
@WebServlet(
        name = "controllers.student.web.StudentEditController",
        urlPatterns = {"/student/edit"}
)

public class StudentEditController extends HttpServlet {
    public static final String STUDENT_STUDENT_EDIT_JSP = "/views/student/StudentEdit.jsp";
    public static final String STUDENT_ATTRIBUTE_NAME = "student";
    private static final Logger log = Logger.getLogger(StudentEditController.class);
    StudentService studentService = ServiceLocator.getStudentService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = SessionUtil.getUserId(request);
        //get object from dao
        Student student = null;
        try {
            student = studentService.findByUserId(userId);
        } catch (ServiceException e) {
            log.error("Can not find entity",e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(STUDENT_STUDENT_EDIT_JSP);
        request.setAttribute(STUDENT_ATTRIBUTE_NAME, student);
        dispatcher.forward(request, response);
    }
}

