package controllers.professor.web;

import entity.Professor;
import manager.ManagerFactory;
import org.apache.log4j.Logger;
import services.ProfessorService;
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
 * Created by Anna on 12/16/2015.
 */
@WebServlet(
        name = "ProfessorHomeController",
        urlPatterns = {"/professor"}
)

public class ProfessorHomeController extends HttpServlet {
    public static final String PROFESSOR_PROFESSOR_HOME_JSP = "/views/professor/ProfessorHome.jsp";
    public static final String PROFESSOR_ATTRIBUTE_NAME = "professor";
    private static final Logger log = Logger.getLogger(ProfessorHomeController.class);
    ProfessorService professorService = ServiceLocator.getProfessorService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = SessionUtil.getUserId(request);

        Professor professor = null;
        try {
            professor = professorService.findByUserId(userId);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PROFESSOR_PROFESSOR_HOME_JSP);
            request.setAttribute(PROFESSOR_ATTRIBUTE_NAME, professor);
            dispatcher.forward(request, response);
        } catch (ServiceException e) {
            log.error("Can not find entity",e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }
    }
}