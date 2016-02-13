package controllers.professor.web;

import manager.ManagerFactory;
import models.professor.MarkModel;
import org.apache.log4j.Logger;
import services.ParticularService;
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
        name = "ProfessorEditMarkController",
        urlPatterns = {"/professor/mark/edit"}
)

public class ProfessorEditMarkController extends HttpServlet {
    public static final String PROFESSOR_EDIT_MARK_JSP = "/views/professor/EditMark.jsp";
    public static final String MARK_ATTRIBUTE_NAME = "mark";
    private static final Logger log = Logger.getLogger(ProfessorEditMarkController.class);
    ParticularService particularService = ServiceLocator.getParticularService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idStudent = Integer.parseInt(request.getParameter("id"));
        int idCourse = Integer.parseInt(request.getParameter("course"));
        //get object from dao
        MarkModel mark = null;
        try {
            mark = particularService.findMark(idCourse, idStudent);
        } catch (ServiceException e) {
            log.error("Can not find entity",e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }

        String nextJSP = PROFESSOR_EDIT_MARK_JSP;
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        request.setAttribute(MARK_ATTRIBUTE_NAME, mark);
        dispatcher.forward(request, response);
    }
}