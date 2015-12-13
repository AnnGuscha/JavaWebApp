package Infrastructure;

/**
 * Created by Anna on 12/13/2015.
 */
public class ProfessorService {
    private static ProfessorService ourInstance = new ProfessorService();

    private ProfessorService() {
    }

    public static ProfessorService getInstance() {
        return ourInstance;
    }
}
