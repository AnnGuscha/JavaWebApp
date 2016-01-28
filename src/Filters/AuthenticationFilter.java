package filters;

import commands.Role;
import entity.User;
import services.ServiceLocator;
import services.UserService;

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
//        authList.add(new Tuple<>("/api/admin/course", Role.ADMIN));
//        authList.add(new Tuple<>("/api/admin/course/create", Role.ADMIN));
//        authList.add(new Tuple<>("/api/admin/course/edit", Role.ADMIN));
//        authList.add(new Tuple<>("/admin/course", Role.ADMIN));
//        authList.add(new Tuple<>("/admin/course/create", Role.ADMIN));
//        //authList.add(new Tuple<>("/admin/course/edit/*", Role.ADMIN));
//
//        authList.add(new Tuple<>("/api/admin/student", Role.ADMIN));
//        authList.add(new Tuple<>("/api/admin/student/create", Role.ADMIN));
//        authList.add(new Tuple<>("/api/admin/student/edit", Role.ADMIN));
//        authList.add(new Tuple<>("/admin/student", Role.ADMIN));
//        authList.add(new Tuple<>("/admin/student/create", Role.ADMIN));
//        //authList.add(new Tuple<>("/admin/student/edit/*", Role.ADMIN));
//        // authList.add(new Tuple<>("/admin/student/details/*", Role.ADMIN));
//        //authList.add(new Tuple<>("/admin/student/delete/*", Role.ADMIN));
//
//        authList.add(new Tuple<>("/api/admin/professor", Role.ADMIN));
//        authList.add(new Tuple<>("/api/admin/professor/create", Role.ADMIN));
//        authList.add(new Tuple<>("/api/admin/professor/edit", Role.ADMIN));
//        authList.add(new Tuple<>("/admin/professor", Role.ADMIN));
//        authList.add(new Tuple<>("/admin/professor/create", Role.ADMIN));
//        //authList.add(new Tuple<>("/admin/professor/edit/*", Role.ADMIN));
//
//        authList.add(new Tuple<>("/api/admin/mark", Role.ADMIN));
//        authList.add(new Tuple<>("/api/admin/mark/create", Role.ADMIN));
//        authList.add(new Tuple<>("/api/admin/mark/edit", Role.ADMIN));
//        authList.add(new Tuple<>("/admin/mark", Role.ADMIN));
//        authList.add(new Tuple<>("/admin/mark/create", Role.ADMIN));
//        //authList.add(new Tuple<>("/admin/mark/edit/*", Role.ADMIN));
//
//        authList.add(new Tuple<>("/api/admin/liststudents", Role.ADMIN));
//        authList.add(new Tuple<>("/api/admin/liststudents/create", Role.ADMIN));
//        authList.add(new Tuple<>("/api/admin/liststudents/edit", Role.ADMIN));
//        authList.add(new Tuple<>("/admin/liststudents", Role.ADMIN));
//        authList.add(new Tuple<>("/admin/liststudents/create", Role.ADMIN));
//        //authList.add(new Tuple<>("/admin/liststudents/edit/*", Role.ADMIN));
//
//        authList.add(new Tuple<>("/api/professor_home/create_mark", Role.PROFESSOR));
//        authList.add(new Tuple<>("/professor_home/create_mark", Role.PROFESSOR));
//        authList.add(new Tuple<>("/api/professor_home/edit", Role.PROFESSOR));
//        authList.add(new Tuple<>("/professor_home/edit", Role.PROFESSOR));
//        authList.add(new Tuple<>("/api/professor_home/edit_mark", Role.PROFESSOR));
//        authList.add(new Tuple<>("/professor_home/edit_mark", Role.PROFESSOR));
//        authList.add(new Tuple<>("/api/professor_home", Role.PROFESSOR));
//        authList.add(new Tuple<>("/professor_home", Role.PROFESSOR));
//        authList.add(new Tuple<>("/api/professor_students", Role.PROFESSOR));
//        authList.add(new Tuple<>("/professor_students", Role.PROFESSOR));
//
//        authList.add(new Tuple<>("/api/student_allcourses", Role.STUDENT));
//        authList.add(new Tuple<>("/api/student_courses", Role.STUDENT));
//        authList.add(new Tuple<>("/api/student_home/edit", Role.STUDENT));
//        authList.add(new Tuple<>("/api/student_home", Role.STUDENT));
//        authList.add(new Tuple<>("/student_allcourses", Role.STUDENT));
//        authList.add(new Tuple<>("/student_courses", Role.STUDENT));
//        authList.add(new Tuple<>("/student_home/edit", Role.STUDENT));
//        authList.add(new Tuple<>("/student_home", Role.STUDENT));
        //authList.add(new Tuple<>("/api/student/subs/*", Role.STUDENT));
        //authList.add(new Tuple<>("/api/student/unsubs/*", Role.STUDENT));
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
