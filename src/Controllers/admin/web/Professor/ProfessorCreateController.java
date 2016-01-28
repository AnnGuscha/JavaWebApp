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
import java.util.List;

/**
 * Created by Anna on 12/13/2015.
 */

@WebServlet(
        name = "ProfessorCreateController",
        urlPatterns = {"/admin/professor/create"}
)

public class ProfessorCreateController extends HttpServlet {

    public static final String PROFESSORS_ATTRIBUTE_NAME = "professorList";
    public static final String ADMIN_PROFESSOR_CREATE_JSP = "/views/admin/professor/Create.jsp";
    ProfessorService professorService = ServiceLocator.getProfessorService();

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        List<Professor> professorList = professorService.getAll();

        request.setAttribute(PROFESSORS_ATTRIBUTE_NAME, professorList);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADMIN_PROFESSOR_CREATE_JSP);
        dispatcher.forward(request, resp);
    }
}