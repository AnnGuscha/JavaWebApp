package controllers.professor.web;

import entity.Professor;
import services.ProfessorService;
import services.ServiceLocator;

import javax.servlet.RequestDispatcher;
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
        name = "controllers.professor.web.ProfessorEditController",
        urlPatterns = {"/professor/edit"}
)

public class ProfessorEditController extends HttpServlet {

    public static final String PROFESSOR_PROFESSOR_EDIT_JSP = "/views/professor/ProfessorEdit.jsp";
    public static final String PROFESSOR_ATTRIBUTE_NAME = "professor";
    ProfessorService professorService = ServiceLocator.getProfessorService();

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int userId = 0;
        if (session.getAttribute("userId") == null) {
            resp.sendRedirect("/login");
        } else
            userId = Integer.parseInt(session.getAttribute("userId").toString());
        //get object from dao
        Professor professor = professorService.findByUserId(userId);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PROFESSOR_PROFESSOR_EDIT_JSP);
        request.setAttribute(PROFESSOR_ATTRIBUTE_NAME, professor);
        dispatcher.forward(request, resp);
    }
}

