package controllers.student.api;

import entity.Student;
import services.ServiceLocator;
import services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Anna on 12/9/2015.
 */
@WebServlet(
        name = "controllers.student.api.StudentEditApiController",
        urlPatterns = {"/api/student/edit"}
)

public class StudentEditApiController extends HttpServlet {

    StudentService studentService = ServiceLocator.getStudentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int userId = 0;
        if (session.getAttribute("user") == null) {
            response.sendRedirect("/login");
        } else
            userId = Integer.parseInt(session.getAttribute("userId").toString());
        //parse sanded student
        int id = Integer.parseInt(request.getParameter("idStudent"));
        String name = request.getParameter("name");
        String surName = request.getParameter("surName");
        String patronymicName = request.getParameter("patronymicName");
        //service update student
        Student newStudent = new Student(id, name, surName, patronymicName, userId);
        studentService.update(newStudent);

        response.sendRedirect("/student");
    }

}

