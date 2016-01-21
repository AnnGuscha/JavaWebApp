package Controllers.forAdmin.web.Mark;

import Services.MarkService;
import Services.ServiceLocator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anna on 12/23/2015.
 */

@WebServlet(
        name = "MarkDeleteController",
        urlPatterns = {"/mark/delete/*"}
)

public class MarkDeleteController extends HttpServlet {

    MarkService markService = ServiceLocator.getMarkService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rawParam = request.getPathInfo();
        int idParam = Integer.parseInt(rawParam.split("/")[1]);

        markService.delete(idParam);
        response.sendRedirect("/mark");
    }
}