package services;

import dao.BaseDAO;
import dao.DAOException;
import dao.MarkDAO;
import entity.Mark;
import org.apache.log4j.Logger;

public class MarkService extends BaseService<Mark>{
    private static Logger Log = Logger.getLogger(MarkService.class.getName());
    private static MarkService ourInstance = new MarkService();
    private static MarkDAO markDAO;

    private MarkService() {
        markDAO = ServiceLocator.getFactory().getMarkDAO();
    }

    public static MarkService getInstance() {
        return ourInstance;
    }

    @Override
    BaseDAO getDAO() {
        return markDAO;
    }

    public Mark find(int idCourse, int idStudent) throws ServiceException {
        Mark entity = null;
        try {
            entity = markDAO.find(idCourse, idStudent);
            Log.info("Found mark with idCourse=" + idCourse + " and idStudent=" + idStudent);
        } catch (DAOException e) {
            Log.error("Can not find entity", e);
            e.printStackTrace();
            throw new ServiceException("Can not find ", e);
        } finally {
            return entity;
        }
    }

    public boolean delete(Mark mark) throws ServiceException {
        boolean result = false;
        try {
            result = markDAO.delete(mark);
            Log.info("Deleted mark");
        } catch (DAOException e) {
            Log.error("Can not find entity", e);
            e.printStackTrace();
            throw new ServiceException("Can not find ", e);
        } finally {
            return result;
        }
    }
}
