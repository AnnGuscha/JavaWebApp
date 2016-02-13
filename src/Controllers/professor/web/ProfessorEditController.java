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
 * Created by Anna on 12/9/2015.
 */
@WebServlet(
        name = "controllers.professor.web.ProfessorEditController",
        urlPatterns = {"/professor/edit"}
)

public class ProfessorEditController extends HttpServlet {
    public static final String PROFESSOR_PROFESSOR_EDIT_JSP = "/views/professor/ProfessorEdit.jsp";
    public static final String PROFESSOR_ATTRIBUTE_NAME = "professor";
    private static final Logger log = Logger.getLogger(ProfessorEditController.class);
    ProfessorService professorService = ServiceLocator.getProfessorService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = SessionUtil.getUserId(request);
        //get object from dao
        Professor professor = null;
        try {
            professor = professorService.findByUserId(userId);
        } catch (ServiceException e) {
            log.error("Can not find entity",e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PROFESSOR_PROFESSOR_EDIT_JSP);
        request.setAttribute(PROFESSOR_ATTRIBUTE_NAME, professor);
        dispatcher.forward(request, response);
    }
}

