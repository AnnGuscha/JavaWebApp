package Infrastructure;

/**
 * Created by Anna on 12/13/2015.
 */
public class ListStudentsService {
    private static ListStudentsService ourInstance = new ListStudentsService();

    private ListStudentsService() {
    }

    public static ListStudentsService getInstance() {
        return ourInstance;
    }
}
