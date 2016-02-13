package controllers.student.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.JQueryDataTableParamModel;
import dto.JsonDTO;
import manager.ManagerFactory;
import models.student.CourseModel;
import org.apache.log4j.Logger;
import services.ParticularService;
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
 * Created by Anna on 12/17/2015.
 */
@WebServlet(
        name = "StudentAllCoursesApiController",
        urlPatterns = {"/api/student/allcourses"}
)

public class StudentAllCoursesApiController extends HttpServlet {
    private static final Logger log = Logger.getLogger(StudentAllCoursesApiController.class);
    ParticularService particularService = ServiceLocator.getParticularService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = SessionUtil.getUserId(request);

        JQueryDataTableParamModel param = getRequestParam(request);

        List<CourseModel> courseList = null;
        try {
            int idStudent = ServiceLocator.getStudentService().findByUserId(userId).getId();
            courseList = particularService.getAllCourses(idStudent);
        } catch (ServiceException e) {
            log.error("Can not find entity",e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }

        String json = getJsonAll(param, courseList);

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

    private String getJsonAll(JQueryDataTableParamModel param, List<CourseModel> courseList) {

        int size = courseList.size();

        JsonDTO jsonDTO = new JsonDTO(param.sEcho, size, size, courseList);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        return gson.toJson(jsonDTO);
    }
}