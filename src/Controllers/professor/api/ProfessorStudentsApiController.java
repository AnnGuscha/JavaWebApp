package controllers.professor.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.JQueryDataTableParamModel;
import dto.JsonDTO;
import manager.ManagerFactory;
import models.professor.StudentsForProfessorModel;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Anna on 12/19/2015.
 */

@WebServlet(
        name = "ProfessorStudentsApiController",
        urlPatterns = {"/api/professor/students"}
)

public class ProfessorStudentsApiController extends HttpServlet {
    private static final Logger log = Logger.getLogger(ProfessorStudentsApiController.class);
    ParticularService particularService = ServiceLocator.getParticularService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int userId = 0;
        if (session.getAttribute("user") == null) {
            response.sendRedirect("/login");
        } else
            userId = Integer.parseInt(session.getAttribute("userId").toString());

        JQueryDataTableParamModel param = getRequestParam(request);
        List<StudentsForProfessorModel> studentList = null;
        int idProfessor = 0;
        try {
            idProfessor = ServiceLocator.getProfessorService().findByUserId(userId).getId();
            studentList = particularService.getStudentsByProfessor(idProfessor);
        } catch (ServiceException e) {
            log.error("Can not find entity", e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }

        String json = getJsonAll(param, studentList);

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

    private String getJsonAll(JQueryDataTableParamModel param, List<StudentsForProfessorModel> studentList) {

        //search
        String sSearch = param.sSearch;
        if (sSearch != null)
            studentList = studentList.stream().filter(item -> item.getName().toLowerCase().contains(sSearch.toLowerCase())).collect(Collectors.toList());

        //sorting
        int sortColumnIndex = param.iSortCol_0;
        String sortDirection = param.sSortDir_0;// asc or desc
        switch (sortColumnIndex) {
            case 0: {
                studentList = (studentList.stream().sorted((item1, item2) -> item1.getName().compareTo(item2.getName()))).collect(Collectors.toList());
            }
            break;
            case 1: {
                studentList = (studentList.stream().sorted((item1, item2) -> item1.getMark().compareTo(item2.getMark()))).collect(Collectors.toList());
            }
            break;
        }
        if (sortDirection == "desc") {
            Collections.reverse(studentList);
        }

        int size = studentList.size();

        JsonDTO jsonDTO = new JsonDTO(param.sEcho, size, size, studentList);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        return gson.toJson(jsonDTO);
    }
}