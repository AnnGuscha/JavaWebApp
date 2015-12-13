package Controllers.web.Mark;

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
        name = "MarkCreateController",
        urlPatterns = {"/mark/create"}
)

public class MarkCreateController extends HttpServlet {

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String nextJSP = "/Views/Mark/Create.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, resp);
    }
}