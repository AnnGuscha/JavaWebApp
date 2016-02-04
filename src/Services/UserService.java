package services;

import dao.BaseDAO;
import dao.DAOException;
import dao.UserDAO;
import entity.User;
import org.apache.log4j.Logger;

/**
 * Created by Anna on 12/21/2015.
 */
public class UserService extends BaseService<User> {
    private static Logger Log = Logger.getLogger(UserService.class.getName());
    private static UserService ourInstance = new UserService();
    private static UserDAO userDAO ;//= ServiceLocator.getFactory().getUserDAO();

    private UserService() {
        userDAO = ServiceLocator.getFactory().getUserDAO();
    }

    public static UserService getInstance() {
        return ourInstance;
    }

    @Override
    BaseDAO getDAO() {
        return userDAO;
    }

    public User find(String login, String pwd) throws ServiceException{
        User entity = null;
        try {
            entity = userDAO.find(login, pwd);
            Log.info("Found user with login=" + login);
        } catch (DAOException e) {
            Log.error("Can not find user with login=" + login, e);
            e.printStackTrace();
            throw new ServiceException("Can not find", e);
        } finally {
            return entity;
        }
    }

    public User find(String login) {
        User entity = null;
        try {
            entity = userDAO.find(login);
            Log.info("Found user with login=" + login);
        } catch (DAOException e) {
            Log.error("Can not find user with login=" + login, e);
            e.printStackTrace();
            throw new ServiceException("Can not find", e);
        } finally {
            return entity;
        }
    }
}
