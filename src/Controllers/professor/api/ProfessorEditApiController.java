package controllers.professor.api;

import entity.Professor;
import services.ProfessorService;
import services.ServiceLocator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Anna on 12/9/2015.
 */
@WebServlet(
        name = "controllers.student.ProfessorEditApiController",
        urlPatterns = {"/api/professor/edit"}
)

public class ProfessorEditApiController extends HttpServlet {

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
        professorService.update(professor);
        //redirect

        response.sendRedirect("/professor");
    }

}

