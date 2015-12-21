package Controllers.forAdmin.web.Student;

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
 * Created by Anna on 12/9/2015.
 */
@WebServlet(
        name = "StudentEditController",
        urlPatterns = {"/student/edit/*"}
)

public class StudentEditController extends HttpServlet {

    StudentService studentService = ServiceLocator.getStudentService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String rawParam = request.getPathInfo();
        int idParam = Integer.parseInt(rawParam.split("/")[1]);

        //get object from dao
        Student student = studentService.find(idParam);
        //create model

        String nextJSP = "/Views/forAdmin/Student/Edit.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        request.setAttribute("student", student);
        dispatcher.forward(request, resp);
    }
}

