package Controllers.forAdmin.api.Course;

import DTO.JQueryDataTableParamModel;
import DTO.JsonDTO;
import Entity.Course;
import Services.CourseService;
import Services.ServiceLocator;
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
 * Created by Anna on 12/13/2015.
 */
@WebServlet(
        name = "CourseApiController",
        urlPatterns = {"/api/course"}
)

public class CourseApiController extends HttpServlet {

    CourseService courseService = ServiceLocator.getCourseService();

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

        List<Course> courseList = courseService.getAll();

        int size = courseList.size();

        JsonDTO jsonDTO = new JsonDTO(param.sEcho, size, size, courseList);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        return gson.toJson(jsonDTO);
    }
}
