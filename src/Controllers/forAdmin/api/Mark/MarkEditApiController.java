package Controllers.forAdmin.api.Mark;

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
 * Created by Anna on 12/13/2015.
 */
@WebServlet(
        name = "MarkEditApiController",
        urlPatterns = {"/api/mark/edit"}
)

public class MarkEditApiController extends HttpServlet {

    MarkService markService = ServiceLocator.getMarkService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("idMark"));
        int idCourse = Integer.parseInt(request.getParameter("idCourse"));
        int idStudent = Integer.parseInt(request.getParameter("idStudent"));
        String comment = request.getParameter("comment");

        //choice model or entity
        Mark newMark = new Mark(id, idCourse, idStudent, comment);
        markService.update(newMark);

        response.sendRedirect("/mark");
    }
}