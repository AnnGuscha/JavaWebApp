package Services;

import Entity.Professor;
import levelDAO.ProfessorDAO;

import java.util.List;

/**
 * Created by Anna on 12/13/2015.
 */
public class ProfessorService {
    private static ProfessorService ourInstance = new ProfessorService();
    private ProfessorDAO professorDAO;

    private ProfessorService() {
        professorDAO = ServiceLocator.getFactory().getProfessorDAO();
    }

    public static ProfessorService getInstance() {
        return ourInstance;
    }

    public List<Professor> getAll() {
        return professorDAO.getAll();
    }

    public Professor find(int id) {
        return professorDAO.find(id);
    }

    public Professor findByUserId(int userId) {
        return professorDAO.findByUserId(userId);
    }

    public int insert(Professor professor) {
        return professorDAO.insert(professor);
    }

    public boolean update(Professor newProfessor) {
        return professorDAO.update(newProfessor);
    }

    public boolean delete(int id) {
        return professorDAO.delete(id);
    }
}
