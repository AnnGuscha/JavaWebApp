package controllers.admin.api.student;

import entity.Student;
import manager.ManagerFactory;
import org.apache.log4j.Logger;
import services.ServiceException;
import services.ServiceLocator;
import services.StudentService;
import util.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Anna on 12/9/2015.
 */
@WebServlet(
        name = "StudentEditApiController",
        urlPatterns = {"/api/admin/student/edit"}
)

public class StudentEditApiController extends HttpServlet {
    private static final Logger log = Logger.getLogger(StudentEditApiController.class);
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
            log.error("Can not update entity", e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }
        //redirect
        response.sendRedirect("/admin/student");
    }

}

