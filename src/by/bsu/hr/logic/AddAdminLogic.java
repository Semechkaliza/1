package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.UserDAO;

public class AddAdminLogic {
    public static void addAdmin(String login) throws LogicException {
        try {
            UserDAO.addAdmin(login);
        } catch (DAOException e) {
            throw new LogicException("Error add admin",e);
        }
    }

    public static boolean checkLogin(String login) throws LogicException {
        try {
           return !UserDAO.checkUser(login);
        } catch (DAOException e) {
            throw new LogicException("Error check user",e);
        }
    }
}
