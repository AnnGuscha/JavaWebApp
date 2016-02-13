package util;

import entity.Course;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {

    public static Course getCourse(HttpServletRequest request) {
        int idProfessor = Integer.parseInt(request.getParameter("idProfessor"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Course course;
        if (request.getParameter("idCourse") != null)
            course = new Course(Integer.parseInt(request.getParameter("idCourse")), name, idProfessor, description);
        else course = new Course(name, idProfessor, description);
        return course;
    }
}
