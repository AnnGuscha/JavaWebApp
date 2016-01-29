package controllers.admin.web.Student;

import services.ServiceLocator;
import services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anna on 12/23/2015.
 */

@WebServlet(
        name = "StudentDeleteController",
        urlPatterns = {"/admin/student/delete/*"}
)

public class StudentDeleteController extends HttpServlet {

    StudentService studentService = ServiceLocator.getStudentService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rawParam = request.getPathInfo();
        int idParam = Integer.parseInt(rawParam.split("/")[1]);

        studentService.delete(idParam);
        response.sendRedirect("/admin/student");
    }
}