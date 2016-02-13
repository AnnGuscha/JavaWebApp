package controllers.admin.api.mark;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.JQueryDataTableParamModel;
import dto.JsonDTO;
import entity.Mark;
import manager.ManagerFactory;
import org.apache.log4j.Logger;
import services.MarkService;
import services.ServiceException;
import services.ServiceLocator;
import util.DataTableUtil;
import util.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(
        name = "MarkApiController",
        urlPatterns = {"/api/admin/mark"}
)

public class MarkApiController extends HttpServlet {
    private static final Logger log = Logger.getLogger(MarkApiController.class);
    MarkService markService = ServiceLocator.getMarkService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JQueryDataTableParamModel param = DataTableUtil.getRequestParam(request);
        List<Mark> markList = null;
        try {
            markList = markService.getAll();
            String json = getJsonAll(param, markList);
            responseJson(response, json);
        } catch (ServiceException e) {
            log.error("Can not find entity",e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }
    }

    private void responseJson(HttpServletResponse response, String json) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    private String getJsonAll(JQueryDataTableParamModel param, List<Mark> markList) {
        int size = markList.size();
        JsonDTO jsonDTO = new JsonDTO(param.sEcho, size, size, markList);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(jsonDTO);
    }
}
