package Infrastructure;

import Entity.Student;
import levelDAO.DAOFactory;
import levelDAO.StudentDAO;

import java.util.List;

/**
 * Created by Anna on 12/8/2015.
 */
public class ServiceLocator {

    private static DAOFactory MySQLFactory =
            DAOFactory.getDAOFactory(DAOFactory.MYSQL);

    StudentDAO studentDAO;

    public static DAOFactory getFactory() {
        return MySQLFactory;
    }

    public List<Student> getAllStudent() {
        return MySQLFactory.getStudentDAO().getAll();
    }
}
