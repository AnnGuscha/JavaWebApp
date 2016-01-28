package controllers.professor.web;

import models.professor.MarkModel;
import services.ParticularService;
import services.ServiceLocator;

import javax.servlet.RequestDispatcher;
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
        name = "ProfessorEditMarkController",
        urlPatterns = {"/professor/mark/edit"}
)

public class ProfessorEditMarkController extends HttpServlet {

    public static final String PROFESSOR_EDIT_MARK_JSP = "/views/professor/EditMark.jsp";
    public static final String MARK_ATTRIBUTE_NAME = "mark";
    ParticularService particularService = ServiceLocator.getParticularService();

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        int idStudent = Integer.parseInt(request.getParameter("id"));
        int idCourse = Integer.parseInt(request.getParameter("course"));
        //get object from dao
        MarkModel mark = particularService.findMark(idCourse, idStudent);

        String nextJSP = PROFESSOR_EDIT_MARK_JSP;
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        request.setAttribute(MARK_ATTRIBUTE_NAME, mark);
        dispatcher.forward(request, resp);
    }
}