package services;

import dao.DAOFactory;

public class ServiceLocator {

    private static ServiceLocator ourInstance = new ServiceLocator();
    private static DAOFactory MySQLFactory =
            DAOFactory.getDAOFactory(DAOFactory.MYSQL);

    private ServiceLocator() {
    }

    public static ServiceLocator getInstance() {
        return ourInstance;
    }

    public static DAOFactory getFactory() {
        return MySQLFactory;
    }

    public static StudentService getStudentService() {
        return StudentService.getInstance();
    }

    public static ProfessorService getProfessorService() {
        return ProfessorService.getInstance();
    }

    public static CourseService getCourseService() {
        return CourseService.getInstance();
    }

    public static MarkService getMarkService() {
        return MarkService.getInstance();
    }

    public static ListStudentsService getListStudentsService() {
        return ListStudentsService.getInstance();
    }

    public static ParticularService getParticularService() {
        return ParticularService.getInstance();
    }

    public static UserService getUserService() {
        return UserService.getInstance();
    }
}
