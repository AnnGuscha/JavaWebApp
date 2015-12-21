package Controllers.forAdmin.web.Professor;

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
import java.util.List;

/**
 * Created by Anna on 12/13/2015.
 */

@WebServlet(
        name = "ProfessorCreateController",
        urlPatterns = {"/professor/create"}
)

public class ProfessorCreateController extends HttpServlet {

    ProfessorService professorService = ServiceLocator.getProfessorService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        String nextJSP = "/Views/forAdmin/Professor/Create.jsp";
        List<Professor> professorList = professorService.getAll();

        request.setAttribute("professorList", professorList);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, resp);
    }
}