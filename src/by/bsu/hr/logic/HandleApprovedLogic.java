package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.UserDAO;

/**
 * Logic o handle approved command
 */
public class HandleApprovedLogic {
    /**
     * @param user
     * @param vacancy
     * @throws LogicException
     */
    public static void handleApproved(int user, int vacancy) throws LogicException {
        try {
            UserDAO.handleApproved(user, vacancy);
        } catch (DAOException e) {
            throw new LogicException("Error handle approved", e);
        }
    }
}
