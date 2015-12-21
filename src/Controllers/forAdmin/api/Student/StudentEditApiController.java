package Controllers.forAdmin.api.Student;

import Entity.Student;
import Services.ServiceLocator;
import Services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anna on 12/9/2015.
 */
@WebServlet(
        name = "StudentEditApiController",
        urlPatterns = {"/api/student/edit"}
)

public class StudentEditApiController extends HttpServlet {

    StudentService studentService = ServiceLocator.getStudentService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //parse sanded student
        int id = Integer.parseInt(request.getParameter("idStudent"));
        String name = request.getParameter("name");
        String surName = request.getParameter("surName");
        String patronymicName = request.getParameter("patronymicName");
        //dao/service update stud
        Student newStudent = new Student(id, name, surName, patronymicName);
        studentService.update(newStudent);
        //redirect

        response.sendRedirect("/student");
    }

}

