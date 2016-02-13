package services;

import dao.BaseDAO;
import dao.DAOException;
import entity.IdEntity;
import org.apache.log4j.Logger;

import java.util.List;

public abstract class BaseService<T extends IdEntity> {
    private static Logger Log = Logger.getLogger(BaseService.class.getName());

    abstract BaseDAO getDAO();

    public List<T> getAll() throws ServiceException {
        List<T> entities = null;
        try {
            entities = getDAO().getAll();
            Log.info("Found " + entities.size() + " entities");
        } catch (DAOException e) {
            Log.error("Can not find entities", e);
            e.printStackTrace();
            throw new ServiceException("Can not find", e);
        } finally {
            return entities;
        }
    }

    public T find(int id) throws ServiceException {
        T entity = null;
        try {
            entity = (T) getDAO().find(id);
            Log.info("Found entity with id=" + id);
        } catch (DAOException e) {
            Log.error("Can not find entity", e);
            e.printStackTrace();
            throw new ServiceException("Can not find ", e);
        } finally {
            return entity;
        }
    }

    public int insert(T entity) throws ServiceException {
        int result = 0;
        try {
            result = getDAO().insert(entity);
            Log.info("Created entity");
        } catch (DAOException e) {
            Log.error("Can not create entity", e);
            e.printStackTrace();
            throw new ServiceException("Can not create ", e);
        } finally {
            return result;
        }
    }

    public boolean update(T entity) throws ServiceException {
        boolean result = false;
        try {
            result = getDAO().update(entity);
            Log.info("Updated entity");
        } catch (DAOException e) {
            Log.error("Can not update entity,e");
            e.printStackTrace();
            throw new ServiceException("Can not update", e);
        } finally {
            return result;
        }
    }

    public boolean delete(int id) throws ServiceException {
        boolean result = false;
        try {
            result = getDAO().delete(id);
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
