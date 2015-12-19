package Controllers.forProfessor.web;

import Infrastructure.ServiceLocator;
import Models.forProfessor.CourseModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anna on 12/19/2015.
 */

@WebServlet(
        name = "ProfessorStudentsController",
        urlPatterns = {"/professor_students"}
)

public class ProfessorStudentsController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        CourseModel courseModel = ServiceLocator.getCourseService().getCourseModelForProfessor();
        request.setAttribute("courseModel", courseModel);
        String nextJSP = "/Views/forProfessor/ProfessorStudents.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, resp);
    }
}