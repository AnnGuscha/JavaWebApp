package services;

import dao.BaseDAO;
import dao.CourseDAO;
import dao.DAOException;
import entity.Course;
import entity.extended.CourseExtend;
import models.student.CourseModel;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CourseService extends BaseService<Course> {
    private static Logger Log = Logger.getLogger(CourseService.class.getName());
    private static CourseService ourInstance = new CourseService();
    private static CourseDAO courseDAO;

    private CourseService() {
        courseDAO= ServiceLocator.getFactory().getCourseDAO();
    }

    public static CourseService getInstance() {
        return ourInstance;
    }

    @Override
    BaseDAO getDAO() {
        return courseDAO;
    }

    public List<CourseModel> getCourseModelList() throws ServiceException {

        List<CourseExtend> courseExtendList = null;
        List<CourseModel> courseModelList=null;
        try {
            courseExtendList = courseDAO.getCourseExtentdList();
            courseModelList = new ArrayList<>();

            for (CourseExtend item : courseExtendList) {
                CourseModel courseModel = new models.student.CourseModel();
                courseModel.setId(item.getId());
                courseModel.setName(item.getName());
                courseModel.setIdProfessor(item.getIdProfessor());
                courseModel.setDescription(item.getDescription());
                courseModel.setNameProfessor(item.getNameProfessor());

                courseModel.setSubscribed(true);
                courseModelList.add(courseModel);

                Log.info("Found "+courseExtendList.size()+"courses");
            }
        } catch (DAOException e) {
            Log.error("Can not find courses ",e);
            e.printStackTrace();
            throw new ServiceException("Can not find",e);
        }finally {
            return courseModelList;
        }
    }

    public models.professor.CourseModel getCourseModelForProfessor(int idProfessor) throws ServiceException {

        Course course;
        models.professor.CourseModel courseModel=null;
        try {
            course = courseDAO.getCourseByProfessor(idProfessor);
            courseModel = new models.professor.CourseModel();
            courseModel.setId(course.getId());
            courseModel.setName(course.getName());
            courseModel.setDescription(course.getDescription());
            Log.info("Found course with professorId="+idProfessor);
        } catch (DAOException e) {
            Log.error("Can not find courses ",e);
            e.printStackTrace();
            throw new ServiceException("Can not find",e);
        }finally {
            return courseModel;
        }
    }
}
