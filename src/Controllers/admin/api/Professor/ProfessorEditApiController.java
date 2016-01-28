package controllers.admin.api.Professor;

import entity.Professor;
import services.ProfessorService;
import services.ServiceLocator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anna on 12/13/2015.
 */
@WebServlet(
        name = "ProfessorEditApiController",
        urlPatterns = {"/api/admin/professor/edit"}
)

public class ProfessorEditApiController extends HttpServlet {

    ProfessorService professorService = ServiceLocator.getProfessorService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("idProfessor"));
        String firstName = request.getParameter("firstName");
        String surName = request.getParameter("surName");
        String patronymicName = request.getParameter("patronymicName");
        int userId = Integer.parseInt(request.getParameter("userId"));

        //choice model or entity
        Professor newProfessor = new Professor(id, firstName, surName, patronymicName, userId);
        professorService.update(newProfessor);

        response.sendRedirect("/admin/professor");
    }
}