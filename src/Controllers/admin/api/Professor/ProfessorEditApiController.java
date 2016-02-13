package controllers.admin.api.professor;

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
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Anna on 12/13/2015.
 */
@WebServlet(
        name = "ProfessorEditApiController",
        urlPatterns = {"/api/admin/professor/edit"}
)

public class ProfessorEditApiController extends HttpServlet {
    private static final Logger log = Logger.getLogger(ProfessorEditApiController.class);
    ProfessorService professorService = ServiceLocator.getProfessorService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("idProfessor"));
        String firstName = request.getParameter("firstName");
        String surName = request.getParameter("surName");
        String patronymicName = request.getParameter("patronymicName");
        int userId = Integer.parseInt(request.getParameter("userId"));

        //choice model or entity
        Professor newProfessor = new Professor(id, firstName, surName, patronymicName, userId);
        try {
            professorService.update(newProfessor);
        } catch (ServiceException e) {
            log.error("Can not find entity", e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }

        response.sendRedirect("/admin/professor");
    }
}