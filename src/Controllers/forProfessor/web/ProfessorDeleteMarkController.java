package Controllers.forProfessor.web;

import Entity.Mark;
import Services.MarkService;
import Services.ServiceLocator;

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
        name = "ProfessorDeleteMarkController",
        urlPatterns = {"/professor_home/delete_mark"}
)

public class ProfessorDeleteMarkController extends HttpServlet {
    MarkService markService = ServiceLocator.getMarkService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idStudent = Integer.parseInt(request.getParameter("id"));
        int idCourse = Integer.parseInt(request.getParameter("course"));
        Mark mark = new Mark(idCourse, idStudent);
        //get object from dao
        markService.delete(mark);
        //create model
        response.sendRedirect("/professor_students");
    }
}