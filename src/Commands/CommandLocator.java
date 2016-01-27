package commands;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Anna on 12/21/2015.
 */
public class CommandLocator {


    public static void execute(HttpServletRequest request,
                               HttpServletResponse response, TypeMethod method) throws IOException, ServletException {
        ArrayList<RouteEntry> routes = new ArrayList<>();
        // routes.add(new RouteEntry("/login", 0, new LoginServlet()));
        String url = request.getPathInfo();
        RouteEntry entry = null;
        for (RouteEntry potencialEntry : routes) {
            if (url.contains(potencialEntry.pattern)) {
                entry = potencialEntry;
                break;
            }
        }
        if (entry == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        switch (request.getMethod()) {
            case "GET": {
                entry.getController().Get(request, response);
            }
            break;
            case "POST": {
                entry.getController().Post(request, response);
            }
            break;
        }
    }
}
