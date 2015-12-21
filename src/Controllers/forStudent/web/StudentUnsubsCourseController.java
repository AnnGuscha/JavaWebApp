package Controllers.forStudent.web;

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
 * Created by Anna on 12/18/2015.
 */

@WebServlet(
        name = "StudentUnsubsCourseController",
        urlPatterns = {"/student/unsubs/*"}
)

public class StudentUnsubsCourseController extends HttpServlet {
    ListStudentsService listStudentsService = ServiceLocator.getListStudentsService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rawParam = request.getPathInfo();
        int idParam = Integer.parseInt(rawParam.split("/")[1]);
        int idStudent = ServiceLocator.getIdCurrentUser();
        ListStudents listStudents = new ListStudents(idParam, idStudent);
        //get object from dao
        listStudentsService.delete(listStudents);
        //create model
        response.sendRedirect("/student_courses");
    }
}
