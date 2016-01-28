package controllers.admin.web.Professor;

import entity.Professor;
import services.ProfessorService;
import services.ServiceLocator;

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
        urlPatterns = {"/admin/professor/edit/*"}
)


public class ProfessorEditController extends HttpServlet {
    public static final String ADMIN_PROFESSOR_EDIT_JSP = "/views/admin/professor/Edit.jsp";
    public static final String PROFESSOR_ATTRIBUTE_NAME = "professor";
    ProfessorService professorService = ServiceLocator.getProfessorService();

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String rawParam = request.getPathInfo();
        int idParam = Integer.parseInt(rawParam.split("/")[1]);

        //get object from dao
        Professor professor = professorService.find(idParam);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADMIN_PROFESSOR_EDIT_JSP);
        request.setAttribute(PROFESSOR_ATTRIBUTE_NAME, professor);
        dispatcher.forward(request, resp);
    }
}