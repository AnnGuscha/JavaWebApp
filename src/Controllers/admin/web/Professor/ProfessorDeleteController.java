package controllers.admin.web.Professor;

import services.ProfessorService;
import services.ServiceLocator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anna on 1/21/2016.
 */
@WebServlet(
        name = "ProfessorDeleteController",
        urlPatterns = {"/professor/delete/*"}
)

public class ProfessorDeleteController extends HttpServlet {

    ProfessorService professorService = ServiceLocator.getProfessorService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rawParam = request.getPathInfo();
        int idParam = Integer.parseInt(rawParam.split("/")[1]);

        professorService.delete(idParam);
        response.sendRedirect("/professor");
    }
}
