package Controllers.api;

import DTO.JsonDTO;
import Entity.Student;
import Infrastructure.ServiceLocator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import levelDAO.StudentDAO;

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
        name = "StudentApiController",
        urlPatterns = {"/api/student"}
)


public class StudentApiController extends HttpServlet {
    StudentDAO studentDAO = ServiceLocator.getFactory().getStudentDAO();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//create JQuerryDataTableParamDto

        String sEcho = getRequestParam(request);

        String json = getJsonAll(sEcho);

        responseJson(response, json);
    }

    private String getRequestParam(HttpServletRequest request) {
        return (String) request.getAttribute("sEcho");
    }

    private void responseJson(HttpServletResponse response, String json) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    private String getJsonAll(String sEcho) {
        List<Student> studentList = studentDAO.getAll();
        int size = studentList.size();
        JsonDTO jsonDTO = new JsonDTO(sEcho, size, size, studentList);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(jsonDTO);
    }


}

