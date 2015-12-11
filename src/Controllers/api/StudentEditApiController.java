package Controllers.api;

import DTO.JsonDTO;
import Entity.Student;
import Infrastructure.ServiceLocator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import levelDAO.StudentDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Anna on 12/9/2015.
 */
@WebServlet(
        name = "StudentEditApiController",
        urlPatterns = {"/api/student/edit"}
)


public class StudentEditApiController extends HttpServlet {
    StudentDAO studentDAO = ServiceLocator.getFactory().getStudentDAO();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //parse sanded student
        //dao/service update stud
        //redirect

        response.sendRedirect("/student");
    }

}

