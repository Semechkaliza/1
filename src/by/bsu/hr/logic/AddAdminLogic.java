package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.UserDAO;

/**
 * Logic to add admin command
 */
public class AddAdminLogic {
    /**
     * Add new admin
     * @param login
     * @throws LogicException
     */
    public static void addAdmin(String login) throws LogicException {
        try {
            UserDAO.addAdmin(login);
        } catch (DAOException e) {
            throw new LogicException("Error add admin",e);
        }
    }

    /**
     * Check, if there is active user with such login
     * @param login
     * @return boolean
     * @throws LogicException
     */
    public static boolean checkLogin(String login) throws LogicException {
        try {
           return !UserDAO.checkUser(login);
        } catch (DAOException e) {
            throw new LogicException("Error check user",e);
        }
    }
}
