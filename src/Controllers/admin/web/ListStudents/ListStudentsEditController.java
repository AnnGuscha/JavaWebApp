package controllers.admin.web.listStudents;

import entity.ListStudents;
import manager.ManagerFactory;
import org.apache.log4j.Logger;
import services.ListStudentsService;
import services.ServiceException;
import services.ServiceLocator;
import util.SessionUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
    private static final Logger log = Logger.getLogger(ListStudentsEditController.class);
    ListStudentsService listStudentsService = ServiceLocator.getListStudentsService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rawParam = request.getPathInfo();
        int idParam = Integer.parseInt(rawParam.split("/")[1]);

        //get object from dao
        ListStudents listStudents = null;
        try {
            listStudents = listStudentsService.find(idParam);
        } catch (ServiceException e) {
            log.error("Can not find entity",e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADMIN_LISTSTUDENTS_EDIT_JSP);
        request.setAttribute(LIST_STUDENTS_ATTRIBUTE_NAME, listStudents);
        dispatcher.forward(request, response);
    }
}