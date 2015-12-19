package Controllers.forProfessor.web;

import Infrastructure.ParticularService;
import Infrastructure.ServiceLocator;
import Models.forProfessor.MarkModel;

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
        urlPatterns = {"/professor_home/edit_mark"}
)

public class ProfessorEditMarkController extends HttpServlet {

    ParticularService particularService = ServiceLocator.getParticularService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        int idStudent = Integer.parseInt(request.getParameter("id"));
        int idCourse = Integer.parseInt(request.getParameter("course"));
        //get object from dao
        MarkModel mark = particularService.findMark(idCourse, idStudent);
        //create model

        String nextJSP = "/Views/forProfessor/EditMark.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        request.setAttribute("mark", mark);
        dispatcher.forward(request, resp);
    }
}