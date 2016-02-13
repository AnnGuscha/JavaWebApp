package controllers.admin.api.mark;

import entity.Mark;
import manager.ManagerFactory;
import org.apache.log4j.Logger;
import services.MarkService;
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
        name = "MarkCreateApiController",
        urlPatterns = {"/api/admin/mark/create"}
)

public class MarkCreateApiController extends HttpServlet {
    private static final Logger log = Logger.getLogger(MarkCreateApiController.class);
    MarkService markService = ServiceLocator.getMarkService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idCourse = Integer.parseInt(request.getParameter("idCourse"));
        int idStudent = Integer.parseInt(request.getParameter("idStudent"));
        String comment = request.getParameter("comment");

        //choice model or entity
        Mark newMark = new Mark(idCourse, idStudent, comment);
        try {
            markService.insert(newMark);
        } catch (ServiceException e) {
            log.error("Can not create entity", e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }

        response.sendRedirect("/admin/mark");
    }
}
