package Infrastructure;

import Entity.Course;
import levelDAO.CourseDAO;

import java.util.List;

/**
 * Created by Anna on 12/13/2015.
 */
public class CourseService {
    private static CourseService ourInstance = new CourseService();
    private CourseDAO courseDAO;

    private CourseService() {
        courseDAO = ServiceLocator.getFactory().getCourseDAO();
    }

    public static CourseService getInstance() {
        return ourInstance;
    }

    public List<Course> getAll() {
        return courseDAO.getAll();
    }

    public Course find(int id) {
        return courseDAO.find(id);
    }

    public int insert(Course course) {
        return courseDAO.insert(course);
    }

    public boolean update(Course newCourse) {
        return courseDAO.update(newCourse);
    }

    public boolean delete(int id) {
        return courseDAO.delete(id);
    }
}
