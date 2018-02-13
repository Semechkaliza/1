package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.UserDAO;

/**
 * Logic to add approved command
 */
public class AddApprovedLogic {
    /**
     * @param userId
     * @param vacancyId
     * @throws LogicException
     */
    public static void addApproved(int userId, int vacancyId) throws LogicException {
        try {
            UserDAO.addApproved(userId, vacancyId);
        } catch (DAOException e) {
            throw new LogicException("Error add approved", e);
        }
    }
}
