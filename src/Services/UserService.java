package services;

import dao.UserDAO;
import entity.User;

import java.util.List;

/**
 * Created by Anna on 12/21/2015.
 */
public class UserService {
    private static UserService ourInstance = new UserService();
    private UserDAO userDAO;

    private UserService() {
        userDAO = ServiceLocator.getFactory().getUserDAO();
    }

    public static UserService getInstance() {
        return ourInstance;
    }

    public List<User> getAll() {
        return userDAO.getAll();
    }

    public User find(int id) {
        return userDAO.find(id);
    }

    public User find(String login, String pwd) {
        return userDAO.find(login, pwd);
    }

    public User find(String login) {
        return userDAO.find(login);
    }

    public int insert(User user) {
        return userDAO.insert(user);
    }

    public boolean update(User newUser) {
        return userDAO.update(newUser);
    }

    public boolean delete(int id) {
        return userDAO.delete(id);
    }
}
