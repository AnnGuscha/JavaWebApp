package controllers.student.api;

import entity.ListStudents;
import services.ListStudentsService;
import services.ServiceLocator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Anna on 12/18/2015.
 */

@WebServlet(
        name = "StudentUnsubsCourseApiController",
        urlPatterns = {"/api/student/unsubs/*"}
)

public class StudentUnsubsCourseApiController extends HttpServlet {
    ListStudentsService listStudentsService = ServiceLocator.getListStudentsService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rawParam = request.getPathInfo();
        int idParam = Integer.parseInt(rawParam.split("/")[1]);
        HttpSession session = request.getSession();
        int userId = 0;
        if (session.getAttribute("user") == null) {
            response.sendRedirect("/login");
        } else
            userId = Integer.parseInt(session.getAttribute("userId").toString());
        int idStudent = ServiceLocator.getStudentService().findByUserId(userId).getId();
        ListStudents listStudents = new ListStudents(idParam, idStudent);
        //get object from dao
        listStudentsService.delete(listStudents);
        response.sendRedirect("/student/courses");
    }
}
