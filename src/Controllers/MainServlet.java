package controllers;
/**
 * Created by Anna on 12/6/2015.
 */

import commands.CommandLocator;
import commands.TypeMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        CommandLocator.execute(request, response, TypeMethod.get);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        CommandLocator.execute(request, response, TypeMethod.post);
    }
}