package Controllers.forProfessor.web;

import Entity.Professor;
import Services.ProfessorService;
import Services.ServiceLocator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anna on 12/16/2015.
 */
@WebServlet(
        name = "ProfessorHomeController",
        urlPatterns = {"/professor_home"}
)

public class ProfessorHomeController extends HttpServlet {
    ProfessorService professorService = ServiceLocator.getProfessorService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        Professor professor = professorService.find();

        String nextJSP = "/Views/forProfessor/ProfessorHome.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        request.setAttribute("professor", professor);
        dispatcher.forward(request, resp);
    }

}