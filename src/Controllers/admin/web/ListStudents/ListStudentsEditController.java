package controllers.admin.web.ListStudents;

import entity.ListStudents;
import services.ListStudentsService;
import services.ServiceLocator;

import javax.servlet.RequestDispatcher;
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
        name = "ListStudentsEditController",
        urlPatterns = {"/admin/liststudents/edit/*"}
)

public class ListStudentsEditController extends HttpServlet {
    public static final String ADMIN_LISTSTUDENTS_EDIT_JSP = "/views/admin/liststudents/Edit.jsp";
    public static final String LIST_STUDENTS_ATTRIBUTE_NAME = "listStudents";
    ListStudentsService listStudentsService = ServiceLocator.getListStudentsService();

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String rawParam = request.getPathInfo();
        int idParam = Integer.parseInt(rawParam.split("/")[1]);

        //get object from dao
        ListStudents listStudents = listStudentsService.find(idParam);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADMIN_LISTSTUDENTS_EDIT_JSP);
        request.setAttribute(LIST_STUDENTS_ATTRIBUTE_NAME, listStudents);
        dispatcher.forward(request, resp);
    }
}