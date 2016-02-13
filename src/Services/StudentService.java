package services;

import dao.BaseDAO;
import dao.DAOException;
import dao.StudentDAO;
import entity.Student;
import org.apache.log4j.Logger;

import java.util.List;

public class StudentService extends BaseService<Student> {
    private static Logger Log = Logger.getLogger(StudentService.class.getName());
    private static StudentService ourInstance = new StudentService();
    private static StudentDAO studentDAO;

    private StudentService() {
        studentDAO=ServiceLocator.getFactory().getStudentDAO();
    }

    public static StudentService getInstance() {
        return ourInstance;
    }

    @Override
    BaseDAO getDAO() {
        return studentDAO;
    }

    public Student findByUserId(int userId) throws ServiceException{
        Student entity = null;
        try {
            entity = studentDAO.findByUserId(userId);
            Log.info("Found student with idUser=" + userId);
        } catch (DAOException e) {
            Log.error("Can not find user ", e);
            e.printStackTrace();
            throw new ServiceException("Can not find", e);
        } finally {
            return entity;
        }
    }

    public List<Student> find(String name) {
        List<Student> entities = null;
        try {
            entities = studentDAO.find(name);
            Log.info("Found courses with name=" + name);
        } catch (DAOException e) {
            Log.error("Can not find student with name=" + name, e);
            e.printStackTrace();
            throw new ServiceException("Can not find", e);
        } finally {
            return entities;
        }
    }
}
