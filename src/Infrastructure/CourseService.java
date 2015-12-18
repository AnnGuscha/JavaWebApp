package Infrastructure;

import Entity.Course;
import ExtendedEntity.CourseExtend;
import Models.forStudent.CourseModel;
import levelDAO.CourseDAO;

import java.util.ArrayList;
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

    public List<CourseModel> getCourseModelList() {

        List<CourseExtend> courseExtentdList = courseDAO.getCourseExtentdList();

        List<CourseModel> courseModelList = new ArrayList<>();

        for (CourseExtend item : courseExtentdList) {
            CourseModel courseModel = new Models.forStudent.CourseModel();
            courseModel.setId(item.getId());
            courseModel.setName(item.getName());
            courseModel.setIdProfessor(item.getIdProfessor());
            courseModel.setDescription(item.getDescription());
            courseModel.setNameProfessor(item.getNameProfessor());

            courseModel.setSubscribed(true);
            courseModelList.add(courseModel);
        }
        return courseModelList;
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
