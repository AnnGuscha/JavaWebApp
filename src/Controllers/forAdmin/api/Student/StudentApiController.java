package Controllers.forAdmin.api.Student;

import DTO.JQueryDataTableParamModel;
import DTO.JsonDTO;
import Entity.Student;
import Services.ServiceLocator;
import Services.StudentService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        JQueryDataTableParamModel param = new JQueryDataTableParamModel(request);
        return param;
    }

    private void responseJson(HttpServletResponse response, String json) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    private String getJsonAll(JQueryDataTableParamModel param) {

        List<Student> studentList = studentService.getAll();

        //filter

        //search
        String sSearch = param.sSearch;
        if (sSearch != null)
            studentList = studentList.stream().filter(item -> item.getName().toLowerCase().contains(sSearch) || item.getSurName().toLowerCase().contains(sSearch) || item.getPatronymicName().toLowerCase().contains(sSearch)).collect(Collectors.toList());

        //sorting
        int sortColumnIndex = param.iSortCol_0;
        String sortDirection = param.sSortDir_0;// asc or desc
        switch (sortColumnIndex) {
            case 0: {
                studentList = (studentList.stream().sorted((item1, item2) -> Integer.compare(item1.getId(), item2.getId()))).collect(Collectors.toList());
            }
            break;
            case 1: {
                studentList = (studentList.stream().sorted((item1, item2) -> item1.getName().compareTo(item2.getName()))).collect(Collectors.toList());
            }
            break;
            case 2: {
                studentList = (studentList.stream().sorted((item1, item2) -> item1.getSurName().compareTo(item2.getSurName()))).collect(Collectors.toList());
            }
            break;
            case 3: {
                studentList = (studentList.stream().sorted((item1, item2) -> item1.getPatronymicName().compareTo(item2.getPatronymicName()))).collect(Collectors.toList());
            }
            break;
        }
        if (sortDirection == "desc") {
            Collections.reverse(studentList);
        }

        int size = studentList.size();
        JsonDTO jsonDTO = new JsonDTO(param.sEcho, size, size, studentList);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        return gson.toJson(jsonDTO);
    }
}

