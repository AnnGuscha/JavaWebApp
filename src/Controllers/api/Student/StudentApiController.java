package Controllers.api.Student;

import DTO.JQueryDataTableParamModel;
import DTO.JsonDTO;
import Entity.Student;
import Infrastructure.ServiceLocator;
import Infrastructure.StudentService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
    StudentService studentService = ServiceLocator.getStudentService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JQueryDataTableParamModel param = getRequestParam(request);

        String json = getJsonAll(param);

        responseJson(response, json);
    }

    private JQueryDataTableParamModel getRequestParam(HttpServletRequest request) {
        JQueryDataTableParamModel param = new JQueryDataTableParamModel();
        param.sEcho = (String) request.getAttribute("sEcho");
        param.iColumns = Integer.parseInt((String) request.getAttribute("iColumns"));
        param.iDisplayLength = Integer.parseInt((String) request.getAttribute("iDisplayLength"));
        param.iDisplayStart = Integer.parseInt((String) request.getAttribute("iDisplayStart"));
        param.iSortingCols = Integer.parseInt((String) request.getAttribute("iSortingCols"));
        param.sSearch = (String) request.getAttribute("sSearch");
        param.sColumns = (String) request.getAttribute("sColumns");
        return param;
    }

    private void responseJson(HttpServletResponse response, String json) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    private String getJsonAll(JQueryDataTableParamModel param) {
        List<Student> studentList = studentService.getAll();
        int size = studentList.size();
        JsonDTO jsonDTO = new JsonDTO(param.sEcho, size, size, studentList);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(jsonDTO);
    }
}

