package Services;

import Entity.Mark;
import levelDAO.MarkDAO;

import java.util.List;

/**
 * Created by Anna on 12/13/2015.
 */
public class MarkService {
    private static MarkService ourInstance = new MarkService();
    private MarkDAO markDAO;

    private MarkService() {
        markDAO = ServiceLocator.getFactory().getMarkDAO();
    }

    public static MarkService getInstance() {
        return ourInstance;
    }

    public List<Mark> getAll() {
        return markDAO.getAll();
    }

    public Mark find(int id) {
        return markDAO.find(id);
    }

    public Mark find(int idCourse, int idStudent) {
        return markDAO.find(idCourse, idStudent);
    }

    public int insert(Mark mark) {
        return markDAO.insert(mark);
    }

    public boolean update(Mark newMark) {
        return markDAO.update(newMark);
    }

    public boolean delete(int id) {
        return markDAO.delete(id);
    }

    public boolean delete(Mark mark) {
        return markDAO.delete(mark);
    }
}
