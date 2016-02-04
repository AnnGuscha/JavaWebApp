package controllers.admin.api.Course;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.JQueryDataTableParamModel;
import dto.JsonDTO;
import entity.Course;
import services.CourseService;
import services.ServiceException;
import services.ServiceLocator;

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
        urlPatterns = {"/api/admin/course"}
)

public class CourseApiController extends HttpServlet {

    CourseService courseService = ServiceLocator.getCourseService();

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

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idProfessor = Integer.parseInt(request.getParameter("idProfessor"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        //choice model or entity
        Course newCourse = new Course(name, idProfessor, description);
        courseService.insert(newCourse);

        response.sendRedirect("/admin/course");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("_method").equals("put"))
            doPut(request, response);
        else {
            int id = Integer.parseInt(request.getParameter("idCourse"));
            int idProfessor = Integer.parseInt(request.getParameter("idProfessor"));
            String name = request.getParameter("name");
            String description = request.getParameter("description");

            //choice model or entity
            Course newCourse = new Course(id, name, idProfessor, description);
            try {
                courseService.update(newCourse);
            } catch (ServiceException e) {
                e.printStackTrace();
            }

            response.sendRedirect("/admin/course");
        }
    }
}
