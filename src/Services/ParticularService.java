package services;


import dao.DAOException;
import dao.ParticularQueriesDAO;
import entity.extended.CourseExtend;
import entity.extended.MarkExtend;
import entity.extended.StudentExtend;
import models.professor.MarkModel;
import models.professor.StudentsForProfessorModel;
import models.student.CourseModel;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ParticularService {
    private static Logger Log = Logger.getLogger(ParticularService.class.getName());
    private static ParticularService ourInstance = new ParticularService();
    private ParticularQueriesDAO particularQueriesDAO;

    private ParticularService() {
        particularQueriesDAO = ServiceLocator.getFactory().getParticularQueriesDAO();
    }

    public static ParticularService getInstance() {
        return ourInstance;
    }

    public List<CourseModel> getCoursesForStudent(int id) throws ServiceException {
        List<CourseExtend> courseExtendList = null;
        List<CourseModel> courseModelList = null;
        try {
            courseExtendList = particularQueriesDAO.getCoursesForStudent(id);
            Log.info("Found courses for student with id=" + id);

            courseModelList = new ArrayList<>();
            for (CourseExtend item : courseExtendList) {
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
            Log.info("Created model courses for student with id=" + id);
        } catch (DAOException e) {
            Log.error("Can not find course", e);
            e.printStackTrace();
            throw new ServiceException("Can not find", e);
        } finally {
            return courseModelList;
        }

    }

    public List<CourseModel> getAllCourses(int id) throws ServiceException {
        List<CourseExtend> courseExtendList = null;
        List<CourseModel> courseModelList = null;
        try {
            courseExtendList = particularQueriesDAO.getCourses(id);
            Log.info("Found courses for student with id=" + id);
            courseModelList = new ArrayList<>();
            for (CourseExtend item : courseExtendList) {
                CourseModel courseModel = new CourseModel();
                courseModel.setId(item.getId());
                courseModel.setName(item.getName());
                courseModel.setIdProfessor(item.getIdProfessor());
                courseModel.setDescription(item.getDescription());
                courseModel.setNameProfessor(item.getNameProfessor());
                courseModel.setSubscribed(item.getIsSubscription());
                courseModelList.add(courseModel);
            }
            Log.info("Created model for courses with id=" + id);
        } catch (DAOException e) {
            Log.info("Can not find courses with id=" + id);
            e.printStackTrace();
            throw new ServiceException("Can not find");
        } finally {
            return courseModelList;
        }
    }

    public List<StudentsForProfessorModel> getStudentsByCourse(int idCourse) throws ServiceException {

        List<StudentExtend> studentExtendList = null;
        List<StudentsForProfessorModel> studentsModelList = null;
        try {
            studentExtendList = particularQueriesDAO.getStudentsByCourse(idCourse);
            Log.info("Found students with idCourse=" + idCourse);
            studentsModelList = new ArrayList<>();
            for (StudentExtend item : studentExtendList) {
                StudentsForProfessorModel studentsModel = new StudentsForProfessorModel();
                studentsModel.setId(item.getId());
                studentsModel.setName(item.getName());
                studentsModelList.add(studentsModel);
            }
            Log.info("Created model for students with idCourse=" + idCourse);
        } catch (DAOException e) {
            Log.info("Can not find students with idCourse=" + idCourse);
            e.printStackTrace();
            throw new ServiceException("Can not find");
        } finally {
            return studentsModelList;
        }
    }

    public List<StudentsForProfessorModel> getStudentsByProfessor(int idProfessor) throws ServiceException {

        List<StudentExtend> studentExtendList = null;
        List<StudentsForProfessorModel> studentsModelList = null;
        try {
            studentExtendList = particularQueriesDAO.getStudentsByProfessor(idProfessor);
            Log.info("Found students with idProfessor=" + idProfessor);
            studentsModelList = new ArrayList<>();
            for (StudentExtend item : studentExtendList) {
                StudentsForProfessorModel studentsModel = new StudentsForProfessorModel();
                studentsModel.setId(item.getId());
                studentsModel.setName(item.getSurName() + " " + item.getName() + " " + item.getPatronymicName());
                studentsModel.setMark(item.getMark());
                studentsModelList.add(studentsModel);
            }
            Log.info("Created model for students with idProfessor=" + idProfessor);
        } catch (DAOException e) {
            Log.info("Can not find students with idProfessor=" + idProfessor);
            e.printStackTrace();
            throw new ServiceException("Can not find", e);
        } finally {
            return studentsModelList;
        }
    }

    public MarkModel findMark(int idCourse, int idStudent) throws ServiceException {
        MarkModel model = null;
        MarkExtend mark = null;
        try {
            mark = particularQueriesDAO.find(idCourse, idStudent);
            Log.info("Found mark");
            model = new MarkModel();
            model.setId(mark.getId());
            model.setIdStudent(mark.getIdStudent());
            model.setIdCourse(mark.getIdCourse());
            model.setNameStudent(mark.getNameStudent());
            model.setNameCourse(mark.getNameCourse());
            model.setComment(mark.getComment());
            Log.info("Created model for mark");
        } catch (DAOException e) {
            Log.error("Can not find mark", e);
            e.printStackTrace();
            throw new ServiceException("Can not find", e);
        } finally {
            return model;
        }
    }
}
