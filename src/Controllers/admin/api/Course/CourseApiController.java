package controllers.admin.api.course;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.JQueryDataTableParamModel;
import dto.JsonDTO;
import entity.Course;
import manager.ManagerFactory;
import org.apache.log4j.Logger;
import services.CourseService;
import services.ServiceException;
import services.ServiceLocator;
import util.RequestUtil;
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
        name = "CourseApiController",
        urlPatterns = {"/api/admin/course"}
)

public class CourseApiController extends HttpServlet {
    private static Logger Log = Logger.getLogger(CourseApiController.class.getName());
    CourseService courseService = ServiceLocator.getCourseService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JQueryDataTableParamModel param = getRequestParam(request);

        List<Course> courseList = null;
        try {
            courseList = courseService.getAll();
            String json = getJsonAll(param, courseList);
            responseJson(response, json);
        } catch (ServiceException e) {
            Log.error("Can not find entities",e);
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

    private String getJsonAll(JQueryDataTableParamModel param, List<Course> courseList) {

        int size = courseList.size();

        JsonDTO jsonDTO = new JsonDTO(param.sEcho, size, size, courseList);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        return gson.toJson(jsonDTO);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            courseService.insert(RequestUtil.getCourse(request));
            response.sendRedirect("/admin/course");
        } catch (ServiceException e) {
            Log.error("Can not create entities", e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("_method").equals("put"))
            doPut(request, response);
        else {
            try {
                courseService.update(RequestUtil.getCourse(request));
            } catch (ServiceException e) {
                Log.error("Can not update entities",e);
                e.printStackTrace();
                PrintWriter out = response.getWriter();
                String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
                out.println("<font color=red>" + message + "</font>");
            }
            response.sendRedirect("/admin/course");
        }
    }
}
