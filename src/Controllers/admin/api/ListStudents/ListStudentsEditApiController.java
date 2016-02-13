package controllers.admin.api.listStudents;

import entity.ListStudents;
import manager.ManagerFactory;
import org.apache.log4j.Logger;
import services.ListStudentsService;
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

/**
 * Created by Anna on 12/13/2015.
 */
@WebServlet(
        name = "ListStudentsEditApiController",
        urlPatterns = {"/api/admin/liststudents/edit"}
)

public class ListStudentsEditApiController extends HttpServlet {
    private static final Logger log = Logger.getLogger(ListStudentsEditApiController.class);
    ListStudentsService listStudentsService = ServiceLocator.getListStudentsService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("idListStudents"));
        int idStudent = Integer.parseInt(request.getParameter("idStudent"));
        int idCourse = Integer.parseInt(request.getParameter("idCourse"));

        ListStudents listStudents = new ListStudents(id, idCourse, idStudent);
        try {
            listStudentsService.update(listStudents);
        } catch (ServiceException e) {
            log.error("Can not find entity",e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }
        response.sendRedirect("/admin/liststudents");
    }
}