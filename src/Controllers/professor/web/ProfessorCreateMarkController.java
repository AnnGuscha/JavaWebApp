package controllers.professor.web;

import entity.Course;
import entity.Student;
import services.ServiceLocator;

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
        urlPatterns = {"/professor/mark/create"}
)

public class ProfessorCreateMarkController extends HttpServlet {

    public static final String PROFESSOR_CREATE_MARK_JSP = "/views/professor/CreateMark.jsp";
    public static final String COURSE_ATTRIBUTE_NAME = "course";
    public static final String STUDENT_ATTRIBUTE_NAME = "student";

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        int idStudent = Integer.parseInt(request.getParameter("id"));
        int idCourse = Integer.parseInt(request.getParameter("course"));
        //get object from dao
        Student student = ServiceLocator.getStudentService().find(idStudent);
        Course course = ServiceLocator.getCourseService().find(idCourse);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PROFESSOR_CREATE_MARK_JSP);
        request.setAttribute(COURSE_ATTRIBUTE_NAME, course);
        request.setAttribute(STUDENT_ATTRIBUTE_NAME, student);
        dispatcher.forward(request, resp);

    }
}