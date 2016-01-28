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
        name = "ProfessorCreateApiController",
        urlPatterns = {"/api/admin/professor/create"}
)

public class ProfessorCreateApiController extends HttpServlet {

    ProfessorService professorService = ServiceLocator.getProfessorService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String surName = request.getParameter("surName");
        String patronymicName = request.getParameter("patronymicName");
        int userId = Integer.parseInt(request.getParameter("userId"));

        //choice model or entity
        Professor professor = new Professor(firstName, surName, patronymicName, userId);
        professorService.insert(professor);

        response.sendRedirect("/admin/professor");
    }
}
