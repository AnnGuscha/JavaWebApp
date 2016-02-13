package controllers.admin.api.user;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.JQueryDataTableParamModel;
import dto.JsonDTO;
import entity.User;
import manager.ManagerFactory;
import org.apache.log4j.Logger;
import services.ServiceException;
import services.ServiceLocator;
import services.UserService;
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

/**
 * Created by Anna on 12/13/2015.
 */
@WebServlet(
        name = "UserApiController",
        urlPatterns = {"/api/admin/user"}
)

public class UserApiController extends HttpServlet {
    private static final Logger log = Logger.getLogger(UserApiController.class);
    UserService userService = ServiceLocator.getUserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JQueryDataTableParamModel param = DataTableUtil.getRequestParam(request);

        List<User> userList = null;
        try {
            userList = userService.getAll();
            String json = getJsonAll(param, userList);
            responseJson(response, json);
        } catch (ServiceException e) {
            log.error("Can not find entity", e);
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

    private String getJsonAll(JQueryDataTableParamModel param, List<User> userList) {
        int size = userList.size();
        JsonDTO jsonDTO = new JsonDTO(param.sEcho, size, size, userList);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(jsonDTO);
    }
}
