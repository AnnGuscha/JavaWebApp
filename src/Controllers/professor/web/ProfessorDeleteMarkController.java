package controllers.professor.web;

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
 * Created by Anna on 12/19/2015.
 */

@WebServlet(
        name = "ProfessorDeleteMarkController",
        urlPatterns = {"/professor/mark/delete"}
)

public class ProfessorDeleteMarkController extends HttpServlet {
    MarkService markService = ServiceLocator.getMarkService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idStudent = Integer.parseInt(request.getParameter("id"));
        int idCourse = Integer.parseInt(request.getParameter("course"));
        Mark mark = new Mark(idCourse, idStudent);
        //get object from dao
        markService.delete(mark);
        response.sendRedirect("/professor/students");
    }
}