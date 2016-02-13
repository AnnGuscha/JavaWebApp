package controllers.professor.web;

import entity.Course;
import entity.Student;
import manager.ManagerFactory;
import org.apache.log4j.Logger;
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
        name = "ProfessorCreateMarkController",
        urlPatterns = {"/professor/mark/create"}
)

public class ProfessorCreateMarkController extends HttpServlet {
    public static final String PROFESSOR_CREATE_MARK_JSP = "/views/professor/CreateMark.jsp";
    public static final String COURSE_ATTRIBUTE_NAME = "course";
    public static final String STUDENT_ATTRIBUTE_NAME = "student";
    private static final Logger log = Logger.getLogger(ProfessorCreateMarkController.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idStudent = Integer.parseInt(request.getParameter("id"));
        int idCourse = Integer.parseInt(request.getParameter("course"));
        //get object from dao
        Student student = null;
        Course course = null;
        try {
            course = ServiceLocator.getCourseService().find(idCourse);
            student = ServiceLocator.getStudentService().find(idStudent);
        } catch (ServiceException e) {
            log.error("Can not find entity",e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PROFESSOR_CREATE_MARK_JSP);
        request.setAttribute(COURSE_ATTRIBUTE_NAME, course);
        request.setAttribute(STUDENT_ATTRIBUTE_NAME, student);
        dispatcher.forward(request, response);

    }
}