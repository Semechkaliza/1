package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.UserDAO;

/**
 * Logic to delete user command
 */
public class DeleteUserLogic {
    /**
     * @param userId
     * @throws LogicException
     */
    public static void deleteUser(int userId) throws LogicException {
        try {
            if(userId!=1){
                UserDAO.deleteUser(userId);
            }
        } catch (DAOException e) {
            throw new LogicException("Error delete user",e);
        }
    }
}
