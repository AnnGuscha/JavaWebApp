package Controllers.forAdmin.web.ListStudents;

import Entity.ListStudents;
import Services.ListStudentsService;
import Services.ServiceLocator;

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
        urlPatterns = {"/liststudents/edit/*"}
)

public class ListStudentsEditController extends HttpServlet {
    ListStudentsService listStudentsService = ServiceLocator.getListStudentsService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String rawParam = request.getPathInfo();
        int idParam = Integer.parseInt(rawParam.split("/")[1]);

        //get object from dao
        ListStudents listStudents = listStudentsService.find(idParam);
        //create model

        String nextJSP = "/Views/forAdmin/ListStudents/Edit.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        request.setAttribute("listStudents", listStudents);
        dispatcher.forward(request, resp);
    }
}