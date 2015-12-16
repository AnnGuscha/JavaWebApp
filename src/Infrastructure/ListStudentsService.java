package Infrastructure;

import Entity.ListStudents;
import levelDAO.ListStudentsDAO;

import java.util.List;

/**
 * Created by Anna on 12/13/2015.
 */
public class ListStudentsService {
    private static ListStudentsService ourInstance = new ListStudentsService();
    private ListStudentsDAO listStudentsDAO;

    private ListStudentsService() {
        listStudentsDAO = ServiceLocator.getFactory().getListStudentsDAO();
    }

    public static ListStudentsService getInstance() {
        return ourInstance;
    }

    public List<ListStudents> getAll() {
        return listStudentsDAO.getAll();
    }

    public ListStudents find(int id) {
        return listStudentsDAO.find(id);
    }

    public int insert(ListStudents professor) {
        return listStudentsDAO.insert(professor);
    }

    public boolean update(ListStudents newListStudents) {
        return listStudentsDAO.update(newListStudents);
    }

    public boolean delete(int id) {
        return listStudentsDAO.delete(id);
    }
}
