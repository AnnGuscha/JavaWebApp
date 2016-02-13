package controllers.professor.api;

import entity.Professor;
import manager.ManagerFactory;
import org.apache.log4j.Logger;
import services.ProfessorService;
import services.ServiceException;
import services.ServiceLocator;
import util.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Anna on 12/9/2015.
 */
@WebServlet(
        name = "controllers.student.ProfessorEditApiController",
        urlPatterns = {"/api/professor/edit"}
)

public class ProfessorEditApiController extends HttpServlet {
    private static final Logger log = Logger.getLogger(ProfessorEditApiController.class);
    ProfessorService professorService = ServiceLocator.getProfessorService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int userId = 0;
        if (session.getAttribute("user") == null) {
            response.sendRedirect("/login");
        } else
            userId = Integer.parseInt(session.getAttribute("userId").toString());

        //parse sanded student
        int id = Integer.parseInt(request.getParameter("idProfessor"));
        String name = request.getParameter("name");
        String surName = request.getParameter("surName");
        String patronymicName = request.getParameter("patronymicName");
        //dao/service update stud
        Professor professor = new Professor(id, name, surName, patronymicName, userId);
        try {
            professorService.update(professor);
        } catch (ServiceException e) {
            log.error("Can not update entity", e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }
        //redirect

        response.sendRedirect("/professor");
    }

}

