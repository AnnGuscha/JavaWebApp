package Controllers.api.Mark;

import Entity.Mark;
import Infrastructure.MarkService;
import Infrastructure.ServiceLocator;
import Models.MarkModel;

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
        name = "MarkCreateApiController",
        urlPatterns = {"/api/mark/create"}
)

public class MarkCreateApiController extends HttpServlet {

    MarkService markService = ServiceLocator.getMarkService();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nameCource = request.getParameter("nameCource");
        String nameStudent = request.getParameter("nameStudent");
        String comment = request.getParameter("comment");

        //choice model or entity
        MarkModel newMark = new MarkModel(nameCource, nameStudent, comment);
        markService.insert(new Mark());

        response.sendRedirect("/mark");
    }
}
