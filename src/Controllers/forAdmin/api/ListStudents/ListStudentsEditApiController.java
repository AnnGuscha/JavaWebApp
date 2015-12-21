package Controllers.forAdmin.api.ListStudents;

import Entity.ListStudents;
import Services.ListStudentsService;
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
        name = "ListStudentsEditApiController",
        urlPatterns = {"/api/liststudents/edit"}
)

public class ListStudentsEditApiController extends HttpServlet {

    ListStudentsService listStudentsService = ServiceLocator.getListStudentsService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("idListStudents"));
        int idStudent = Integer.parseInt(request.getParameter("idStudent"));
        int idCourse = Integer.parseInt(request.getParameter("idCourse"));

        //choice model or entity
        ListStudents listStudents = new ListStudents(id, idCourse, idStudent);
        listStudentsService.update(listStudents);

        response.sendRedirect("/liststudents");
    }
}