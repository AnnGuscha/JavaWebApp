package Controllers.forProfessor.api;

import DTO.JQueryDataTableParamModel;
import DTO.JsonDTO;
import Infrastructure.ParticularService;
import Infrastructure.ServiceLocator;
import Models.forProfessor.StudentsForProfessorModel;
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
 * Created by Anna on 12/19/2015.
 */

@WebServlet(
        name = "ProfessorStudentsApiController",
        urlPatterns = {"/api/professor_students"}
)

public class ProfessorStudentsApiController extends HttpServlet {

    ParticularService particularService = ServiceLocator.getParticularService();

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

        List<StudentsForProfessorModel> studentList = particularService.getStudentsByProfessor();

        int size = studentList.size();

        JsonDTO jsonDTO = new JsonDTO(param.sEcho, size, size, studentList);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        return gson.toJson(jsonDTO);
    }
}