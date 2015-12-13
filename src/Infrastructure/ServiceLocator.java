package Infrastructure;

import levelDAO.DAOFactory;

/**
 * Created by Anna on 12/8/2015.
 */
public class ServiceLocator {

    private static ServiceLocator ourInstance;
    private static DAOFactory MySQLFactory =
            DAOFactory.getDAOFactory(DAOFactory.MYSQL);

    private ServiceLocator() {
    }

    public static ServiceLocator getInstance() {
        if (ourInstance == null)
            ourInstance = new ServiceLocator();
        return ourInstance;
    }

    public static DAOFactory getFactory() {
        return MySQLFactory;
    }

    public static StudentService getStudentService() {
        return StudentService.getInstance();
    }

    public static ProfessorService getProfessorService() {
        return getProfessorService().getInstance();
    }

    public static CourseService getCourceService() {
        return CourseService.getInstance();
    }

    public static MarkService getMarkService() {
        return MarkService.getInstance();
    }

    public static ListStudentsService getListStudentsService() {
        return ListStudentsService.getInstance();
    }
}
