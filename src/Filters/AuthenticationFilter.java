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
import javax.servlet.http.HttpSession;
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
            if (uri.equals(potencialEntry.x)) {
                authEntry = potencialEntry;
            }
        }

        if (authEntry == null) {
            isConfrimed = true;
        } else {
            if (authEntry.y == Role.Anonymous) {
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
                    User curUser = userService.find(userId);
                    isConfrimed = curUser != null && curUser.getRole() == authEntry.y.ordinal();
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
        authList.add(new Tuple<>("/api/course", Role.Admin));
        authList.add(new Tuple<>("/api/course/create", Role.Admin));
        authList.add(new Tuple<>("/api/course/edit", Role.Admin));
        authList.add(new Tuple<>("/course", Role.Admin));
        authList.add(new Tuple<>("/course/create", Role.Admin));
        //authList.add(new Tuple<>("/course/edit/*", Role.Admin));

        authList.add(new Tuple<>("/api/student", Role.Admin));
        authList.add(new Tuple<>("/api/student/create", Role.Admin));
        authList.add(new Tuple<>("/api/student/edit", Role.Admin));
        authList.add(new Tuple<>("/student", Role.Admin));
        authList.add(new Tuple<>("/student/create", Role.Admin));
        //authList.add(new Tuple<>("/student/edit/*", Role.Admin));
        // authList.add(new Tuple<>("/student/details/*", Role.Admin));
        //authList.add(new Tuple<>("/student/delete/*", Role.Admin));

        authList.add(new Tuple<>("/api/professor", Role.Admin));
        authList.add(new Tuple<>("/api/professor/create", Role.Admin));
        authList.add(new Tuple<>("/api/professor/edit", Role.Admin));
        authList.add(new Tuple<>("/professor", Role.Admin));
        authList.add(new Tuple<>("/professor/create", Role.Admin));
        //authList.add(new Tuple<>("/professor/edit/*", Role.Admin));

        authList.add(new Tuple<>("/api/mark", Role.Admin));
        authList.add(new Tuple<>("/api/mark/create", Role.Admin));
        authList.add(new Tuple<>("/api/mark/edit", Role.Admin));
        authList.add(new Tuple<>("/mark", Role.Admin));
        authList.add(new Tuple<>("/mark/create", Role.Admin));
        //authList.add(new Tuple<>("/mark/edit/*", Role.Admin));

        authList.add(new Tuple<>("/api/liststudents", Role.Admin));
        authList.add(new Tuple<>("/api/liststudents/create", Role.Admin));
        authList.add(new Tuple<>("/api/liststudents/edit", Role.Admin));
        authList.add(new Tuple<>("/liststudents", Role.Admin));
        authList.add(new Tuple<>("/liststudents/create", Role.Admin));
        //authList.add(new Tuple<>("/liststudents/edit/*", Role.Admin));

        authList.add(new Tuple<>("/api/professor_home/create_mark", Role.Professor));
        authList.add(new Tuple<>("/professor_home/create_mark", Role.Professor));
        authList.add(new Tuple<>("/api/professor_home/edit", Role.Professor));
        authList.add(new Tuple<>("/professor_home/edit", Role.Professor));
        authList.add(new Tuple<>("/api/professor_home/edit_mark", Role.Professor));
        authList.add(new Tuple<>("/professor_home/edit_mark", Role.Professor));
        authList.add(new Tuple<>("/api/professor_home", Role.Professor));
        authList.add(new Tuple<>("/professor_home", Role.Professor));
        authList.add(new Tuple<>("/api/professor_students", Role.Professor));
        authList.add(new Tuple<>("/professor_students", Role.Professor));

        authList.add(new Tuple<>("/api/student_allcourses", Role.Student));
        authList.add(new Tuple<>("/api/student_courses", Role.Student));
        authList.add(new Tuple<>("/api/student_home/edit", Role.Student));
        authList.add(new Tuple<>("/api/student_home", Role.Student));
        authList.add(new Tuple<>("/student_allcourses", Role.Student));
        authList.add(new Tuple<>("/student_courses", Role.Student));
        authList.add(new Tuple<>("/student_home/edit", Role.Student));
        authList.add(new Tuple<>("/student_home", Role.Student));
        //authList.add(new Tuple<>("/student/subs/*", Role.Student));
        //authList.add(new Tuple<>("/student/unsubs/*", Role.Student));
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
