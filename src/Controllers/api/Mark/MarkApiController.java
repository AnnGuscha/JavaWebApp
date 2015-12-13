package Controllers.api.Mark;

import DTO.JQueryDataTableParamModel;
import DTO.JsonDTO;
import Entity.Mark;
import Infrastructure.MarkService;
import Infrastructure.ServiceLocator;
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
        name = "MarkApiController",
        urlPatterns = {"/api/mark"}
)

public class MarkApiController extends HttpServlet {

    MarkService markService = ServiceLocator.getMarkService();

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
        List<Mark> markList = markService.getAll();
        int size = markList.size();
        JsonDTO jsonDTO = new JsonDTO(param.sEcho, size, size, markList);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(jsonDTO);
    }
}
