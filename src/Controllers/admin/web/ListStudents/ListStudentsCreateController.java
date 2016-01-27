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
        urlPatterns = {"/liststudents/create"}
)

public class ListStudentsCreateController extends HttpServlet {

    ListStudentsService listStudentsService = ServiceLocator.getListStudentsService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        String nextJSP = "/views/admin/liststudents/Create.jsp";
        List<ListStudents> studentsList = listStudentsService.getAll();

        request.setAttribute("studentsList", studentsList);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, resp);
    }
}