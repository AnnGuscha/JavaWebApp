package controllers.admin.web.Student;

import entity.Student;
import services.ServiceLocator;
import services.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anna on 12/23/2015.
 */
@WebServlet(
        name = "StudentDetailsController",
        urlPatterns = {"/admin/student/details/*"}
)
public class StudentDetailsController extends HttpServlet {

    public static final String ADMIN_STUDENT_DETAILS_JSP = "/views/admin/student/Details.jsp";
    public static final String STUDENT_ATTRIBUTE_NAME = "student";
    StudentService studentService = ServiceLocator.getStudentService();

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String rawParam = request.getPathInfo();
        int idParam = Integer.parseInt(rawParam.split("/")[1]);

        //get object from dao
        Student student = studentService.find(idParam);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADMIN_STUDENT_DETAILS_JSP);
        request.setAttribute(STUDENT_ATTRIBUTE_NAME, student);
        dispatcher.forward(request, resp);
    }
}
