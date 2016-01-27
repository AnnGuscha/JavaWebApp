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
        urlPatterns = {"/professor/edit/*"}
)


public class ProfessorEditController extends HttpServlet {
    public static final String VIEWS_FOR_ADMIN_PROFESSOR_EDIT_JSP = "/views/admin/professor/Edit.jsp";
    public static final String PROFESSOR_ATTRIBUTE_NAME = "professor";
    ProfessorService professorService = ServiceLocator.getProfessorService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String rawParam = request.getPathInfo();
        int idParam = Integer.parseInt(rawParam.split("/")[1]);

        //get object from dao
        Professor professor = professorService.find(idParam);
        //create model

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(VIEWS_FOR_ADMIN_PROFESSOR_EDIT_JSP);
        request.setAttribute(PROFESSOR_ATTRIBUTE_NAME, professor);//professor attribute name
        dispatcher.forward(request, resp);
    }
}