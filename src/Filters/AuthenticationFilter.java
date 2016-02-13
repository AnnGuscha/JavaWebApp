package filters;

import entity.User;
import manager.ManagerFactory;
import manager.Role;
import org.apache.log4j.Logger;
import services.ServiceException;
import services.ServiceLocator;
import services.UserService;
import util.SessionUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {
    private static final Logger log = Logger.getLogger(AuthenticationFilter.class);
    private ServletContext context;
    private UserService userService = ServiceLocator.getUserService();

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        this.context.log("Requested Resource::" + uri);

        ArrayList<Tuple<String, Role>> authList = getAuthList();

        Tuple<String, Role> authEntry = null;

        boolean isConfrimed;

        for (Tuple<String, Role> potencialEntry : authList) {
            if (uri.startsWith(potencialEntry.x)) {
                authEntry = potencialEntry;
            }
        }

        if (authEntry == null) {
            isConfrimed = true;
        } else {
            if (authEntry.y == Role.ANONYMOUS) {
                isConfrimed = true;
            } else {
                //Cookie loginCookie = getCookie(req);

                HttpSession session = ((HttpServletRequest) request).getSession();
                int userId = 0;
                if (session.getAttribute("userId") == null) {
                    isConfrimed = false;
                } else
                    userId = Integer.parseInt(session.getAttribute("userId").toString());

                if (userId == 0) {
                    isConfrimed = false;
                } else {
                    User curUser = null;
                    try {
                        curUser = userService.find(userId);
                        isConfrimed = curUser != null && curUser.getRole() == authEntry.y.ordinal();
                    } catch (ServiceException e) {
                        log.error("Can not find entity",e);
                        e.printStackTrace();
                        PrintWriter out = response.getWriter();
                        String message = ManagerFactory.getMessageManager(SessionUtil.getLocale((HttpServletRequest) request)).getObject("error.app");
                        out.println("<font color=red>" + message + "</font>");
                        isConfrimed=false;
                    }
                }
            }
        }
        if (isConfrimed) {
            chain.doFilter(request, response);
        } else {
            this.context.log("Unauthorized access request");
            res.sendRedirect("/login");
        }
    }

    private ArrayList<Tuple<String, Role>> getAuthList() {
        ArrayList<Tuple<String, Role>> authList;
        authList = new ArrayList<>();
        authList.add(new Tuple<>("/api/admin", Role.ADMIN));
        authList.add(new Tuple<>("/admin", Role.ADMIN));

        authList.add(new Tuple<>("/api/professor", Role.PROFESSOR));
        authList.add(new Tuple<>("/professor", Role.PROFESSOR));

        authList.add(new Tuple<>("/api/student", Role.STUDENT));
        authList.add(new Tuple<>("/student", Role.STUDENT));
        return authList;
    }

    public void destroy() {
        //close any resources here
    }

}
