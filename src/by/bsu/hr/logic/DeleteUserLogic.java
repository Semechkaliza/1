package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.UserDAO;

public class DeleteUserLogic {
    public static void deleteUser(int userId) throws LogicException {
        try {
            UserDAO.deleteUser(userId);
        } catch (DAOException e) {
            throw new LogicException("Error delete user",e);
        }
    }
}
