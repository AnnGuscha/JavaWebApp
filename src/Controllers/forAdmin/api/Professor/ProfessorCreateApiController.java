package Controllers.forAdmin.api.Professor;

import Entity.Professor;
import Infrastructure.ProfessorService;
import Infrastructure.ServiceLocator;

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
        urlPatterns = {"/api/professor/create"}
)

public class ProfessorCreateApiController extends HttpServlet {

    ProfessorService professorService = ServiceLocator.getProfessorService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String surName = request.getParameter("surName");
        String patronymicName = request.getParameter("patronymicName");

        //choice model or entity
        Professor professor = new Professor(firstName, surName, patronymicName);
        professorService.insert(professor);

        response.sendRedirect("/professor");
    }
}
