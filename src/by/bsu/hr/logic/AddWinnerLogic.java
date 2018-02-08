package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.UserDAO;

/**
 * Logic to add winner command
 */
public class AddWinnerLogic {
    /**
     * @param userId
     * @param vacancyId
     * @throws LogicException
     */
    public static void addWinner(int userId, int vacancyId) throws LogicException {
        try {
            UserDAO.addWinner(userId,vacancyId);
        } catch (DAOException e) {
            throw new LogicException("Error add winner",e);
        }
    }
}
