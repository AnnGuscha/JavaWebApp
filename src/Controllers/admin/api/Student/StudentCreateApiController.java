package controllers.admin.api.Student;

import entity.Student;
import services.ServiceLocator;
import services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anna on 12/12/2015.
 */
@WebServlet(
        name = "StudentCreateApiController",
        urlPatterns = {"/api/admin/student/create"}
)
public class StudentCreateApiController extends HttpServlet {

    StudentService studentService = ServiceLocator.getStudentService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surName = request.getParameter("surName");
        String patronymicName = request.getParameter("patronymicName");
        int userId = Integer.parseInt(request.getParameter("userId"));

        Student newStudent = new Student(name, surName, patronymicName, userId);

        studentService.insert(newStudent);

        response.sendRedirect("/admin/student");
    }
}
