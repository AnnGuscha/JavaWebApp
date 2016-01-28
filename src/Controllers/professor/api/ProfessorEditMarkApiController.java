package controllers.professor.api;

import entity.Mark;
import services.MarkService;
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
        name = "ProfessorEditMarkApiController",
        urlPatterns = {"/api/professor/mark/edit"}
)

public class ProfessorEditMarkApiController extends HttpServlet {

    MarkService markService = ServiceLocator.getMarkService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("idMark"));
        int idCourse = Integer.parseInt(request.getParameter("idCourse"));
        int idStudent = Integer.parseInt(request.getParameter("idStudent"));
        String comment = request.getParameter("comment");

        //choice model or entity
        Mark newMark = new Mark(id, idCourse, idStudent, comment);
        markService.update(newMark);

        response.sendRedirect("/professor/students");
    }
}