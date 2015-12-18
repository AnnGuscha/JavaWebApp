package Infrastructure;

import ExtendedEntity.CourseExtend;
import Models.forStudent.CourseModel;
import levelDAO.ParticularQueriesDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anna on 12/18/2015.
 */
public class ParticularService {
    private static ParticularService ourInstance = new ParticularService();
    private ParticularQueriesDAO particularQueriesDAO;

    private ParticularService() {
        particularQueriesDAO = ServiceLocator.getFactory().getParticularQueriesDAO();
    }

    public static ParticularService getInstance() {
        return ourInstance;
    }

    public List<CourseModel> getCoursesForStudent() {

        List<CourseExtend> courseExtentdList = particularQueriesDAO.getCoursesForStudent(ServiceLocator.getIdCurrentUser());

        List<CourseModel> courseModelList = new ArrayList<>();

        for (CourseExtend item : courseExtentdList) {
            CourseModel courseModel = new CourseModel();
            courseModel.setId(item.getId());
            courseModel.setName(item.getName());
            courseModel.setIdProfessor(item.getIdProfessor());
            courseModel.setDescription(item.getDescription());
            courseModel.setNameProfessor(item.getNameProfessor());
            courseModel.setMark(item.getMark() != null ? item.getMark() : "");
            courseModel.setSubscribed(true);
            courseModelList.add(courseModel);
        }
        return courseModelList;
    }

    public List<CourseModel> getAllCourses() {
        List<CourseExtend> courseExtentdList = particularQueriesDAO.getCourses(ServiceLocator.getIdCurrentUser());

        List<CourseModel> courseModelList = new ArrayList<>();

        for (CourseExtend item : courseExtentdList) {
            CourseModel courseModel = new CourseModel();
            courseModel.setId(item.getId());
            courseModel.setName(item.getName());
            courseModel.setIdProfessor(item.getIdProfessor());
            courseModel.setDescription(item.getDescription());
            courseModel.setNameProfessor(item.getNameProfessor());
            courseModel.setSubscribed(item.getIsSubscription());
            courseModelList.add(courseModel);
        }
        return courseModelList;
    }

}
