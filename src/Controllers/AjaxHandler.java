package controllers;
/**
 * Created by Anna on 12/6/2015.
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxHandler extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        // reading the user input
        //String color= request.getParameter("color");
        getServletContext().getRequestDispatcher("/hello.jsp").forward(request, response);
//        PrintWriter out = response.getWriter();
//        out.println (
//                "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\"http://www.w3.org/TR/html4/loose.dtd\">\n" +
//                        "<html> \n" +
//                        "<head> \n" +
//                        "<meta http-equiv=\"Content-Type\" content=\"text/html;charset=ISO-8859-1\"> \n" +
//                        "<title> My first jsp  </title> \n" +
//                        "</head> \n" +
//                        "<body> \n" +
//                        "<font size=\"12px\" color=\"" + color + "\">" +
//                        "MainServlet World" +
//                        "</font> \n" +
//                        "</body> \n" +
//                        "</html>"
//        );
    }
}