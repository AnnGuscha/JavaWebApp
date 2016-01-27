package services;

import dao.StudentDAO;
import entity.Student;

import java.util.List;

/**
 * Created by Anna on 12/13/2015.
 */
public class StudentService {
    private static StudentService ourInstance = new StudentService();
    private StudentDAO studentDAO;

    private StudentService() {
        studentDAO = ServiceLocator.getFactory().getStudentDAO();
    }

    public static StudentService getInstance() {
        return ourInstance;
    }

    public List<Student> getAll() {
        return studentDAO.getAll();
    }

    public Student findByUserId(int userId) {
        return studentDAO.find(userId);
    }

    public List<Student> find(String name) {
        return studentDAO.find(name);
    }

    public Student find(int id) {
        return studentDAO.find(id);
    }

    public int insert(Student student) {
        return studentDAO.insert(student);
    }

    public boolean update(Student newStudent) {
        return studentDAO.update(newStudent);
    }

    public boolean delete(int id) {
        return studentDAO.delete(id);
    }
}
