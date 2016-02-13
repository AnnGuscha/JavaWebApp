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
 * Created by Anna on 12/12/2015.
 */
@WebServlet(
        name = "StudentCreateApiController",
        urlPatterns = {"/api/admin/student/create"}
)
public class StudentCreateApiController extends HttpServlet {

    private static final Logger log = Logger.getLogger(StudentCreateApiController.class);
    StudentService studentService = ServiceLocator.getStudentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surName = request.getParameter("surName");
        String patronymicName = request.getParameter("patronymicName");
        int userId = Integer.parseInt(request.getParameter("userId"));

        Student newStudent = new Student(name, surName, patronymicName, userId);

        try {
            studentService.insert(newStudent);
        } catch (ServiceException e) {
            log.error("Can not insert entity",e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }

        response.sendRedirect("/admin/student");
    }
}
