package Infrastructure;

/**
 * Created by Anna on 12/13/2015.
 */
public class CourseService {
    private static CourseService ourInstance = new CourseService();

    private CourseService() {
    }

    public static CourseService getInstance() {
        return ourInstance;
    }
}
