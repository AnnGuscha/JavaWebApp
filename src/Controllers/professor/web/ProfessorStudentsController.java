package controllers.professor.web;

import models.professor.CourseModel;
import services.ServiceLocator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        HttpSession session = request.getSession();
        int userId = 0;
        if (session.getAttribute("userId") == null) {
            resp.sendRedirect("/login");
        } else
            userId = Integer.parseInt(session.getAttribute("userId").toString());
        int idProfessor = ServiceLocator.getProfessorService().findByUserId(userId).getId();

        CourseModel courseModel = ServiceLocator.getCourseService().getCourseModelForProfessor(idProfessor);
        request.setAttribute("courseModel", courseModel);
        String nextJSP = "/views/professor/ProfessorStudents.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, resp);
    }
}