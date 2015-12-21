package Controllers.forProfessor.web;

import Entity.Course;
import Entity.Student;
import Services.ServiceLocator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anna on 12/13/2015.
 */

@WebServlet(
        name = "ProfessorCreateMarkController",
        urlPatterns = {"/professor_home/create_mark"}
)

public class ProfessorCreateMarkController extends HttpServlet {

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        int idStudent = Integer.parseInt(request.getParameter("id"));
        int idCourse = Integer.parseInt(request.getParameter("course"));
        //get object from dao
        Student student = ServiceLocator.getStudentService().find(idStudent);
        Course course = ServiceLocator.getCourseService().find(idCourse);
        String nextJSP = "/Views/forProfessor/CreateMark.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        request.setAttribute("course", course);
        request.setAttribute("student", student);
        dispatcher.forward(request, resp);
    }
}