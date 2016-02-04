package controllers.admin.api.Mark;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.JQueryDataTableParamModel;
import dto.JsonDTO;
import entity.Mark;
import services.MarkService;
import services.ServiceLocator;
import util.DataTableUtil;

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
        urlPatterns = {"/api/admin/mark"}
)

public class MarkApiController extends HttpServlet {

    MarkService markService = ServiceLocator.getMarkService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JQueryDataTableParamModel param = DataTableUtil.getRequestParam(request);

        String json = getJsonAll(param);

        responseJson(response, json);
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
