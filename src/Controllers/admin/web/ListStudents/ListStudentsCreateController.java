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
import java.util.List;

/**
 * Created by Anna on 12/13/2015.
 */

@WebServlet(
        name = "ListStudentsCreateController",
        urlPatterns = {"/admin/liststudents/create"}
)

public class ListStudentsCreateController extends HttpServlet {

    public static final String STUDENTS_LIST_ATTRIBUTE_NAME = "studentsList";
    public static final String ADMIN_LISTSTUDENTS_CREATE_JSP = "/views/admin/liststudents/Create.jsp";
    ListStudentsService listStudentsService = ServiceLocator.getListStudentsService();

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        List<ListStudents> studentsList = listStudentsService.getAll();

        request.setAttribute(STUDENTS_LIST_ATTRIBUTE_NAME, studentsList);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADMIN_LISTSTUDENTS_CREATE_JSP);
        dispatcher.forward(request, resp);
    }
}