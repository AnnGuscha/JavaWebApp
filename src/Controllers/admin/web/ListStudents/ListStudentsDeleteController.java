package controllers.admin.web.ListStudents;

import services.ListStudentsService;
import services.ServiceLocator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anna on 12/23/2015.
 */

@WebServlet(
        name = "ListStudentsDeleteController",
        urlPatterns = {"/admin/liststudents/delete/*"}
)

public class ListStudentsDeleteController extends HttpServlet {

    ListStudentsService listStudentsService = ServiceLocator.getListStudentsService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rawParam = request.getPathInfo();
        int idParam = Integer.parseInt(rawParam.split("/")[1]);

        listStudentsService.delete(idParam);
        response.sendRedirect("/admin/liststudents");
    }
}