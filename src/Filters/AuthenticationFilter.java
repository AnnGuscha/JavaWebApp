package Filters;

import Commands.Role;
import Entity.User;
import Services.ServiceLocator;
import Services.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

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
            if (uri.contains(potencialEntry.x)) {
                authEntry = potencialEntry;
            }
        }

        if (authEntry == null) {
            isConfrimed = true;
        } else {
            if (authEntry.y == Role.Anonymous) {
                isConfrimed = true;
            } else {
                Cookie loginCookie = getCookie(req);
                if (loginCookie == null) {
                    isConfrimed = false;
                } else {
                    User user = userService.find(String.valueOf(loginCookie.getValue()));
                    isConfrimed = user != null && user.getRole() == authEntry.y.ordinal();
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
        authList.add(new Tuple<>("/api/course", Role.Anonymous));
        authList.add(new Tuple<>("/api/liststudents", Role.Professor));

        return authList;
    }

    private Cookie getCookie(HttpServletRequest req) {
        Cookie loginCookie = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    loginCookie = cookie;
                    break;
                }
            }
        }
        return loginCookie;
    }


    public void destroy() {
        //close any resources here
    }

}
