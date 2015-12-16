package Controllers.forAdmin.api.ListStudents;

import Entity.ListStudents;
import Infrastructure.ListStudentsService;
import Infrastructure.ServiceLocator;

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
        name = "ListStudentsCreateApiController",
        urlPatterns = {"/api/liststudents/create"}
)

public class ListStudentsCreateApiController extends HttpServlet {

    ListStudentsService listStudentsService = ServiceLocator.getListStudentsService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idStudent = Integer.parseInt(request.getParameter("idStudent"));
        int idCourse = Integer.parseInt(request.getParameter("idCourse"));

        //choice model or entity
        ListStudents listStudents = new ListStudents(idCourse, idStudent);
        listStudentsService.insert(listStudents);

        response.sendRedirect("/liststudents");
    }
}
