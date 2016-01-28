package controllers.student.web;

import entity.Student;
import services.ServiceLocator;
import services.StudentService;

import javax.servlet.RequestDispatcher;
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
        name = "controllers.student.web.StudentEditController",
        urlPatterns = {"/student/edit"}
)

public class StudentEditController extends HttpServlet {

    public static final String STUDENT_STUDENT_EDIT_JSP = "/views/student/StudentEdit.jsp";
    public static final String STUDENT_ATTRIBUTE_NAME = "student";
    StudentService studentService = ServiceLocator.getStudentService();
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int userId = 0;
        if (session.getAttribute("user") == null) {
            resp.sendRedirect("/login");
        } else
            userId = Integer.parseInt(session.getAttribute("userId").toString());
        //get object from dao
        Student student = studentService.find(userId);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(STUDENT_STUDENT_EDIT_JSP);
        request.setAttribute(STUDENT_ATTRIBUTE_NAME, student);
        dispatcher.forward(request, resp);
    }
}

