package controllers.admin.api.professor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.JQueryDataTableParamModel;
import dto.JsonDTO;
import entity.Professor;
import manager.ManagerFactory;
import org.apache.log4j.Logger;
import services.ProfessorService;
import services.ServiceException;
import services.ServiceLocator;
import util.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Anna on 12/13/2015.
 */
@WebServlet(
        name = "ProfessorApiController",
        urlPatterns = {"/api/admin/professor"}
)

public class ProfessorApiController extends HttpServlet {
    private static final Logger log = Logger.getLogger(ProfessorApiController.class);
    ProfessorService professorService = ServiceLocator.getProfessorService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JQueryDataTableParamModel param = getRequestParam(request);
        List<Professor> professorList = null;
        try {
            professorList = professorService.getAll();
            String json = getJsonAll(param, professorList);
            responseJson(response, json);
        } catch (ServiceException e) {
            log.error("Can not find entity", e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }
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

    private String getJsonAll(JQueryDataTableParamModel param, List<Professor> professorList) {

        int size = professorList.size();
        JsonDTO jsonDTO = new JsonDTO(param.sEcho, size, size, professorList);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(jsonDTO);
    }
}
