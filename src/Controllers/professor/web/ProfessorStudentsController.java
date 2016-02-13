package controllers.professor.web;

import manager.ManagerFactory;
import models.professor.CourseModel;
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
 * Created by Anna on 12/19/2015.
 */

@WebServlet(
        name = "ProfessorStudentsController",
        urlPatterns = {"/professor/students"}
)

public class ProfessorStudentsController extends HttpServlet {
    public static final String COURSE_MODEL_ATTRIBUTE_NAME = "courseModel";
    public static final String PROFESSOR_PROFESSOR_STUDENTS_JSP = "/views/professor/ProfessorStudents.jsp";
    private static final Logger log = Logger.getLogger(ProfessorStudentsController.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = SessionUtil.getUserId(request);

        CourseModel courseModel = null;
        try {
            int idProfessor = ServiceLocator.getProfessorService().findByUserId(userId).getId();
            courseModel = ServiceLocator.getCourseService().getCourseModelForProfessor(idProfessor);
        } catch (ServiceException e) {
            log.error("Can not find entity",e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }

        request.setAttribute(COURSE_MODEL_ATTRIBUTE_NAME, courseModel);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PROFESSOR_PROFESSOR_STUDENTS_JSP);
        dispatcher.forward(request, response);
    }
}