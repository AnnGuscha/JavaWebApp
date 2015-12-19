package Infrastructure;


import ExtendedEntity.CourseExtend;
import ExtendedEntity.MarkExtend;
import ExtendedEntity.StudentExtend;
import Models.forProfessor.MarkModel;
import Models.forProfessor.StudentsForProfessorModel;
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

    public List<StudentsForProfessorModel> getStudentsByCourse(int idCourse) {

        List<StudentExtend> studentExtendList = particularQueriesDAO.getStudentsByCourse(ServiceLocator.getIdCurrentUser());

        List<StudentsForProfessorModel> studentsModelList = new ArrayList<>();
        for (StudentExtend item : studentExtendList) {
            StudentsForProfessorModel studentsModel = new StudentsForProfessorModel();
            studentsModel.setId(item.getId());
            studentsModel.setName(item.getName());
            studentsModelList.add(studentsModel);
        }
        return studentsModelList;
    }

    public List<StudentsForProfessorModel> getStudentsByProfessor() {

        List<StudentExtend> studentExtendList = particularQueriesDAO.getStudentsByProfessor(ServiceLocator.getIdCurrentUser());

        List<StudentsForProfessorModel> studentsModelList = new ArrayList<>();
        for (StudentExtend item : studentExtendList) {
            StudentsForProfessorModel studentsModel = new StudentsForProfessorModel();
            studentsModel.setId(item.getId());
            studentsModel.setName(item.getSurName() + " " + item.getName() + " " + item.getPatronymicName());
            studentsModel.setMark(item.getMark());
            studentsModelList.add(studentsModel);
        }
        return studentsModelList;
    }

    public MarkModel findMark(int idCourse, int idStudent) {
        MarkModel model = new MarkModel();
        MarkExtend mark = particularQueriesDAO.find(idCourse, idStudent);
        model.setId(mark.getId());
        model.setIdStudent(mark.getIdStudent());
        model.setIdCourse(mark.getIdCourse());
        model.setNameStudent(mark.getNameStudent());
        model.setNameCourse(mark.getNameCourse());
        model.setComment(mark.getComment());
        return model;
    }
}
