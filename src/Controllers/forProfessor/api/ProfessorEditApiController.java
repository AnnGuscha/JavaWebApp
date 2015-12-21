package Controllers.forProfessor.api;

import Entity.Professor;
import Services.ProfessorService;
import Services.ServiceLocator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anna on 12/9/2015.
 */
@WebServlet(
        name = "Controllers.forStudent.ProfessorEditApiController",
        urlPatterns = {"/api/professor_home/edit"}
)

public class ProfessorEditApiController extends HttpServlet {

    ProfessorService professorService = ServiceLocator.getProfessorService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //parse sanded student
        int id = Integer.parseInt(request.getParameter("idProfessor"));
        String name = request.getParameter("name");
        String surName = request.getParameter("surName");
        String patronymicName = request.getParameter("patronymicName");
        //dao/service update stud
        Professor professor = new Professor(id, name, surName, patronymicName);
        professorService.update(professor);
        //redirect

        response.sendRedirect("/professor_home");
    }

}

