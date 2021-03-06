package services;

import dao.BaseDAO;
import dao.DAOException;
import dao.ListStudentsDAO;
import entity.ListStudents;
import org.apache.log4j.Logger;

public class ListStudentsService extends BaseService<ListStudents> {
    private static Logger Log = Logger.getLogger(ListStudentsService.class.getName());
    private static ListStudentsService ourInstance = new ListStudentsService();
    private static ListStudentsDAO listStudentsDAO;

    private ListStudentsService() {
        listStudentsDAO = ServiceLocator.getFactory().getListStudentsDAO();
    }

    public static ListStudentsService getInstance() {
        return ourInstance;
    }

    @Override
    BaseDAO getDAO() {
        return listStudentsDAO;
    }

    public boolean delete(ListStudents listStudents) throws ServiceException {
        boolean result = false;
        try {
            result = listStudentsDAO.delete(listStudents);
            Log.info("Deleted entity");
        } catch (DAOException e) {
            Log.error("Can not delete entity", e);
            e.printStackTrace();
            throw new ServiceException("Can not update", e);
        } finally {
            return result;
        }
    }
}
