package services;

import dao.BaseDAO;
import dao.DAOException;
import dao.ProfessorDAO;
import entity.Professor;
import org.apache.log4j.Logger;

public class ProfessorService extends BaseService<Professor>{

    private static Logger Log = Logger.getLogger(ProfessorService.class.getName());
    private static ProfessorService ourInstance = new ProfessorService();
    private static ProfessorDAO professorDAO;

    private ProfessorService() {
        professorDAO = ServiceLocator.getFactory().getProfessorDAO();
    }

    public static ProfessorService getInstance() {
        return ourInstance;
    }

    @Override
    BaseDAO getDAO() {
        return ServiceLocator.getFactory().getProfessorDAO();
    }

    public Professor findByUserId(int userId) throws ServiceException {
        Professor entity=null;
        try {
            entity = professorDAO.findByUserId(userId);
            Log.info("Found professor with idUser="+userId);
        } catch (DAOException e) {
            Log.error("Can not find professor", e);
            e.printStackTrace();
            throw new ServiceException("Can not find ",e);
        }finally {
            return entity;
        }
    }
}
