package controllers.admin.api.ListStudents;

import entity.ListStudents;
import services.ListStudentsService;
import services.ServiceException;
import services.ServiceLocator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anna on 12/13/2015.
 */
@WebServlet(
        name = "ListStudentsEditApiController",
        urlPatterns = {"/api/admin/liststudents/edit"}
)

public class ListStudentsEditApiController extends HttpServlet {

    ListStudentsService listStudentsService = ServiceLocator.getListStudentsService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("idListStudents"));
        int idStudent = Integer.parseInt(request.getParameter("idStudent"));
        int idCourse = Integer.parseInt(request.getParameter("idCourse"));

        //choice model or entity
        ListStudents listStudents = new ListStudents(id, idCourse, idStudent);
        try {
            listStudentsService.update(listStudents);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/admin/liststudents");
    }
}