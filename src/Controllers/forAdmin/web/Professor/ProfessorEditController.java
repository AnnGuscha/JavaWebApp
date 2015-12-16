package Controllers.forAdmin.web.Professor;

import Entity.Professor;
import Infrastructure.ProfessorService;
import Infrastructure.ServiceLocator;

import javax.servlet.RequestDispatcher;
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
        name = "ProfessorEditController",
        urlPatterns = {"/professor/edit/*"}
)


public class ProfessorEditController extends HttpServlet {
    ProfessorService professorService = ServiceLocator.getProfessorService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String rawParam = request.getPathInfo();
        int idParam = Integer.parseInt(rawParam.split("/")[1]);

        //get object from dao
        Professor professor = professorService.find(idParam);
        //create model

        String nextJSP = "/Views/forAdmin/Professor/Edit.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        request.setAttribute("professor", professor);
        dispatcher.forward(request, resp);
    }
}