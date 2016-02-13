package controllers.professor.web;

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
 * Created by Anna on 12/19/2015.
 */

@WebServlet(
        name = "ProfessorDeleteMarkController",
        urlPatterns = {"/professor/mark/delete"}
)

public class ProfessorDeleteMarkController extends HttpServlet {
    private static final Logger log = Logger.getLogger(ProfessorDeleteMarkController.class);
    MarkService markService = ServiceLocator.getMarkService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idStudent = Integer.parseInt(request.getParameter("id"));
        int idCourse = Integer.parseInt(request.getParameter("course"));
        Mark mark = new Mark(idCourse, idStudent);
        //get object from dao
        try {
            markService.delete(mark);
        } catch (ServiceException e) {
            log.error("Can not delete entity", e);
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String message = ManagerFactory.getMessageManager(SessionUtil.getLocale(request)).getObject("error.app");
            out.println("<font color=red>" + message + "</font>");
        }
        response.sendRedirect("/professor/students");
    }
}