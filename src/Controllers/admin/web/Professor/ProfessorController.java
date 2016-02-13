package controllers.admin.web.professor;

import org.apache.log4j.Logger;

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
        name = "ProfessorController",
        urlPatterns = {"/admin/professor"}
)

public class ProfessorController extends HttpServlet {
    public static final String ADMIN_PROFESSOR_TABLE_JSP = "/views/admin/professor/Table.jsp";
    private static final Logger log = Logger.getLogger(ProfessorController.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADMIN_PROFESSOR_TABLE_JSP);
        dispatcher.forward(request, resp);
    }

}