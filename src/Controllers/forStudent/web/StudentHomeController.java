package Controllers.forStudent.web;

import Entity.Student;
import Services.ServiceLocator;
import Services.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anna on 12/16/2015.
 */
@WebServlet(
        name = "StudentHomeController",
        urlPatterns = {"/student_home"}
)

public class StudentHomeController extends HttpServlet {
    StudentService studentService = ServiceLocator.getStudentService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        int id = ServiceLocator.getIdCurrentUser();
        Student curStudent = studentService.find(id);

        String nextJSP = "/Views/forStudent/StudentHome.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        request.setAttribute("student", curStudent);
        dispatcher.forward(request, resp);
    }

}