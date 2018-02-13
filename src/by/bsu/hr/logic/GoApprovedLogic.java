package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.UserDAO;
import by.bsu.hr.entity.Approved;

import java.util.List;

/**
 * Logic to go to approved page command
 */
public class GoApprovedLogic {
    /**
     * @return List of Approved candidates
     * @throws LogicException
     */
    public static List<Approved> findApproved() throws LogicException {
        try {
            return UserDAO.findApproved();
        } catch (DAOException e) {
            throw new LogicException("Error find approved", e);
        }
    }
}
