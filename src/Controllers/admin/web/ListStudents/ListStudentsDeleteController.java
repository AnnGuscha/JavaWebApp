package controllers.admin.web.listStudents;

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
 * Created by Anna on 12/23/2015.
 */

@WebServlet(
        name = "ListStudentsDeleteController",
        urlPatterns = {"/admin/liststudents/delete/*"}
)

public class ListStudentsDeleteController extends HttpServlet {
    private static final Logger log = Logger.getLogger(ListStudentsDeleteController.class);
    ListStudentsService listStudentsService = ServiceLocator.getListStudentsService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rawParam = request.getPathInfo();
        int idParam = Integer.parseInt(rawParam.split("/")[1]);

        try {
            listStudentsService.delete(idParam);
        } catch (ServiceException e) {
            log.error("Can not delete entity", e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }
        response.sendRedirect("/admin/liststudents");
    }
}