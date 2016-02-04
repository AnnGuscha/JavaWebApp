package controllers.admin.api.Student;

import entity.Student;
import services.ServiceException;
import services.ServiceLocator;
import services.StudentService;

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
        urlPatterns = {"/api/admin/student/edit"}
)

public class StudentEditApiController extends HttpServlet {

    StudentService studentService = ServiceLocator.getStudentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //parse sanded student
        int id = Integer.parseInt(request.getParameter("idStudent"));
        String name = request.getParameter("name");
        String surName = request.getParameter("surName");
        String patronymicName = request.getParameter("patronymicName");
        int userId = Integer.parseInt(request.getParameter("userId"));
        //dao/service update stud
        Student newStudent = new Student(id, name, surName, patronymicName, userId);
        try {
            studentService.update(newStudent);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        //redirect

        response.sendRedirect("/admin/student");
    }

}

